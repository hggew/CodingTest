import java.io.*;
import java.util.*;

public class Main {

	static int n;	//방의 개수
	static int map[][]; //인접 행렬
	static long distance;	//입구에서 가장 먼 방까지의 거리

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		//인접행렬 입력 : 방과 방 사이의 거리 입력
		map = new int[n][n];
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = c;
			map[b][a] = c;
		}

		boolean[] visited = new boolean[n]; //방문배열
		visited[0] = true; 	// 입구 방문처리
		distance = 0;		// 입구에서 가장 먼 방까지의 거리 초기화
		findDistance(0, 0, visited);	//입구에서 가장 먼 방까지 거리 구하기
		System.out.println(distance);	

	}

	// dfs로 가장 먼 방의 거리 구하기
	static void findDistance(int now, long dis, boolean[] visited) {
		//이제까지의 거리보다 현재 위치까지의 거리가 더 멀다면 거리 갱신
		if (distance < dis) 
			distance = dis; 

		for (int i = 0; i < n; i++) {
			if (map[now][i] != 0 && !visited[i]) {
				visited[i] = true;
				dis += map[now][i];
				findDistance(i, dis, visited);
				dis -= map[now][i];
				visited[i] = false;
			}
		}

		
	}
}
 