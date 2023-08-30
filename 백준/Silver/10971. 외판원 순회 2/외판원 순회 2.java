import java.io.*;
import java.util.*;

public class Main {

	static int[][] w;
	static int n, minCost, nowCost, start;	//도시수, 최소비용, 현재비용, 시작도시
	static boolean[] isVisited;	//방문여부

	static void calCost(int city, int cnt) {
		//모든 도시를 방문했다면 최소비용 갱신
		if(cnt == n) {
			if(minCost > nowCost)
				minCost = nowCost;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			//현재 도시와 다음 도시가 같은 도시이거나, 다음 도시가 방문했던 도시라면 건너뛰기
			if (i == city || isVisited[i])
				continue;
			//다음 도시가 처음 시작도시면서 마지막 방문도시가 아닐 경우 건너뛰기 
			if(cnt!=n-1 && i == start)
				continue;
			
			//다음 도시까지 연결되어 있다면 비용 계산
			if (w[city][i] != 0) {
				nowCost += w[city][i];
				isVisited[i] = true;
				calCost(i, cnt+1);
				nowCost -= w[city][i];
				isVisited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 도시의 수

		// 가중치 행렬 입력
		w = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		isVisited = new boolean[n];
		minCost = Integer.MAX_VALUE;
		//모든 도시를 한 번씩 시작도시로 만들어서 순회
		for (int i = 0; i < n; i++) {
			nowCost = 0;	//현재 비용 초기화
			start = i;		//시작도시 번호 저장
			calCost(i, 0);
		}
		
		System.out.println(minCost);
	}
}