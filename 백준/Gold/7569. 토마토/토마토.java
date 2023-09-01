import java.io.*;
import java.util.*;

public class Main {

	static int m, n, h;
	static int cnt;	//익은 토마토or 빈칸의 개수
	static int[][][] tomato;
	// 우 하 좌 상 윗칸 아랫칸
	static int[] dx = { 0, 1, 0, -1, 0, 0 };
	static int[] dy = { 1, 0, -1, 0, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };
	static Deque<Point> nowQ, nextQ;//어제 익은 토마토좌표, 오늘 익은 토마토 좌표

	static void makeRipeTomato() {
		//어제 익은 토마토 탐색
		while (!nowQ.isEmpty()) {
			Point now = nowQ.poll(); 
			for (int i = 0; i < 6; i++) {
				int nh = now.h + dh[i];
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				//새로운 좌표가 창고 크기 범위 내에 있다면 탐색
				if (0 <= nx && nx < n && 0 <= ny && ny < m && 0 <= nh && nh < h) {
					//새로운 좌표의 토마토가 안익은 상태라면 오늘익은토마토에 추가
					if (tomato[nh][nx][ny] == 0) {
						nextQ.add(new Point(nx, ny, nh));
						tomato[nh][nx][ny] = 1;
						cnt++;	//익은 토마토 추가
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
		cnt = 0;

		// 토마토 입력
		tomato = new int[h][n][m];
		nowQ = new ArrayDeque<>();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					cnt++;	
					//현재 익은 토마토의 좌표 저장
					if (tomato[i][j][k] == 1) 
						nowQ.add(new Point(j, k, i));
					// 현재 위치가 익지않은 토마토면 false
					if (tomato[i][j][k] == 0) 				
						cnt--;	//익은토마토의 개수에서 1 빼기
				}
			}
		}

		// 모든 토마토가 익은 상태라면 0 출력 후 종료
		if (cnt == n*m*h) {
			System.out.println(0);
			return;
		}
 
		int day = 0;	//토마토가 모두 익는데 걸리는 시간
		//어제 익은 토마토 모두 탐색
		while (!nowQ.isEmpty()) {
			nextQ = new ArrayDeque<>();	//오늘 익은 토마토 좌표 초기화
			makeRipeTomato();
			//오늘 익게 될 토마토가 없다면 종료
			if(nextQ.isEmpty())
				break;
			day++;	//날짜 추가
			nowQ = nextQ;//어제 익은 토마토를 오늘 익은 토마토 좌표로 변경
		}
        
		// 모든 토마토가 익은 상태라면 토마토가 익는데 걸린 시간 출력
		if(cnt == n*m*h)
			System.out.println(day);
		// 익지 않은 토마토가 있다면 -1 출력
		else
			System.out.println(-1);
	}
}
