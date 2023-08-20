import java.util.*;
import java.io.*;

public class Main {

	static int r, c, maxCount;
	static char[][] board;	//보드. 각 칸의 알파벳 저장
	static boolean[][] isVisited;	//탐색 시 방문처리에 사용	
	static Set<Character> alphabet;	//방문한 알파벳 저장
	// 우 하 상 좌
	static int[] dr = { 0, 1, -1, 0 };
	static int[] dc = { 1, 0, 0, -1 };
	static Deque<Node> q;

	static void dfs() {
		while (!q.isEmpty()) {
			Node now = q.poll();	//현재 좌표를 기준으로 사방탐색
			for (int i = 0; i < 4; i++) {
				//새로운 좌표 구하기
				int newX = now.x + dr[i];
				int newY = now.y + dc[i];
				if (checkIndex(newX, newY) && !alphabet.contains(board[newX][newY]) ) {
					q.offer(new Node(newX, newY));
					alphabet.add(board[newX][newY]);
					isVisited[newX][newY] = true;	//방문처리
					maxCount = maxCount < alphabet.size() ? alphabet.size() : maxCount;		//최고값 갱신
					dfs();	//큐에 넣은 현재 좌표를 기준으로 다시 탐색
					isVisited[newX][newY] = false;	//현재 좌표를 기준으로 탐색이 끝났다면 방문처리 해제
					alphabet.remove(board[newX][newY]);	//알파벳 집합에서도 제거
					
				}
			}
		}
	}

	// 탐색 시 좌표가 보드 위에 있는지 이미 방문했던 좌표인지 확인하는 함수
	static boolean checkIndex(int x, int y) {
		if (0 <= x && x < r && 0 <= y && y < c && !isVisited[x][y])
			return true;
		return false;
	}

	//큐에 넣을 좌표값 정보를 가진 노드 클래스
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

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		//보드 입력
		board = new char[r][c];
		for (int i = 0; i < r; i++) {
			board[i] = br.readLine().toCharArray();
		}

		alphabet = new HashSet<>();
		isVisited = new boolean[r][c];
		q = new ArrayDeque<>();
		//0,0 값 큐에 넣기
		q.offer(new Node(0, 0));
		isVisited[0][0] = true;
		alphabet.add(board[0][0]);
		maxCount = 1;	//최고값 1로 설정
		dfs();
		
		System.out.println(maxCount);
		 
	}
}
