
class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
		for (int i = 0; i < quiz.length; i++) {
			String[] num = quiz[i].split(" ");
			int x = Integer.parseInt(num[0]);
			char op = num[1].charAt(0);
			int y = Integer.parseInt(num[2]);
			int z = Integer.parseInt(num[4]);

			if (op == '-') {
				if (x - y == z) {
					answer[i] = "O";
				} else {
					answer[i] = "X";
				}
			} else {
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