class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
		int sum = 0;
		for (int i = 0; i < num; i++) {
			sum += i;
		}
		
		// answer에 들어갈 숫자의 첫번째 값
		// total = firstNum*num + sum(0~num-1)
		int firstNum = (total - sum) / num;

		// answer에 첫번째 숫자부터 1씩 더해가며 num번째 숫자까지 구하기
		for (int i = 0; i < num; i++) {
			answer[i] = i+firstNum;
		}	
		
		return answer;
    }
}