class Solution {
    public String[] solution(String[] quiz) {
        //퀴즈의 크기만큼 answer 할당
        String[] answer = new String[quiz.length];
		
        for (int i = 0; i < quiz.length; i++) {
        	//수식을 공백을 기준으로 잘라 num배열에 저장
        	String[] num = quiz[i].split(" ");
        	
        	//num 0번 째 값 = x
			int x = Integer.parseInt(num[0]);
			//num 1번 째 값 = 연산자
			char op = num[1].charAt(0);
			//num 2번 째 값 = y
			int y = Integer.parseInt(num[2]);
			//num 4번 째 값 = z
			int z = Integer.parseInt(num[4]);
 
			
			//뺄셈 수식일 경우
			if (op == '-') {
				if (x - y == z) {
					answer[i] = "O";
				} else {
					answer[i] = "X";
				}
			} else {  //덧셈 수식일 경우
				if (x + y == z) {
					answer[i] = "O";
				} else {
					answer[i] = "X";
				}
			}
        }
        return answer;
    }
}