import java.io.*;
import java.util.*;

public class Main {

	static int[][] sudoku = new int[9][9];
	static boolean isAllFill;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int match = 0;
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(line.substring(j, j + 1));
				if (sudoku[i][j] != 0)
					match++;
			}
		}

		isAllFill = false;
		fillSudoku(0, 0, match);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}

	static void fillSudoku(int x, int y, int match) {
		//모든 스도쿠에 값이 넣어졌다면 isAllFill 플래그 설정
		if (match == 81) {
			isAllFill = true;
			return;
		}

		//y값이 9라면 다음 행 탐색
		if (y == 9) {
			y -= 9;
			x++;
		} 

		//현재 위치에 값이 있다면 다음 칸 탐색
		if (sudoku[x][y] != 0)
			fillSudoku(x, y + 1, match);
		else {
			// 넣을 수 있는 숫자 하나씩 넣고 다음 칸 확인하기
			for (int k = 1; k <= 9; k++) {
				// 유효성 체크
				if (!isValid(x, y, k)) {
					continue;
				}

				sudoku[x][y] = k;	//현재 위치에 현재 값 넣기
				fillSudoku(x, y + 1, match + 1); 	//다음 칸 탐색

				//모든 스도쿠가 채워졌다면 종료
				if (isAllFill)	
					return;
				//모든 스도쿠가 채워지지 않았다면 현재 위치에 0 넣기
				sudoku[x][y] = 0;
			}
		}

	}

	//행, 열, 3x3 박스를 탐색해서 n이 존재한다면 false 반환
	static boolean isValid(int x, int y, int n) {
		for (int k = 0; k < 9; k++) {
			// 행 열 탐색
			if (sudoku[x][k] == n || sudoku[k][y] == n) {
				return false;
			}
		}

		// 3x3 탐색
		int rStart = x / 3 * 3;
		int cStart = y / 3 * 3;

		for (int a = rStart; a < rStart + 3; a++) {
			for (int b = cStart; b < cStart + 3; b++) {
				if (sudoku[a][b] == n) {
					return false;
				}
			}
		}

		return true;
	}

}