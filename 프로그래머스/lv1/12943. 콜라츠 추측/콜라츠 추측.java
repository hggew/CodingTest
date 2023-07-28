class Solution {
    public int solution(long num) {
        //작업 반복 횟수
    	int answer = 0;
        
        //주어진 수가 1일 경우 0반환
        if (num == 1)
        	return answer;
        
        while(answer < 500) {
        	//주어진 수가 짝수일 경우
        	if(num%2 == 0) {
        		num /= 2;
        	} 
        	//주어진 수가 홀수일 경우
        	else {
        		num = num*3+1;        		
        	}
        	
        	//작업 횟수 증가
        	answer++;
        	
        	//주어진 수가 1이 되면 작업 횟수 반환
        	if(num == 1)
        		return answer;
        	
        }
        
        //작업횟수가 500이 넘으면 -1 반환
        return -1;
    }
}