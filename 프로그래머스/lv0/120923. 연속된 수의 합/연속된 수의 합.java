class Solution {
    public int[] solution(int num, int total) {
        //answer를 num의 길이만큼 할당
        int[] answer = new int[num];
		
        // total = firstNum*num + remainSum(0~num-1)
        // remainSum= total - 첫번째 n*num(개수)의 값 
        int remainSum = 0;
		for (int i = 0; i < num; i++) {
			remainSum += i;
		}
		
		// answer에 들어갈 숫자의 첫번째 값
		int firstNum = (total - remainSum) / num;

		// answer에 첫번째 숫자부터 1씩 더해가며 num번째 숫자까지 구하기
		for (int i = 0; i < num; i++) {
			answer[i] = i+firstNum;
		}	
        
        return answer;
    }
}