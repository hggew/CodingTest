class Solution {
    public int solution(int[] common) {
        int answer = 0;
		int mode = 0; // mode 0 : 등차, mode 1 : 등비

		// 1번원소와 0번 요소의 차이
		int dif = common[1] - common[0];

		// 배열에 사용할 인덱스
		int index = 2;

		// 배열의 길이만큼 반복
		while (index < common.length) {
			// 등차수열이라면 모드=0
			if (dif == common[index] - common[index - 1]) {
				mode = 0;
			}
			// 등비수열이라면 모드=1
			else {
				dif = common[index] / common[index - 1];
				mode = 1;
			}
			index++;
		}

		// 등차수열, 등비수열일 때 answer 계산
		if (mode == 0) {
			answer = common[common.length - 1] + dif;
		} else {
			answer = common[common.length - 1] * dif;
		}
        
        return answer;
    }
}