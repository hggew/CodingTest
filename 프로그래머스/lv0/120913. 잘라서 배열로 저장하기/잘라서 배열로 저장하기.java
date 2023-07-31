class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = {};
        int index = 0; //answer에서 사용할 인덱스
        int strIndex = 0; //my_str에서 사용할 인덱스
        
        //answer 크기 할당 : my_str의 길이가 n의 배수라면 k배 할당, 아니라면 k배+1 할당
        if(my_str.length() % n == 0)
        	answer = new String[my_str.length()/n];
        else
        	answer = new String[my_str.length()/n + 1];
        
        
        while(strIndex < my_str.length() ) {
        	//my_str의 길이가 n의 배수가 아닐 때 마지막 남은 문자열 저장
        	if( my_str.length() - index*n < n) {
        		answer[index]= my_str.substring(strIndex,  my_str.length());
        		break;
        	}
        	//str.substring(start, end) : str의 start번째 문자부터 end-1번째 문자까지 자름
        	answer[index]= my_str.substring(strIndex, strIndex+n);
        	strIndex += n;
        	index++;
        	
        } 
        
        return answer;
    }
}