import java.io.*;
import java.util.*;

public class Main {

	static int w, h;
	static int[][] island;

	// 좌상부터 시계방향 탐색 : 좌상-상-우상-우-우하-하-좌하-좌
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static Deque<Integer> q = new ArrayDeque<>();
	static int count; // 각 테스트 케이스의 섬의 개수

	static void bfs() {
		// 인접 섬이 없을 때까지 반복
		while (!q.isEmpty()) {
			int now = q.poll(); // 현재 좌표 큐에서 꺼내기
			int x = island[now][0];
			int y = island[now][1];
			// 방문처리
			island[now][0] = -1;
			island[now][1] = -1;
			for (int i = 0; i < 8; i++) {
				int newX = x + dr[i];
				int newY = y + dc[i];
				for (int j = 0; j < island.length; j++) {
					if (island[j][0] == newX && island[j][1] == newY) 
						q.add(j);
				}
			}
		}
		count++; // 인접 섬들 탐색이 끝나면 섬의 개수 1 증가
	}  

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 지도 너비
			h = Integer.parseInt(st.nextToken()); // 지도 높이
			if (w == 0 && h == 0) // 지도 입력 종료
				break;
			
			island = new int[w * h][2]; // 섬의 정보. 초기 값을 모르므로 최대 크기로 지정
			int index = 0;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					if (st.nextToken().equals("1")) {
						island[index][0] = i;
						island[index][1] = j;
						index++;
					}
				}
			}
            
            //섬의 정보 크기에 맞춰서 잘라주기
			island = Arrays.copyOf(island, index);

			count = 0; // 섬의 개수 초기화
			// 지도를 탐색하며 섬을 발견하면 인접 섬 탐색
			for (int i = 0; i < index; i++) {
				if (island[i][0] != -1 && island[i][1] != -1) {
					q.add(i);
					bfs();
				}
			}
			sb.append(count).append("\n");
		} // while end
		System.out.println(sb.toString());
	}
}
