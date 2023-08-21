import java.io.*;
import java.util.*;

public class Main {

	static int n, part;
	static char[][] grid;
	static boolean[][] isVisited;

	// 좌 하 우 상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };

	static Deque<Node> q;

	static int bfs(int r, int c, int count) {
		q.offer(new Node(r, c));
		isVisited[r][c] = true;
		count++;
		part++;

		// 마지막 좌표가 될때까지 반복
		while (count != n * n) {
			Node now = q.poll();
			char color = grid[now.x][now.y]; // 현재 좌표의 색상
			for (int i = 0; i < 4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];

				if (checkIndex(nr, nc) && grid[nr][nc] == color && !isVisited[nr][nc]) {
					q.offer(new Node(nr, nc));
					isVisited[nr][nc] = true;
					count++;
				}
			}

			// 한 컬러의 좌표가 끝났다면 새로운 컬러로 탐색 시작
			if (q.isEmpty()) {
				findNextPos: for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (!isVisited[i][j]) {
							count = bfs(i, j, count);
							break findNextPos;
						}
					}
				}

			}
		} 
		return count;
	}

	// 다음 좌표가 그리드 위에 있는지 확인하는 함수
	static boolean checkIndex(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < n)
			return true;
		return false;
	}

	// 그리드의 좌표정보 저장
	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken()); // nxn 그리드
		grid = new char[n][n];

		for (int i = 0; i < n; i++) {
			grid[i] = br.readLine().toCharArray();
		}

		// 일반인 기준
		part = 0;
		isVisited = new boolean[n][n];
		q = new ArrayDeque<>();
		bfs(0, 0, 0);
		sb.append(part).append(" ");


		// 적록색약 기준
		// 그리드의 초록 -> 빨강으로 변경
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 'G')
					grid[i][j] = 'R';
			}
		}
		part = 0;
		isVisited = new boolean[n][n];
		q = new ArrayDeque<>();
		bfs(0, 0, 0);
		sb.append(part).append(" ");

 

		System.out.println(sb.toString());

	}

}
