import java.io.*;
import java.util.*;

public class Main {

	static int[][] costTable;
	static int[] cost; // 0번부터 시작. 각인덱스까지 집을 색칠했을 때의 비용 저장
	static int n; // 집의 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 집의 수

		// 색칠 비용 입력
		costTable = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(i==0) {
					costTable[i][j] = now;
				}
				else {
					if(j == 0)
						costTable[i][j] = now + Math.min(costTable[i-1][1], costTable[i-1][2]);
					else if(j == 1)
						costTable[i][j] = now + Math.min(costTable[i-1][0], costTable[i-1][2]);
					else if(j ==2)
						costTable[i][j] = now + Math.min(costTable[i-1][0], costTable[i-1][1]);
					
				}
			
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if(min > costTable[n-1][i])
				min = costTable[n-1][i];
		}
		
		System.out.println(min);

	}

}
