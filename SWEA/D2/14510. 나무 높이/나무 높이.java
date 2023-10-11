import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine()); // 나무의 수
			int days = 0;

			st = new StringTokenizer(br.readLine());
			int[] tree = new int[n];
			int max = 0;
			for (int i = 0; i < n; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max = max < tree[i] ? tree[i] : max;
			}
 
			int day1 = 0;
			int day2 = 0;
			for (int i = 0; i < n; i++) {
				if (tree[i] == max)
					continue;
				int need = max - tree[i];
//				days += (need / 3) * 2;
//				need %= 3;
				day2 += need / 2;
				day1 += need % 2;
			}
 

			if (day1 != 0 || day2 != 0) {
				if(day1 == day2) {
					days += day1*2;
				}
				else if ( day1 <day2) {
					days += day1 * 2;
					day2 -= day1;
					if(day2%3 ==0 )
						days += (day2/3)*4;
					else
						days += (day2/3)*4 + day2%3 +1;
				} else {
					days += day2 * 2;
					day1 -= day2;
					days += (day1 - 1) * 2 + 1;
				}
			}


			sb.append("#").append(t).append(" ").append(days).append("\n");
		}
		System.out.println(sb.toString());

	}
 
}