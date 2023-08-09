import java.util.*;

class Solution {

	static int m=0;
    static int n= 0;
    static int count =0;
	static int maxSizeOfOneArea = 0;
    static int numberOfArea = 0;

	// 우 하 상 좌
	static int[] dr;
	static int[] dc;
	static Deque<int[]> q = new ArrayDeque<>();

	public static void findArea(int[][] copy) {
		if (q.isEmpty()) {
			maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
			count = 0;
			return;
		}
		int[] nowIndex = q.pollFirst();
		int nowNum = copy[nowIndex[0]][nowIndex[1]];
		copy[nowIndex[0]][nowIndex[1]] = 0; // 방문처리 
        
		//이미 방문한 노드여서 nowNum이 0이면 덱의 다음요소로 넘어감
		if (nowNum != 0) {
			for (int i = 0; i < 4; i++) {
				int x = nowIndex[0] + dr[i];
				int y = nowIndex[1] + dc[i]; 
				if (checkIndex(x, y) && copy[x][y] == nowNum) {
					int[] newIndex = { x, y }; 
					count += 1;
					q.add(newIndex); 
				}
			}
		}else {
			count--;
		}
		findArea(copy);

	}

	// 인덱스가 크기를 넘어가지 않았는지 체크하는 함수
	public static boolean checkIndex(int x, int y) {
		if (0 <= x && x < m && 0 <= y && y < n)
			return true;
		return false;
	}

	public static int[] solution(int m, int n, int[][] picture) {
		
	    maxSizeOfOneArea = 0;
        numberOfArea = 0;
        count = 0;
		
        Solution.m = m;
		Solution.n = n;
        dr = new int[4];
        dr[0]= 0;
        dr[1] = 1;
        dr[2]= -1;
        dr[3]= 0;
        dc = new int[4];
        dc[0]= 1;
        dc[1] = 0;
        dc[2]= 0;
        dc[3]=-1;
        
        int[][] copy = new int[m][n];
        for(int i = 0; i <m; i ++){
            for(int j = 0; j<n; j++){
                copy[i][j] = picture[i][j];
            }     
        }

		int[] index = new int[2];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (copy[i][j] != 0) {
					numberOfArea++;
					count++;
					index[0] = i;
					index[1] = j;
					q.add(index); 
					findArea(copy);
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		 
		return answer;
	} 
}
 