class Solution {
    public String solution(String code) {
        String answer = "";
		int mode = 0;
		
		char[] codeArr = code.toCharArray();
		for (int i = 0; i < codeArr.length; i++) {
			//문자열이 1일 때 모드 변경
			if(codeArr[i] == '1') {
				mode++;
				continue;
			}
			if(mode%2 == 0 && i%2==0 ) {   //mode = 0 일 때
				answer += codeArr[i];
				
			}else if(mode%2==1 && i%2 == 1){ //mode = 1 일 때
				answer += codeArr[i];
			}
		}
		
		//answer 가 null 이면 EMPTY 추가
		if(answer.equals("")) 
			answer = "EMPTY";
		
		return answer;
    }
}