import java.io.*;
import java.util.*;

public class Main { 
	static List<List<Integer>> tree;
	static boolean[] isVisited;
	
	static int bfs() {
		Deque<Integer> q = new ArrayDeque<>();
		int count = 0;
		q.add(1);
		isVisited[1] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < tree.get(now).size(); i++) {
				if ( isVisited[tree.get(now).get(i)])
					continue;
				else {
					q.add(tree.get(now).get(i));
					isVisited[tree.get(now).get(i)] = true;
					count+=1; 
				}
			} 
		}		
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		tree = new ArrayList<>();
		
		int n = Integer.parseInt(st.nextToken());	//컴퓨터의 수
		int edge = Integer.parseInt(br.readLine());	//간선 수
		
		//트리에 노드 설정
		for (int i = 0; i <= n; i++) {	//0번 제외하고 사용
			tree.add(new ArrayList<>());
		} 
		
		//트리 연결
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int e1 = Integer.parseInt(st.nextToken());
			int e2 = Integer.parseInt(st.nextToken());	
			tree.get(e1).add(e2);
			tree.get(e2).add(e1);
		}
		
		isVisited = new boolean[n+1];
		System.out.println(bfs());

		
	}
}