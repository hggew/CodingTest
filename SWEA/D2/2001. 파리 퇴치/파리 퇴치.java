import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			//파리 nxn 2차원배열 입력
			int[][] fly = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int sum = 0;
			//파리 죽이기
			for (int i = 0; i < n-m+1; i++) {
				for (int j = 0; j < n-m+1; j++) {
					int tempSum =0;
//					System.out.println("sum : " + sum+ " / "+i +" / "+j);
					for (int x = i; x < i+m; x++) {
						for (int y = j; y < j+m; y++) {
//							System.out.println((x) + "/"+ (y));
							tempSum += fly[x][y];
						}
					}
					if(sum < tempSum)
						sum= tempSum;
				}
			} 
			System.out.printf("#%d %d\n", t, sum);
		} 
	}

}
