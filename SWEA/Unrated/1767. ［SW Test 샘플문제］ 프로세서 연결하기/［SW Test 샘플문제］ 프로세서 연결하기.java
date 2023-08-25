import java.io.*;
import java.util.*;

public class Solution {

	static int n, coreSize;
	static int maxCount, minWire;	//최대로 연결된 코어수, 최소로 연결된 전선길이
	static int[][] map, core;

	// 우 하 좌 상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	static void connecnt(int coreCnt, int[][] newMap, int wire, int coreCount) {
		//(현재까지 연결한코어수 + 앞으로 연결할 모든 코어수)가 최대로연결된 코어수보다 작을 경우 확인하지 않음
		if(coreSize - coreCnt + coreCount < maxCount)
			return;
		if(coreCnt == coreSize) {
			//전선이 0이 아닌경우를 제외하고 최대 연결일 때 최소전선길이 구하기
			if(wire == 0)
				return;
			//연결된 코어가 이전 최댓값과 같을 때 최소 전선 길이 갱신
			if(coreCount == maxCount) {
				if(wire < minWire) {
					minWire = wire;
				}					
			}
			//연결된 코어가 더 많을 경우 코어개수, 전선길이 갱신
			else if (coreCount > maxCount) {
				maxCount = coreCount;
				minWire = wire;
			}
			
			return;
		}
		//현재 코어를 좌우하상으로 전선 연결하기
		for (int i = 0; i < 4; i++) {
			int nr = core[coreCnt][0] + dr[i];
			int nc = core[coreCnt][1] + dc[i];
			
			int[][] temp = copyArr(newMap);			
			int nowWire = 0;	//현재코어, 현재 방향으로 연결한 전선의 길이
			
			//map을 벗어나면 전선 연결에 성공했다는 뜻
			while(checkIndex(nr, nc)) {
				// 경로 중에 코어나 다른 전선이 있다면 다음 코어 연결하기
				if(temp[nr][nc] != 0) {
					nowWire = 0;
					break;
				}
				
				//전선 연결하기
				temp[nr][nc] = 2;
				
				nowWire++;
				nr += dr[i];
				nc += dc[i];		
			}
			
			//한 방향으로 전선 연결했으면 다음 전선 연결하기
			if(nowWire == 0) 
				connecnt(coreCnt+1, temp, nowWire+wire, coreCount);
			else
				connecnt(coreCnt+1, temp, nowWire+wire, coreCount+1);
		}
		
	}
	
	//배열 복사하기
	static int[][] copyArr(int[][] arr){
		int[][] copy = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j]= arr[i][j];
			}
		}
		return copy;
	}
	
	//현재 좌표가 cell을 벗어나는지 확인하는 함수
	static boolean checkIndex(int x, int y) {
		if(0<= x && x <n && 0<= y && y <n)
			return true;
		return false;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine()); // cell 크기 nxn

			//전선을 연결해야하는 코어 배열. 코어 개수를 모르므로 최대 크기인 12로 지정
			core = new int[12][2];
			coreSize = 0;

			// 멕시노스 초기 상태 입력
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						// 벽에 붙어 있는 코어라면 코어 배열에 추가하지 않음
						if (i == 0 || i == n - 1 || j == 0 || j == n - 1)
							continue;
						core[coreSize][0] = i;
						core[coreSize++][1] = j;
					}
				}
			}
			//코어 배열을 코어 개수에 맞게 잘라주기
			core = Arrays.copyOf(core,coreSize);
 			
			minWire = Integer.MAX_VALUE;
			maxCount = 0;
			connecnt(0, map, 0, 0);
			
			// 연결할 수 있는 코어의 최대 개수가 0이라면 전선의 길이 0으로 저장
			if(maxCount == 0)
				minWire = 0;
			
			sb.append("#").append(t).append(" ").append(minWire).append("\n");
		}
		System.out.println(sb.toString());

	}
}
