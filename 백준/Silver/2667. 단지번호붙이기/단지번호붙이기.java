import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	static boolean[][] isVisited;
	static int n, count;
	static List<Integer> house = new ArrayList<>();
	static Deque<Point> q = new ArrayDeque<>();
	// 우 하 좌 상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	static void bfs() {
		while (!q.isEmpty()) {
			Point now = new Point(q.peek().x, q.peek().y);
			q.poll();
			map[now.x][now.y] = 0; // 방문처리

			for (int i = 0; i < 4; i++) {
				int newX = now.x + dr[i];
				int newY = now.y + dc[i];
				if (checkIndex(newX, newY) && map[newX][newY] == '1' && !isVisited[newX][newY]) {
					isVisited[newX][newY] = true;
					count++;
					q.add(new Point(newX, newY));
				}
			}
		}
		
		house.add(count);
	}

	// 새로운 좌표가 단지 내에 있는지 확인하는 함수
	static boolean checkIndex(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < n)
			return true;
		return false;
	}

	// 단지내 집의 좌표 정보를 가지는 클래스
	static class Point {
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

		n = Integer.parseInt(st.nextToken()); // 지도 크기
		// 지도 입력
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String row = st.nextToken();
			map[i] = row.toCharArray();
		}
		
		isVisited = new boolean[n][n];	//방문여부 확인

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '1') {
					count = 1;
					q.add(new Point(i, j));
					isVisited[i][j] = true;
					bfs();
				}
			}
		}

		Collections.sort(house);
		sb.append(house.size()).append("\n");
		for (Integer i : house) {
			sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}
}
