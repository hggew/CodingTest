import java.io.*;
import java.util.*;

public class Main {
	static int[][] table;
	static boolean isAvailavle;

	static int[] me = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4 };
	static int[] you = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };

	static void func(int count) {
		if (count == 15) {
			isAvailavle = true;
			return;
		}
		int meIdx = me[count];
		int youIdx = you[count];

		// 승
		if (table[meIdx][0] > 0 && table[youIdx][2] > 0) {
			table[youIdx][2]--;
			table[meIdx][0]--;
			func(count + 1);
			table[youIdx][2]++;
			table[meIdx][0]++;

		}
		// 무
		if (table[meIdx][1] > 0 && table[youIdx][1] > 0) {
			table[youIdx][1]--;
			table[meIdx][1]--;
			func(count + 1);
			table[youIdx][1]++;
			table[meIdx][1]++;
		}
		// 패
		if (table[meIdx][2] > 0 && table[youIdx][0] > 0) {
			table[youIdx][0]--;
			table[meIdx][2]--;
			func(count + 1);
			table[youIdx][0]++;
			table[meIdx][2]++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		round: for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			table = new int[6][3]; // 결과 표
			int totalPlay = 0; // 라운드별 경기 수
			int play = 0; // 국가별 경기 수
			for (int j = 0; j < 6; j++) {
				int win = Integer.parseInt(st.nextToken());
				int draw = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());
				table[j][0] = win;
				table[j][1] = draw;
				table[j][2] = lose;
				totalPlay = totalPlay + win + draw + lose;
				play = win + draw + lose;
			}
			// 라운드의 경기가 30이 아니고 나라별 경기수가 5가 아니면 false
			if (totalPlay != 30 || play == 1) {
				sb.append(0).append(" ");
			} else {
				isAvailavle = false;
				func(0);
				if (isAvailavle) 
					sb.append(1).append(" ");
				else
					sb.append(0).append(" ");
			}

		}

		System.out.println(sb.toString());
	}
}
