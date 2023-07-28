class Solution {
    public static int solution(String s) {
		int answer = 0;
		
		//임시 문자열 temp에 영단어->숫자로 변환한 값 저장
		String temp = s.replace("zero", "0");
		temp = temp.replace("one", "1");
		temp = temp.replace("two", "2");
		temp = temp.replace("three", "3");
		temp = temp.replace("four", "4");
		temp = temp.replace("five", "5");
		temp = temp.replace("six", "6");
		temp = temp.replace("seven", "7");
		temp = temp.replace("eight", "8");
		temp = temp.replace("nine", "9");

		//문자열 int형으로 변환
		answer = Integer.parseInt(temp);

		return answer;
	}
}