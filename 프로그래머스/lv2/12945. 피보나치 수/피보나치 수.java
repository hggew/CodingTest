class Solution {
	//피보나치 수를 저장할 배열
    static int[] fibo;
	//피보나치 수를 찾는 함수 : 재귀 사용
	public static void findFibo(int i, int n) {
		if(i == n+1)
			return ;
		
        //f(n-1)+f(n-2)를 1234567로 나눈 나머지값을 배열에 저장
        //n의 수가 커질 수록 숫자가 너무 커지기때문에 연산 불가능
		fibo[i] = (fibo[i-1]+fibo[i-2]) % 1234567;
		
		findFibo(i+1, n);
		
	}
	
    public static int solution(int n) {
        int answer = 0;
        
        //n번째 피보나치수를 알아야하기 때문에 n+1만큼 배열할당
        fibo = new int[n+1];
        fibo[0] = 0;
        fibo[1] = 1;
        
        findFibo(2,n);
         
        //n번째 피보나치 수를 찾아 1234567로 나눈 나머지값 저장
        answer = fibo[n] ; 
        
        return answer;
    }
}