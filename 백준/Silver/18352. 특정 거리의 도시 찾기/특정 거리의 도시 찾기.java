import java.io.*;
import java.util.*;

public class Main {

	static List<Node>[] list;
	static int n, m;
	static class Node {
		int index;
		public Node(int next) {
			super();
			this.index = next;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); 	//도시 개수
		m = Integer.parseInt(st.nextToken());	//도로 개수
		int k = Integer.parseInt(st.nextToken());	//거리 정보
		int x = Integer.parseInt(st.nextToken())-1;	//출발 도시 번호
	
		//리스트 배열에 리스트 할당
		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 도로 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			list[a].add(new Node(b));
		}
		
		//다익스트라로 출발도시에서부터 최단거리 찾기
		int[] dist = Dijsktra(x);
		boolean flag = false; //거리정보와 일치하는 최단거리가 있는지 확인
		//최단거리 배열을 확인하며 거리정보와 일치하면 출력
		for (int i = 0; i < n; i++) {
			if(dist[i] == k) {
				System.out.println(i+1);
				flag = true;
			}
		}
		//거리정보와 일치하는 최단거리가 없다면 -1 출력
		if(!flag)
			System.out.println(-1);
	
	
	}
	
	static int[] Dijsktra(int start) {
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		boolean[] visited = new boolean[n];
		
		Deque<Node> q  = new ArrayDeque<>();
		q.add(new Node(start));
		while(!q.isEmpty()) {
			int now = q.poll().index;
			for (Node node : list[now]) {
				if(visited[node.index]) continue;
				
				if(dist[node.index] > dist[now]+1 ) {
					dist[node.index] = dist[now]+1;
					visited[node.index] = true;
					q.offer(new Node(node.index));
				}
			}
			
		}
		
		return dist;
		
		
	}
 

 
}