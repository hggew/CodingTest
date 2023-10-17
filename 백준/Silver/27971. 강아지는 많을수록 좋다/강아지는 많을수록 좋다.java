import java.io.*;
import java.util.*;

public class Main {

	static int n, m, a, b;  
	static int minMagic;	
	static int[][] range;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		//닫힌구간 입력
		range = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			range[i][0] = Integer.parseInt(st.nextToken());
			range[i][1] = Integer.parseInt(st.nextToken());
		}
		
		minMagic = Integer.MAX_VALUE; 
		getDogs();
		
		if(minMagic == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minMagic);

	}
	
	static void getDogs() {
		Deque<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n+1];
		q.offer(a);
		q.offer(b);
		int cnt = 2;
		visited[a] = visited[b] = true;
		
		int magic = 0;
		while(!q.isEmpty()) {
			int nextCnt = 0;
			loop :
			for (int i = 0; i < cnt; i++) {
				int now = q.poll();
				if(now == n) {
					minMagic = magic+1;
					return;
				}
				for (int j = 0; j < m; j++) {
					if(range[j][0] <= now && now <= range[j][1] )
						continue loop;
				}
				
				
				if(now+a <= n && !visited[now+a] ) {
					visited[now+a] = true;
					q.offer(now+a);
					nextCnt++;					
				}
				if( now+b <= n && !visited[now+b]) {
					visited[now+b] = true;
					q.offer(now+b);
					nextCnt++;					
				}
			}
			magic++;			
			cnt = nextCnt; 
		}
		
		
		
	}

}