import java.io.*;
import java.util.*;

public class Solution  {

	static Node[] nodeList;
	static boolean[] isVisited;	//방문 여부
	static Deque<Integer> q, last;	// last : 연락받은 모든 사람 순서대로 저장
	// max : 마지막에 연락받는 사람중 숫자가 큰 사람. count : 동시에 연락을 받는 사람 수
	static int max, count;	

	static void call(int cnt) { // cnt : 이전에 동시에 연락을 받았던 사람 수
		count = 0;	//동시에 연락을 받는 사람 수 
		for (int i = 0; i < cnt; i++) {
			int x = q.poll(); 
			// 동시에 연락하기
			for (Node temp = nodeList[x]; temp != null; temp = temp.next) {
				if (isVisited[temp.vertex])
					continue;
				q.offer(temp.vertex);
				last.offer(temp.vertex);
				isVisited[temp.vertex] = true;
				count++;
			}
		}
		// 현재 연락한 사람이 아무도 없는 경우 -> 현재가 마지막으로 연락받은 사람일 경우
		// 이전에 동시연락횟수만큼 last에서 번호를 확인하며 가장 큰 번호 찾기
		if(count == 0) {
			for (int i = 0; i < cnt; i++) {
				int num = last.pollLast();
				if (max < num)
					max = num;
			}
			return;
		} 
		
		call(count); // 다음으로 연락하기
	}

	public static class Node {
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 비상연락망 수
			int start = Integer.parseInt(st.nextToken()) - 1; // 시작점

			// 연결리스트 생성
			nodeList = new Node[100];	//연락인원은 최대 100명
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken()) - 1;	//연락을 하는 사람
				int to = Integer.parseInt(st.nextToken()) - 1;		//연락을 받는 사람
				nodeList[from] = new Node(to, nodeList[from]);
			}
  
			q = new ArrayDeque<>();
			last = new ArrayDeque<>();
			isVisited = new boolean[100];	
			max = 0;	
			q.add(start);
			last.offer(start);
			isVisited[start] = true;
			call(1);

			sb.append(max + 1).append("\n");
		}
		System.out.println(sb.toString());
	}
}
