public class Solution {

	static int[] boxNum, score;

	static int n, maxScore;
	static boolean[] isVisited;
	
	static void openBox(int start, int cnt, int[] card) {
		//처음 열어볼 상자 2개를 선택했다면 게임 시작
		if (cnt == 2) {
			//각 라운드의 1번그룹, 2번그룹 상자 수 초기화
			score[0] = 0; 
			score[1] = 0;
			isVisited= new boolean[n];	// 각 라운드 박스 방문 여부 초기화
			for (int i=0; i<2; i++) {
				int first = boxNum[i];          // 첫번째 박스 열기
				isVisited[first] = true;        // 첫번째 박스 방문 처리
				int next = card[boxNum[i]]-1;   // 다음으로 열어볼 박스 
				score[i]++;                     // 박스 열어본 횟수 증가
                //다음에 열어볼 박스가 첫번째 박스가 될 때까지 반복
				while(first!= next) {
					if(isVisited[next]) //다음에 열어볼 박스가 이미 방문한 박스라면 종료
						break;
					isVisited[next]= true;  //방문처리
					score[i]++;             
					if(score[i] == n)       //박스를 모두 열어봤다면 게임 종료. 점수 = 0
						return;
					next = card[next]-1;    //다음에 열어볼 박스 구하기
				}
			}
			//최고값 갱신
			maxScore = maxScore < score[0]*score[1] ? score[0]*score[1]: maxScore;
			return;
		}

        //상자를 열어볼 순서 조합 구하기
		for (int i = start; i < n; i++) {
			boxNum[cnt] = i;
			openBox(i+1, cnt+1, card);
		}

	}

	public static int solution(int[] cards) {

		boxNum = new int[2];    //박스를 열어볼 순서 배열
		score = new int[2];     //박스를 열어본 횟수를 저장할 배열
		maxScore = 0;           //게임 최고 점수
		n = cards.length;       //카드의 개수
		isVisited= new boolean[n];  // 각 라운드 박스 방문 여부 

		openBox(0,0, cards); 
		return maxScore;
	}
}