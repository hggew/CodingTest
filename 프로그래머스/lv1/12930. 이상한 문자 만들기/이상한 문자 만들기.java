class Solution {
    public String solution(String s) {
        String answer = "";
        //인덱스의 짝수, 홀수 판별할 변수. 짝수-0 홀수 -1
        int mode = 0;
        for(int i = 0; i <s.length(); i++) {
        	//공백일 경우 문자열에 추가하고 다음 문자 확인
        	if(s.charAt(i) == ' ') {
        		answer += s.charAt(i);
        		mode = 0;
        	}
        	// 짝수일 경우 대문자로 
        	else if(mode == 0) {
        		answer += s.toUpperCase().charAt(i);
        		mode++;
        	}
        	// 홀수일 경우 소문자로
        	else {
        		answer += s.toLowerCase().charAt(i);
        		mode--;
        	}
        	
        	
        }
        
        return answer;
    }
}