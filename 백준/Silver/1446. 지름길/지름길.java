import java.io.*;
import java.util.*;

public class Main {
	static List<Node> graph; // 인접리스트

	static class Node {
		int start, end; // 지름길의 시작점, 끝점
		int cost; // 지긂길 길이

		public Node(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());	// 지름길 개수 
		int d = Integer.parseInt(st.nextToken());	// 도착위치 = 고속도로의 길이

		graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); //지름길 시작
			int e = Integer.parseInt(st.nextToken()); //지름길 끝
			int c = Integer.parseInt(st.nextToken()); //지름길 길이
			if (e > d) // 지름길의 끝이 도착위치보다 멀다면 패스
				continue;
			graph.add(new Node(s, e, c)); // 인접리스트에 추가
		}

		// 인접리스트 시작점 내림차순, 끝점 내림차순 정렬
		Collections.sort(graph, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if (o1.start == o2.start)
					return o1.end - o2.end;
				return o1.start - o2.start;
			}
		});

		//다익스트라 
		Dijkstra(d, 0);

	}

	private static void Dijkstra(int d, int start) {
		boolean[] visited = new boolean[d + 1];
		int[] dist = new int[d + 1];
		int INF = Integer.MAX_VALUE;

		Arrays.fill(dist, INF);// 거리 배열 무한대로 초기화
		dist[start] = 0;

		int idx = 0;
		int move = 0;

		while (move < d) {
			//인접리스트(지름길) 비교
			if (idx < graph.size()) {
				Node now = graph.get(idx);
				// 현재 위치가 인접리스트에 있는 시작점과 같다면 지름길과 그냥 길 비교
				if (move == now.start) {
					dist[now.end] = Math.min(dist[move] + now.cost, dist[now.end]);
					idx++;
				}
				// 현재 위치가 인접리스트에 없다면 최소거리(dist)와 그냥 길 비교
				else {
					dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
					move++;
				}
			} 
			//모든 인접리스트를 다 확인했다면 최소거리(dist)와 그냥 길 비교
			else {
				dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
				move++;
			}
		}

		//최소 운전거리 출력
		System.out.println(dist[d]);
	}
}