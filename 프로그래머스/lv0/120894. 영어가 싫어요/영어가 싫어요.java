class Solution {
	public long solution(String numbers) {
		long answer = 0;

				//문자열 배열로 전환
		char[] chars = numbers.toCharArray();
		int nowNum = 0; //문자에 매칭되는 숫자를 저장할 변수
		int len = 0;	//문자열의 길이를 저장하는 변수. 배열 인덱스 조절에도 사용
		 
		//배열을 하나씩 확인함
		for (int i = 0; i < numbers.length(); i++) { 
			//문자가 zero일 경우. 길이=4. 숫자=0
			if (chars[i] == 'z') {
				len = 4;
				nowNum = 0;
			} 
			//문자가 one일 경우. 길이=3. 숫자=1
			else if (chars[i] == 'o') {
				len = 3;
				nowNum = 1;
			} else if (chars[i] == 't') {
				//문자가 two일 경우. 길이=3. 숫자=2
				if (chars[i + 1] == 'w') {
					len = 3;
					nowNum = 2;
				}
				//문자가 three 일 경우. 길이=5. 숫자=3
				else {
					len = 5;
					nowNum = 3;
				}
			} else if (chars[i] == 'f') {
				//문자가 four일 경우. 길이=4. 숫자=4
				if (chars[i + 1] == 'o') {
					len = 4;
					nowNum = 4;
				}
				//문자가 five일 경우. 길이=4. 숫자=5
				else {
					len = 4;
					nowNum = 5;
				}
			} else if (chars[i] == 's') {
				//문자가 six일 경우. 길이=3. 숫자=6
				if (chars[i + 1] == 'i') {
					len = 3;
					nowNum = 6;
				} 
				//문자가 seven일 경우. 길이=5. 숫자=7
				else {
					len = 5;
					nowNum = 7;
				}
			} 
			//문자가 eight일 경우. 길이=5. 숫자=8
			else if (chars[i] == 'e') {
				len = 5;
				nowNum = 8;
			} 
			//문자가 nine일 경우. 길이=4. 숫자=9
			else {
				len = 4;
				nowNum = 9;
			}
			i+=len-1; //배열의 인덱스 조절
			//문자열에 해당하는 숫자 추가
			answer = answer * 10 + nowNum; 

		}


		return answer;
	}
}
