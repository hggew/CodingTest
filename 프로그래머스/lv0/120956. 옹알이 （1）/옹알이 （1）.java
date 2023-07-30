class Solution {
    	public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma" };
        
        //babbling의 각 문자열에서 word가 있으면 공백으로 바꾸기
        for (int i = 0; i < babbling.length; i++) {
			for (String st : word) {
				babbling[i] = babbling[i].replace(st, " ");
			}
		}
        
        //babbling의 공백을 빈 문자열로 바꾸고 babbling의 각 문자열이 빈 문자열이라면 answert++
        for (String st : babbling) {
//        	System.out.println(st);
        	st = st.replace(" ","");
			if(st.equals(""))
				answer++;
		}
        
		return answer;
	}
}