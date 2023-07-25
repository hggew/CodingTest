class Solution {
    public String solution(int q, int r, String code){
        String answer = "";
        
        //문자열 배열로 변환
        char[] charArr = code.toCharArray();
	        
        for (int i = 0; i < charArr.length; i++) {
            //배열 인덱스를 q로 나눈 나머지 값이 r이라면, 문자를 answer에 추가
            if(i% q == r) {
                answer += charArr[i];
            }
        }
        
        return answer;
    }
	
}