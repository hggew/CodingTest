import java.io.*;
import java.util.*;

public class Main {

	static int m, n, h;
	static int[][][] tomato;
	// 우 하 좌 상 윗칸 아랫칸
	static int[] dx = { 0, 1, 0, -1, 0, 0 };
	static int[] dy = { 1, 0, -1, 0, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };
	static Deque<Point> nowQ, nextQ;

	static void makeRipeTomato() {
		while (!nowQ.isEmpty()) {
			Point now = nowQ.poll(); // 현재 좌표는 무조건 익은 토마토
			for (int i = 0; i < 6; i++) {
				int nh = now.h + dh[i];
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m && 0 <= nh && nh < h) {
					if (tomato[nh][nx][ny] == 0) {
						nextQ.add(new Point(nx, ny, nh));
						tomato[nh][nx][ny] = 1;
					}
				}
			}
		}

	}

	// 삼차원 배열의 좌표 정보 저장
	static class Point {
		int x, y, h;

		public Point(int x, int y, int h) {
			super();
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken()); // 상자 가로칸 수
		n = Integer.parseInt(st.nextToken()); // 상자 세로칸 수
		h = Integer.parseInt(st.nextToken()); // 상자 수

		// 토마토 입력
		tomato = new int[h][n][m];
		nowQ = new ArrayDeque<>();
		boolean allRipe = true; // 모든 토마도가 익은 상태인치 체크. 초기값을 true로 두고 익지않은 토마토라면 false로 변경
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					// 현재 위치가 익지않은 토마토면 false
					if (tomato[i][j][k] == 0)
						allRipe = false;
					if (tomato[i][j][k] == 1) {
						nowQ.add(new Point(j, k, i));
					}

				}
			}
		}

		// 모든 토마토가 익은 상태라면 0 출력 후 종료
		if (allRipe) {
			System.out.println(0);
			return;
		}

//		for (int i = 0; i < h; i++) {
//			for (int j = 0; j < n; j++) {
//				for (int k = 0; k < m; k++) {
//					System.out.print(tomato[i][j][k]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("----");
//		}
		int day = 0;
		while (!nowQ.isEmpty()) {
			nextQ = new ArrayDeque<>();
			makeRipeTomato();
			if(nextQ.isEmpty())
				break;
			day++;
			nowQ = nextQ;
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if(tomato[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(day);

	}
}
