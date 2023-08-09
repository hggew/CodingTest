import java.util.*;

class Solution {

	static int m;
    static int n;
    static int count; //현재 영역의 크기를 저장
    static int maxSizeOfOneArea;
    
    //영역을 찾을 때 사용할 덱
	static Deque<int[]> q = new ArrayDeque<>();

    //같은 색을 가진 영역을 찾는 함수
	public static void findArea(int[][] picture) {
        //우하상좌 
        int[] dr = { 0, 1, -1, 0 };
        int[] dc = { 1, 0, 0, -1 };
        
        //덱이 비어있으면 같은 영역이 더이상 없으므로 함수 종료
        //현재 영역의 수와 기존 영역에서 최댓값인 영역수를 비교하여 최댓값 찾기
		if (q.isEmpty()) {
			maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
			count = 0;
			return;
		}
        //큐의 first를 꺼내서 현재 색깔(숫자)와 picture에서 인덱스 찾기
		int[] nowIndex = q.pollFirst();
		int nowNum = picture[nowIndex[0]][nowIndex[1]];
		picture[nowIndex[0]][nowIndex[1]] = 0; // 방문처리 
        
		//이미 방문한 노드여서 nowNum이 0이면 덱의 다음요소로 넘어감
		if (nowNum != 0) {
            //처음 방문하는 노드라면 우하상좌를 살피면서 같은 색을 가진 노드찾아서 큐에 저장
			for (int i = 0; i < 4; i++) {
				int x = nowIndex[0] + dr[i];
				int y = nowIndex[1] + dc[i]; 
				if (checkIndex(x, y) && picture[x][y] == nowNum) {
					int[] newIndex = { x, y }; 
					count += 1;
					q.add(newIndex); 
				}
			}
		}else {
			count--;
		}
        
        //다시 findArea를 호출해서 큐가 빌 때까지 반복
		findArea(picture);

	}

	// 인덱스가 크기를 넘어가지 않았는지 체크하는 함수
	public static boolean checkIndex(int x, int y) {
		if (0 <= x && x < m && 0 <= y && y < n)
			return true;
		return false;
	}

	public static int[] solution(int m, int n, int[][] picture) {
		
        int numberOfArea = 0;
	    
        //전역변수 초기화
        maxSizeOfOneArea = 0;
        numberOfArea = 0;
        count = 0;
		
        Solution.m = m;
		Solution.n = n;
       
        //큐에 넣을 현재 인덱스를 저장할 배열
		int[] index = new int[2];
        //picture배열을 순회하며 색이 있는 좌표 찾고 q에 추가 -> findArea 호출로 영역 찾기
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0) {
					numberOfArea++;
					count++;
					index[0] = i;
					index[1] = j;
					q.add(index); 
					findArea(picture);
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		 
		return answer;
	} 
}
 