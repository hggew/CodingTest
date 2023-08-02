import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] snail = new int[n][n];
			int num = 1; //달팽이 배열에 넣을 숫자
	 
			 
			//달팽이 방향 배열 우 하 좌 상
			int[] dr = {0, 1, 0,  -1};
			int[] dc = {1, 0, -1, 0};
			int index = 0; //

			int r = 0;
			int c = 0;
			snail[r][c] = num++;
			
			while(num <= n*n) {  
				//달팽이 배열에서 값을 넣을 때 사용하는 인덱스
				int x = r + dr[index];
				int y = c + dc[index];
				//인덱스 범위 확인
				if( 0<= x && x < n && 0<= y && y<n ) {
					//달팽이가 비어있다면
					if(snail[x][y] == 0) {
						snail[x][y] = num++;
						//인덱스 갱신
 						r = x;
						c = y;
					}else { //방향전환
						index = (index+1)%4;						
					}
				}else { //방향전환
					index = (index+1)%4;
				}  
			}
			
			System.out.println("#"+t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
			
		}
		
	}

}
