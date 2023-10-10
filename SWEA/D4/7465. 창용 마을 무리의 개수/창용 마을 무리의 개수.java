import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());	// 테스트 케이스 
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());	// 마을 사람의 수
			int m = Integer.parseInt(st.nextToken());	// 서로 알고 있는 관계의 수

			// 인접 행렬
			int[][] matrix = new int[n][n];

			//m번 만큼 서로 알고 있는 두 사람의 번호 입력 -> 인접행렬에 표시
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				matrix[a][b] = 1;
				matrix[b][a] = 1;
			}
			
			boolean[] visited = new boolean[n];	// 방문 배열
			int group = 0; // 마을 무리의 수

			Deque<Integer> q = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				// 이미 확인한 사람의 번호라면 다음 사람 탐색
				if(visited[i])
					continue;
				
				q.offer(i);	// 큐에 넣기
				visited[i] = true;
				// 서로 알고 있는 관계가 끝날 때까지 탐색
				while(!q.isEmpty()) {
					int now = q.poll();
					for (int j = 0; j < n; j++) {
						// 이전 마을 사람이 알고 있는 관계라면 다음 사람 탐색
						if(visited[j])
							continue;
						// 이전 사람이 알지 못하면서 현재 사람이 아는 사람이라면 큐에 넣기
						if(matrix[now][j] == 1) {
							q.offer(j);
							visited[j] = true;
						}
					}			
				}
				
				// 관계 탐색이 끝났으면 무리의 수 증가
				group++;				
			}
			
			sb.append("#").append(t).append(" ").append(group).append("\n");
		}
		System.out.println(sb.toString());

	}
}