import java.io.*;
import java.util.*;

public class Main {

	static int r, c;
	static char[][] map;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static Deque<Point> q = new ArrayDeque<>();
	static int totalSheep, nowSheep, totalWolf, nowWolf;
	
	static void bfs(int x, int y) {
        q.add(new Point(x,y));
		while(!q.isEmpty()) {
			Point now = q.poll();
            if(map[now.x][now.y] =='#')
                continue;
			if(map[now.x][now.y] == 'o')
				nowSheep++;
			else if (map[now.x][now.y] == 'v')
				nowWolf++;
			map[now.x][now.y] = '#';	//방문처리
			for (int i = 0; i < 4; i++) {
				int newX = now.x + dr[i];
				int newY = now.y + dc[i];
				if(checkIndex(newX, newY) && map[newX][newY]!='#') {
					q.add(new Point(newX,newY));
				}	
			}
		}
//		System.out.println("s w" + nowSheep +" " + nowWolf);
		
		if(nowSheep > nowWolf) 
			totalSheep += nowSheep;
		else
			totalWolf += nowWolf;
		
	}
	
	
	static boolean checkIndex(int x, int y) {
		if(0<=x && x<r && 0<=y && y <c) 
			return true;
		return false;		
	}
	
	public static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		// 마당 입력
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] != '#') {
					nowSheep = 0;
					nowWolf = 0;
					bfs(i, j);
				}
			}
		}
		
		System.out.println(totalSheep +" " + totalWolf);
	}
}
