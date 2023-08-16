import java.io.*;
import java.util.*;

public class Main {
	
	static char[][] map;	//영상을 저장한 이차원 배열
	
	//영상을 압축하는 함수	
	//x: 영상탐색을 시작할 x좌표  y:영상탐색을 시작할 y좌표  n:영상탐색을 할 범위
	static void func(int x, int y, int n, StringBuilder sb) {
		
		char now = map[x][y];	//현재 영상 값
		int flag = 0;			//현재 영상 범위가 같은 값을 가지고 있는 체크하는 변수
		searchMap:
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				//현재 영상이 같은 값을 가지고 있지 않다면 영상 범위 분할
				// 1 2
				// 3 4
				if(map[i][j] != now ) {
					sb.append("(");
					func(x,y, n/2, sb);		//1범위	
					func(x,y+n/2, n/2, sb);	//2범위
					func(x+n/2,y, n/2, sb);	//3범위
					func(x+n/2,y+n/2, n/2, sb);	//4범위
					flag = 1;
					sb.append(")");	
					break searchMap;
				}
			}
		}
		//현재 영상 범위가 전부 같은 값이라면 현재값 sb에 추가
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
