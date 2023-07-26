class Solution {
    public String solution(String polynomial) {
        String answer = "";
      
        //다항식을 공백 기준으로 잘라서 배열에 저장
        String[] elements = polynomial.split(" ");
              
        int xSum = 0;  //일차식의 상수 합을 저장할 변수
        int nSum = 0;  //상수 합을 저장할 변수
        
        for (String st : elements) {
        	//1차항끼리 덧셈
			if(st.contains("x")) {
				String temp = st.replace("x", ""); //x를 없애서 상수만 남도록 함
				if(temp.equals("")) { //일차항의 상수가 1일 경우 
					xSum += 1;
				}else {  //일차항의 상수가 1이 아닐 경우
					xSum += Integer.valueOf(temp) ;
				}
			} 
			//상수항끼리 덧셈 - '+'기호인지 아닌지로 상수항 구분
			else if (!st.equals("+")) {
				nSum += Integer.valueOf(st);				
			}
        }
        
        //일차항 더하기
        if(xSum != 0) {
        	if(xSum != 1 ) {
        		answer += xSum;
        	}
        	answer += "x";
        } 
        
        //상수항 더하기
		if (nSum != 0) {			
			//이미 일차항이 있다면
			if (!answer.equals("")) {
				answer += " + ";
			}
			answer += nSum;
		}          
        
        return answer;
    }
}