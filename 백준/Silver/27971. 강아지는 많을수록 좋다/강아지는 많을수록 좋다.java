import java.io.*;
import java.util.*;

public class Main {

	static int n, m, a, b;  
	static int minMagic;	//최소 마법 횟수
	static int[][] range;	//닫힌구간 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());	// 원하는 강아지 수
		m = Integer.parseInt(st.nextToken());	// 닫힌 구간 수
		a = Integer.parseInt(st.nextToken());	// a마리 생성
		b = Integer.parseInt(st.nextToken());	// b마리 생성
		
		//닫힌구간 입력
		range = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			range[i][0] = Integer.parseInt(st.nextToken());
			range[i][1] = Integer.parseInt(st.nextToken());
		}
		
		minMagic = Integer.MAX_VALUE; 
		getDogs();
		
		//마법횟수 = int최대값 == n마리의 강아지를 구할 수 없음
		if(minMagic == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minMagic);

	}
	
	//bfs
	static void getDogs() {
		Deque<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n+1];	//방문배열 n번째 마리까지 생성
		q.offer(a);	//a마리 추가
		q.offer(b); //b마리 추가
		int cnt = 2; //이전에 마법을 사용해서 강아지를 추가한 경우의 수
		visited[a] = visited[b] = true;
		
		int magic = 0; // 마법을 사용한 횟수
		while(!q.isEmpty()) {
			int nextCnt = 0;  //현재 마법을 사용해서 강아지를 추가할 수 있는 경우의 수
			loop :
			for (int i = 0; i < cnt; i++) {
				int now = q.poll();
				//n마리 강아지를 구했다면 마법사용횟수 저장 후 함수 종료
				if(now == n) {
					minMagic = magic+1;
					return;
				}
				
				// 현재 강아지 수가 닫힌구간 내에 있는지 확인
				// 닫힌구간 내라면 다음 강아지 수 확인
				for (int j = 0; j < m; j++) {
					if(range[j][0] <= now && now <= range[j][1] )
						continue loop;
				}
				
				//현재 강아지수에서 +a 마리가 n마리 이하인지, 이전에 확인한 마리수인지 체크
				if(now+a <= n && !visited[now+a] ) {
					visited[now+a] = true; //방문처리
					q.offer(now+a);
					nextCnt++; //경우 수 추가					
				}
				if( now+b <= n && !visited[now+b]) {
					visited[now+b] = true; //방문처리
					q.offer(now+b);
					nextCnt++; //경우 수 추가					
				}
			}
			magic++; //마법사용횟수 증가			
			cnt = nextCnt; 
		}
		 
	}

}