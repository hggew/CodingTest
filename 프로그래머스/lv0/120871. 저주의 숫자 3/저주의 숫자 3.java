class Solution {
    public int solution(int n) {
        int answer = 0; // 결과값 저장할 변수
		int num = 1;	// 결과값을 찾기 위한 num. 1부터 시작.
		
		//1부터 시작해서 n까지 n번 반복하며 저주의 숫자를 피함
 		bigFor :
		for (int i = 1; i <= n; i++) {
			//10진법의 숫자가 3의 배수일 경우 
			if(num%3 == 0) {
				i--;
				num++;
				continue;
			}

			//10진법의 숫자에 3이 포함되어있는 경우
			//숫자 > 문자열 > 배열로 변환하여 숫자 한자리씩 3이 포함되어있는지 확인
			String strNum = Integer.toString(num);
			for (char c : strNum.toCharArray()) {
				if (c == '3') {
					i--;
					num++;
					continue bigFor;
				}
			}
			
			num++;
		}
		
		answer = num-1;

		return answer;
    }
}