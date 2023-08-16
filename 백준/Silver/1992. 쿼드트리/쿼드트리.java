import java.io.*;
import java.util.*;

public class Main {
	
	static char[][] map;	//영상을 저장한 이차원 배열
	
	static void func(int x, int y, int n, StringBuilder sb) {
		
		char now = map[x][y];
		int flag = 0;
		searchMap:
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if(map[i][j] != now ) {
					sb.append("(");
					func(x,y, n/2, sb);
					func(x,y+n/2, n/2, sb);
					func(x+n/2,y, n/2, sb);
					func(x+n/2,y+n/2, n/2, sb);
					flag = 1;
					sb.append(")");
					break searchMap;
				}
			}
		}
		if(flag == 0) {
			sb.append(now);
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());

		// 영상 입력
 		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}
		
		//영상 압축
		func(0, 0, n, sb);
		//영상 압축 후 나온 결과 출력
		System.out.println(sb.toString());
	}
}
