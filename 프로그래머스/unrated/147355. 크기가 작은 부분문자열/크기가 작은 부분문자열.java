class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        //입력받은 문자열 p를 숫자로 변환
        long pNum = Long.parseLong(p);
        
        for (int i = 0; i < t.length()- p.length()+1; i++) {
        	//문자열 t를 p길이만큼 잘라서 숫자로 변환
        	String temp = t.substring(i, i+p.length());
			Long tempNum = Long.parseLong(temp);
//			System.out.println(temp + "/"+ tempNum);
			answer += tempNum <= pNum ? 1:0;
		} 
        return answer;
    }
}