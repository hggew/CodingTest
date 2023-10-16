import java.io.*;
import java.util.*;

public class Main {

	static int n, map[][];
	static long distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = c;
			map[b][a] = c;
		}

		boolean[] visited = new boolean[n];
		visited[0] = true;
		distance = 0;
		findDistance(0, 0, visited);
		System.out.println(distance);

	}

	static void findDistance(int now, long dis, boolean[] visited) {
		if (distance < dis) {
			distance = dis; 
		}
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
 