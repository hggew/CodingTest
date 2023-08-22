import java.io.*;
import java.util.*;
 

public class Main {

	static boolean[] isVisited;
	static Node[] list;
	
	static boolean flag;

	static void dfs(int cnt, int start, int n) {
		if (cnt == 5) {
			flag = true;
			return;
		}
		
		for(Node temp = list[start]; temp!= null; temp= temp.next) {
			if(!isVisited[temp.vertex]) {
				isVisited[temp.vertex] = true;
				dfs(cnt+1, temp.vertex, n);
				isVisited[temp.vertex] = false;
			}
		}
	}

	public static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		} 
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 인접 리스트 입력
		list = new Node[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a] = new Node(b, list[a]);
			list[b] = new Node(a, list[b]);
		} 
		
		for (int i = 0; i < n; i++) {
			isVisited = new boolean[n];
			isVisited[i] = true;
			flag = false;
			dfs(1, i, n);
			if (flag) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);

	}
}
