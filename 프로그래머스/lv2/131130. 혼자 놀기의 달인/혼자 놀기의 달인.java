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
				 
				int first = boxNum[i];
				isVisited[first] = true;
				int next = card[boxNum[i]]-1;
				score[i]++;
				while(first!= next) {
					if(isVisited[next])
						break;
					isVisited[next]= true;
					score[i]++;
					if(score[i] == n)
						return;
					next = card[next]-1;
				}
			}
			//최고값 갱신
			maxScore = maxScore < score[0]*score[1] ? score[0]*score[1]: maxScore;
			 
			return;
		}

		for (int i = start; i < n; i++) {
			boxNum[cnt] = i;
			openBox(i+1, cnt+1, card);
		}

	}

	public static int solution(int[] cards) {

		boxNum = new int[2];
		score = new int[2];
		maxScore = 0;
		n = cards.length;
		isVisited= new boolean[n];

		openBox(0,0, cards); 
		return maxScore;
	}
}