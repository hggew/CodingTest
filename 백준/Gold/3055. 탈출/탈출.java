import java.io.*;
import java.util.*;

public class Main {

	static int r, c, time, nowtime;	//비버의 굴로 이동하는데 걸리는 시간 중 최소 시간, 현재까지 이동한 시간 
	static char[][] map;
	static Deque<Point> water, hedgehog;	//물, 고슴도치 위치 
	static boolean meetBeaver;
	static boolean[][] isHedgehogVisited;	//고슴도치가 방문한 여부 저장

	// 좌 하 우 상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	static void moveHedgehog( ) {
		nowtime = 1;
		//고슴도치가 더이상 이동할 수 없을 때까지 반복
		while(!hedgehog.isEmpty()) {
			//물 이동
			int waterLen = water.size();
			for (int i = 0; i < waterLen; i++) {
				Point wnow = water.poll();
				for (int j = 0; j < 4; j++) {
					int wr = wnow.x + dr[j];
					int wc = wnow.y + dc[j];
					//다음 좌표가 지도범위를 벗어나면 패스
					if(!checkIndex(wr, wc))
						continue;
					//다음 좌표가 이동가능하다면 큐에 넣고 지도에 물이동 표시
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
					//다음 좌표가 지도범위를 벗어나거나 이미 방문한 좌표라면 패스
					if(!checkIndex(hr,hc) || isHedgehogVisited[hr][hc])
						continue;
					//다음 좌표가 이동가능하다면 큐에 넣고 방문 처리
					if(map[hr][hc] == '.') {
						hedgehog.offer(new Point(hr,hc));
						isHedgehogVisited[hr][hc] = true;
					}
					//고슴도치가 비버를 만났다면 최소이동시간 갱신
					else if(map[hr][hc] == 'D') {
						meetBeaver = true;
						time = Math.min(time, nowtime); 
					}
				}
			}
			nowtime++;	//이동 시간 추가
		}
		 

	}

	//현재 좌표가 지도 범위 내에 있는지 확인하는 함수
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
				//현재 좌표가 물이면 water큐에 저장
				if(map[i][j] == '*')
					water.offer(new Point(i,j));
				//현재 좌표가 고슴도치면 hedgehog큐에 저장. 현재 좌표에 물이 이동할 수 있도록 빈칸으로 두기
				else if (map[i][j] == 'S') {
					map[i][j] = '.';
					hedgehog.offer(new Point(i, j));
				}
			}
		}
 
		time = Integer.MAX_VALUE;
		isHedgehogVisited = new boolean[r][c];	//방문배열 초기화
		moveHedgehog( );	//고슴도치, 물 이동
		
		//고슴도치가 비버를 만났다면 이동시간을 출력하고 아니라면 KAKTUS 출력
		if (meetBeaver) 
			System.out.println(time);
		else 
			System.out.println("KAKTUS");

	}
}