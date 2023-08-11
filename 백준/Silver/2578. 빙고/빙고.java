import java.io.*;
import java.util.*;

public class Main {
	
	static int bingoCount = 0;
	
	static void checkBingo(int[][] bingo) {
		int rowCount = 0;
		int colCount = 0;
		int lrCount = 0;
		int rlCount = 0;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(bingo[i][j]== 0) {
					rowCount++;
				}
				if(bingo[j][i]== 0)
					colCount++;
			}
			if(bingo[i][i] == 0)
				lrCount++;
			if(bingo[i][5-i-1] == 0)
				rlCount++;			
			
			if(rowCount == 5)
				bingoCount++;
			if(colCount == 5)
				bingoCount++;
			rowCount = 0;
			colCount = 0;
		}
		if(lrCount == 5)
			bingoCount++;
		if(rlCount == 5)
			bingoCount++;

		if(bingoCount<3)
			bingoCount=0; 
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		//빙고 입력
		int[][] bingo = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		int numOrder = 0;
		
		//사회자가 빙고 숫자 부르기 5번 반복
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int n = Integer.parseInt(st.nextToken());	//사회자가 부른 숫자
				//빙고에서 지우기
				removeNumInBingo:
				for (int x = 0; x < 5; x++) {
					for (int y = 0; y < 5; y++) {
						if(bingo[x][y] == n) {
							bingo[x][y]= 0;
							break removeNumInBingo;
						}
					}
				}
				if(i >1) {
					checkBingo(bingo);
					if(bingoCount>=3 && numOrder== 0) {
						numOrder=(i)*5+(j+1);
					}
				}
				
			}
		} 
		
		System.out.println(numOrder);
		
	}

}
