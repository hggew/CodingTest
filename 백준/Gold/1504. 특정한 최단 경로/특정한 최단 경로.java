import java.io.*;
import java.util.*;

public class Main {
	static int n, e;
	static int u, v;	//반드시 지나야하는 두 정점
	static List<Node>[] list;	//인접리스트 배열
	
	public static class Node implements Comparable<Node>{
		int end, cost;

		public Node(int end, int cost) {
			super();
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());	//정점 개수
		e = Integer.parseInt(st.nextToken());	//간선 개수
		
		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		
		//간선 입력
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
		}
		
		//반드시 지나야하는 두 정점 입력
		st = new StringTokenizer(br.readLine());
		u = Integer.parseInt(st.nextToken())-1;
		v = Integer.parseInt(st.nextToken())-1;
		
		if(list[u].size()==0 || list[v].size()==0) {
			System.out.println(-1);
			return;
		}
		
		
		int case1 = Dijkstra(0, u) + Dijkstra(u, v) + Dijkstra(v, n-1);
		int case2 = Dijkstra(0, v) + Dijkstra(v, u) + Dijkstra(u, n-1);
		if(case1<0 || case1==Integer.MAX_VALUE || case2 <0 || case2==Integer.MAX_VALUE) 
			System.out.println(-1);
		else
			System.out.println(Math.min(case1, case2));
		
//		System.out.println(case1 +" / " +case2 );

	}
	
	public static int Dijkstra(int start, int end) {
		
		int dist[] = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			int now = pq.poll().end;
			for (Node node : list[now]) {
				if(dist[node.end] > dist[now]+node.cost  ) {
					dist[node.end] = dist[now]+node.cost;
					pq.offer(new Node(node.end, dist[node.end]));
				}
			} 
		}
		return dist[end];
	}

 
}