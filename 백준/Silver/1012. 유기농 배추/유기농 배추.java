import java.io.*;
import java.util.*;

public class Main {
	// 우 하 좌 상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	static int n, m, k;
	static int[][] baechu;
	static int warm;

	static Deque<Integer> q;

	static void bfs() {
		// 큐가 빌 때까지 반복 -> 인접한 배추 탐색
		while (!q.isEmpty()) {
			int idx = q.poll();
			int now[] = { baechu[idx][0], baechu[idx][1] };
			// 방문처리
			baechu[idx][0] = -1;
			baechu[idx][1] = -1;
			for (int i = 0; i < 4; i++) {
				int[] newPos = { now[0] + dr[i], now[1] + dc[i] }; // 새로운 좌표
				//새로운 좌표가 배추배열에 있다면 큐에 추가
				for (int j = 0; j < k; j++) {
					if (baechu[j][0] == newPos[0] && baechu[j][1] == newPos[1]) {
						q.add(j);
					}

				}
			}
		}
		// 인접한 밭 탐색 종료. 지렁이 추가
		warm++;
	} 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken()); // 테스트케이스 입력
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken()); // 가로길이
			n = Integer.parseInt(st.nextToken()); // 세로길이
			k = Integer.parseInt(st.nextToken()); // 배추 위치

			// 배추 입력
			baechu = new int[k][2];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				baechu[i][0] = Integer.parseInt(st.nextToken()); // 배추 x좌표
				baechu[i][1] = Integer.parseInt(st.nextToken()); // 배추 y좌표
			}

			warm = 0; // 지렁이 개수 초기화
			q = new ArrayDeque<>(); // 큐 초기화
			// 인접한배추 확인
			for (int i = 0; i < k; i++) {
				if (baechu[i][0] != -1) {
					q.add(i);
					bfs();
				}
			}
			
			sb.append(warm).append("\n");
		}
		System.out.println(sb.toString());
	}
}
