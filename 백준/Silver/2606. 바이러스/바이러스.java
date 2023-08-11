import java.io.*;
import java.util.*;

public class Main { 
	static List<List<Integer>> tree;	//컴퓨터 연결을 저장하는 트리
	static boolean[] isVisited;			//bfs에서 사용. 방문처리 담당
	
	static int bfs() {
		Deque<Integer> q = new ArrayDeque<>();
		int count = 0;	//1번컴퓨터와 연결된 컴퓨터의 수
		q.add(1);
		isVisited[1] = true;
		while(!q.isEmpty()) {	//더이상 연결된 컴퓨터가 없을 때까지 반복
			int now = q.poll();
			//현재 컴퓨터와 연결되어있고 방문하지 않은 모든 컴퓨터 큐에 저장
			for (int i = 0; i < tree.get(now).size(); i++) {	
				//이미 방문한 컴퓨터라면 다음 컴퓨터 확인
				if ( isVisited[tree.get(now).get(i)])
					continue;
				//방문하지 않은 컴퓨터라면 큐에 추가. 방문처리. 1번컴퓨터와연결되어있는 숫자 증가
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