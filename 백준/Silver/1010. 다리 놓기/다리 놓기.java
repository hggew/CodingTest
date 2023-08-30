import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken()); // 테스트케이스 수
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// 동쪽, 서쪽에 사이트가 1개도 없다면 다리를 지을 수 없으므로 0 출력 후 다음 테스트케이스 확인
			if (n == 0 || m == 0) {
				sb.append(0).append("\n");
				continue;
			}

			int[][] dp = new int[m+1][m+1];
			for (int i = 0; i <= m; i++) {
				for (int j = 0; j <= Math.min(i, m); j++) {
					if(i==0 || j == 0 )
						dp[i][j] = 1;
					else
						dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
		
//			for (int i = 0; i <= m; i++) {
//				for (int j = 0; j <= Math.min(i, m); j++) {
//					System.out.print(dp[i][j]+ " ");
//				}
//				System.out.println();
//			}
			
			sb.append(dp[m][n]).append("\n");

		}
		System.out.println(sb.toString());
	}
}
