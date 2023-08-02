import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		//표 입력
		int[][] table = new int[n][n]; 		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(i == 0 && j == 0)
					table[i][j] = num;
				else if(i == 0) {
					table[i][j]= num + table[i][j-1];
				}
				else if(j == 0) {
					table[i][j] = num + table[i-1][j];
				}
				else {
					table[i][j] = num + table[i-1][j] + table[i][j-1] - table[i-1][j-1];
				}		
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			//실제 인덱스를 위해 -1
			int startX = Integer.parseInt(st.nextToken())-1;
			int startY = Integer.parseInt(st.nextToken())-1;
			int endX = Integer.parseInt(st.nextToken())-1;
			int endY = Integer.parseInt(st.nextToken())-1;
			
			//1 1  2 3
			//0 3  2 0
			int sum = table[endX][endY];
			if(startX != 0 && startY!=0) {
				sum -= table[endX ][startY - 1]; //세로줄빼기				
				sum -= table[startX - 1][endY];		//가로줄빼기
				sum += table[startX - 1][startY - 1];	//이중으로 빼진 부분 더하기
			}
			else if(startX != 0 ) {
				sum -= table[startX - 1][endY];		//가로줄빼기
			}else if (startY != 0 ) {
				sum -= table[endX][startY - 1]; //세로줄빼기				
			}
			
			System.out.println(sum);
			
		} 
		
	}
}
