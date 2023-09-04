import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int cnt, year;	//지도에서 빙산의 덩어리 수 , 빙산이 두 덩어리로 분리되는 년수
	static int[][] map;
	// 좌 하 우 상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static Deque<Point> ice, nextIce, q;
	static boolean[][] isVisited;
	
	static void checkTwoPart(int x, int y) {
		cnt++;
		q.offer(new Point(x, y, 1));
		isVisited[x][y]= true;
		while(!q.isEmpty()) {
			Point now = q.poll();		
			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if( 0<= nr && nr < n && 0<= nc && nc <m) {
					if(map[nr][nc] != 0 && !isVisited[nr][nc]) {
						isVisited[nr][nc] = true;
						q.offer(new Point(nr,nc, 1));
					}
				}
			}
		}
	}
	
	//주변 좌표가 0이면 녹은 빙산 정보 저장
	static void melting() {
		while(!ice.isEmpty()) {
			Point now = ice.poll();
			if(now.h == 0)
				continue;
			nextIce.offer(now);
			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if( 0<= nr && nr < n && 0<= nc && nc <m) {
					if(map[nr][nc] == 0) {
						if(nextIce.peekLast().h ==0)
							continue;
						nextIce.peekLast().h--;
					}
				}
			}
		}
	}
	
	//1년이 지난 후 지도 업데이트
	static void updateMap() {
		ice.clear();
		while(!nextIce.isEmpty()) {
			Point now = nextIce.poll();
			ice.offer(now);
			map[now.x][now.y] = now.h;
		}
	}
	

	//빙산의 좌표를 가진 클래스 : x,y좌표, 빙산 높이
	static class Point{
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

		n = Integer.parseInt(st.nextToken()); // 지도 행
		m = Integer.parseInt(st.nextToken()); // 지도 열

		ice = new ArrayDeque<>();	//빙산좌표
		// 지도 입력
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0)
					ice.offer(new Point(i,j, map[i][j]));
			}
		}

		while(!ice.isEmpty()) {
			nextIce = new ArrayDeque<>();
			q= new ArrayDeque<>();
			isVisited = new boolean[n][m];
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(map[i][j]!= 0 && !isVisited[i][j]) {
						checkTwoPart(i, j);						
					}
				}
			}
			if(cnt==0 ) {
				year = 0;
				break;
			}
			if(cnt >= 2)
				break;
			melting();		//빙산 녹이기
			updateMap();	//지도 업데이트
			year++;
		}
        
		System.out.println(year);

	}
}
