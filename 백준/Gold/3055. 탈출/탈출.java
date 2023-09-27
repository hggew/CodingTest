import java.io.*;
import java.util.*;

public class Main {

	static int r, c, time, nowtime;	//비버의 굴로 이동하는데 걸리는 시간
	static char[][] map;
	static Deque<Point> water, hedgehog;	//물, 고슴도치 위치
	static Point beaver; // 비버 위치
	static boolean meetBeaver;
	static boolean[][] isHedgehogVisited;

	// 좌 하 우 상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	static char[][] moveWater(char[][] nowMap) {
		water = new ArrayDeque<>();
		char temp[][] = new char[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp[i][j] = nowMap[i][j];
				if (temp[i][j] == '*')
					water.add(new Point(i, j));
			}
		}
		while (!water.isEmpty()) {
			Point now = water.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				if (checkIndex(nr, nc) && temp[nr][nc] != 'X' && temp[nr][nc] != 'D') {
					temp[nr][nc] = '*';
				}
			}
		}
		return temp;
	}

	static void moveHedgehog( ) {
		nowtime = 1;
		while(!hedgehog.isEmpty()) {
			//물 이동
			int waterLen = water.size();
			for (int i = 0; i < waterLen; i++) {
				Point wnow = water.poll();
				for (int j = 0; j < 4; j++) {
					int wr = wnow.x + dr[j];
					int wc = wnow.y + dc[j];
					if(!checkIndex(wr, wc))
						continue;
					if(map[wr][wc] == '.') {
						water.offer(new Point(wr,wc));
						map[wr][wc] = '*';
					}
				}
			}
			
			//고슴도치 이동
			int hLen = hedgehog.size();
			for (int i = 0; i < hLen; i++) {
				Point hnow = hedgehog.poll();
				for (int j = 0; j < 4; j++) {
					int hr = hnow.x + dr[j];
					int hc = hnow.y + dc[j];
					if(!checkIndex(hr,hc) || isHedgehogVisited[hr][hc])
						continue;
					if(map[hr][hc] == '.') {
						hedgehog.offer(new Point(hr,hc));
						isHedgehogVisited[hr][hc] = true;
					}
					else if(map[hr][hc] == 'D') {
						meetBeaver = true;
						time = Math.min(time, nowtime); 
					}
				}
			}
		
			nowtime++;
		}
		 

	}

	static boolean checkIndex(int x, int y) {
		if (0 <= x && x < r && 0 <= y && y < c)
			return true;
		return false;
	}

	// 좌표 저장 클래스
	static class Point {
		int x, y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken()); // 지도 행
		c = Integer.parseInt(st.nextToken()); // 지도 열

		// 지도 입력
		map = new char[r][c];
		water = new ArrayDeque<>();
		hedgehog= new ArrayDeque<>();
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
			for (int j = 0; j < c; j++) { 
				if (map[i][j] == 'D')
					beaver = new Point(i, j);
				else if(map[i][j] == '*')
					water.offer(new Point(i,j));
				else if (map[i][j] == 'S') {
					map[i][j] = '.';
					hedgehog.offer(new Point(i, j));
				}
			}
		}
 
		time = Integer.MAX_VALUE;
		isHedgehogVisited = new boolean[r][c];
		moveHedgehog( );
		if (meetBeaver) {
			System.out.println(time);
		} else {
			System.out.println("KAKTUS");
		}

	}
}