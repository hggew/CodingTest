import java.io.*;
import java.util.*;

public class Solution {
	static int w, h, minBlock;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken()); // 테스트케이스
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());	//구슬개수
			w = Integer.parseInt(st.nextToken());		//게임판 가로 길이
			h = Integer.parseInt(st.nextToken());		//게임판 세로 길이

			//게임판 입력
			arr = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			minBlock = Integer.MAX_VALUE;	//구슬을 다 쏘고 남은 벽돌의 개수 중 최소값
			shoot(n, arr);

			sb.append("#").append(t).append(" ");
			sb.append(minBlock).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	static void shoot(int n, int[][] map) {
		// 구슬을 다 쏘면 남은 벽돌 개수 구하기
		if (n == 0) {
			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] != 0)
						count++;
				}
			}
			minBlock = minBlock > count ? count : minBlock;
			return;
		} 

		// 가로줄 한번씩 다 쏴보기 -> 완탐
		for (int i = 0; i < w; i++) {
			// 지도 복사
			int[][] temp = copyMap(map);
			
			//현재 가로줄에서 블록이 있는 위치 찾기
			int j = 0;
			while (true) { 
				//현재 위치가 0이라면 아래 세로줄로 내려가서 블록 찾기
				if (temp[j][i] == 0)
					j++;
				else {
					break;
				}
				//현재 세로 줄에 남은 블록이 없다면 다음 가로줄로 넘어가기
				if(j==h) {
					//모든 게임판을 다 순회한 경우 = 게임판에 남은 블록이 없음 => 구슬 개수 0으로 만들기
					if(i==w-1) {
						shoot(0, map);
						n= 0;
						return;
					}
					i++;
					j=0;					
				}
			}

			removeBlock(j, i, temp[j][i] - 1, temp); // 블럭없애기 
			temp = rearrange(temp); // 게임판 재정렬 
			shoot(n - 1, temp); // 다음 구슬 쏘기

		}
	}

	//블럭을 제거하는 함수
	static void removeBlock(int r, int c, int num, int[][] temp) {

		// 가로줄 없애기
		for (int i = c - num; i <= c + num; i++) {
			//게임판 범위를 벗어나거나 현재 위치가 0이라면 다음칸 확인
			if (!checkIndex(r, i) || temp[r][i] == 0)
				continue;
			if (temp[r][i] != 1 && i != c)
				removeBlock(r, i, temp[r][i]-1, temp);

			// 내 칸 없애기
			temp[r][i] = 0;
		}

		// 세로줄 없애기
		for (int i = r - num; i <= r + num; i++) {
			//게임판 범위를 벗어나거나 현재 위치가 0이라면 다음칸 확인
			if (!checkIndex(i, c) || temp[i][c] == 0)
				continue;
			if (temp[i][c] != 1 && i != r)
				removeBlock(i, c, temp[i][c] - 1, temp);

			// 내 칸 없애기
			temp[i][c] = 0;
		}

	}

	// 밑에서부터 빈칸이 있다면 윗칸의 블록 내리기
	static int[][] rearrange(int[][] temp) {
		for (int j = 0; j < w; j++) {
			for (int i = h - 1; i >= 0; i--) {
				// 현재 위치가 0이라면
				if (temp[i][j] == 0) {
					// 윗칸의 블럭 찾기
					int up = i;
					while (temp[up][j] == 0) {
						if (up == 0)
							break;
						up--;
					}
					// 윗칸의 블록 현재 위치로 가져오기
					temp[i][j] = temp[up][j];
					temp[up][j] = 0;

				}
			}
		}
		return temp;	//재정렬된 배열 반환
	}

	// 현재 좌표가 게임판 범위 내에 있는지 확인하는 함수
	static boolean checkIndex(int x, int y) {
		if (0 <= x && x < h && 0 <= y && y < w)
			return true;
		return false;
	}

	// 게임판 배열 복사하는 함수
	static int[][] copyMap(int map[][]) {
		int[][] temp = new int[h][w];
		for (int a = 0; a < h; a++) {
			for (int b = 0; b < w; b++) {
				temp[a][b] = map[a][b];
			}
		}
		return temp;
	}

}