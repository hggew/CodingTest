import java.io.*;
import java.util.*;

public class Main {
	static int n, m, k;
	static int[][] arr; // nxm 배열
	static int[][] opInfo; // k개의 회전 연산 정보

	static int[] opOrder;
	static boolean[] isOpVisited;
	static int minArrValue; // 배열의 최솟값 저장
	static int x, y; // 배열 돌릴 때 시작 인덱스
	static int[][] copy; // 배열 회전시킬 때 사용. 원본배열 복사해서 사용

	// 시계 방향 : 우 하 좌 상
	final static int[] dr = { 0, 1, 0, -1 };
	final static int[] dc = { 1, 0, -1, 0 };

	static int[][] rotate(int r, int c, int rEnd, int cEnd) {

		int newR;
		int newC;
		int temp = copy[r][c]; // 현재 배열에서 원소
		int temp2 = 0; // 다음 원소
		int dir = 0;

		while (true) {
			newR = r + dr[dir];
			newC = c + dc[dir];
			// 방향 전환
			if (newR < x || newR >= rEnd + 1 || newC < y || newC >= cEnd + 1) {
				dir = (dir + 1) % 4;
			}

			r += dr[dir];
			c += dc[dir];
			temp2 = copy[r][c];
			copy[r][c] = temp;
			temp = temp2;

			if (r == x && c == y)
				break;
		} 
		return copy;
	}

	static void getOpOrder(int count) {
		if (count == k) {
			// 원본 배열을 복사해서 새로운 배열을 회전시킴.
			copy = new int[n][m];
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < m; b++) {
					copy[a][b] = arr[a][b];
				}
			}

			// 순서에 따라 배열 돌리기
			for (int i = 0; i < k; i++) {

				int r = opInfo[opOrder[i]][0];
				int c = opInfo[opOrder[i]][1];
				int s = opInfo[opOrder[i]][2];

				int newN = (r+s-1) - (r-s-1)+1;
				int newM = (c+s-1) - (c-s-1)+1;
				int cnt = Math.min(newN, newM ) / 2;
				// j로 인덱스 조절. 회전시키려는 일부 배열의 바깥상자 ->안쪽상자
				for (int j = 0; j < cnt; j++) {
					x = r - s - 1 + j;
					y = c - s - 1 + j;
					rotate(r - s - 1 + j, c - s - 1 + j, r + s - 1 - j, c + s - 1 - j);
				}

				
			}
			// 배열 다 돌리고 여기서 배열 행마다 합구해서 배열값구하기
			for (int j = 0; j < n; j++) {
				int sum = 0;
				for (int k = 0; k < m; k++) {
					sum += copy[j][k];
				}
				minArrValue = sum < minArrValue ? sum : minArrValue; // 최소 배열값 갱신
			} 
			return;
		}
		for (int i = 0; i < k; i++) {
			if (isOpVisited[i])
				continue;
			opOrder[count] = i;
			isOpVisited[i] = true; // 방문처리
			getOpOrder(count + 1);
			isOpVisited[i] = false; // 방문처리해제
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken()); // 배열 row
		m = Integer.parseInt(st.nextToken()); // 배열 col
		k = Integer.parseInt(st.nextToken()); // 회전 연산의 수

		// 배열 입력
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 회전 연산 정보 입력
		opInfo = new int[k][3]; // k개의 r,c,s
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				opInfo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		opOrder = new int[k];
		isOpVisited = new boolean[k];
		minArrValue = Integer.MAX_VALUE;
		getOpOrder(0);
 
		System.out.println(minArrValue);

	}

}