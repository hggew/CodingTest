class Solution {
    public String[] solution(String[] picture, int k) {
        //picture 길이의 k배 만큼 할당
        String[] answer = new String[picture.length * k];
        
        int index = 0; //answer 배열에 사용되는 인덱스        
        
        for (String st : picture) {
        	//answer의 요소가 될 StringBuilder
			StringBuilder sb = new StringBuilder();
			//문자열의 문자 배열로 바꿔 문자 하나씩 확인  -> 가로 k배
        	for (char c : st.toCharArray()) {
        		//각 문자를 k번 만큼 반복
				for (int i = 0; i < k; i++) {
					sb.append(c);
				}
			}
        	
        	//가로k배가 완성된 문자열을 세로로 k배 해주기
        	for (int i = 0; i < k; i++) {
        		answer[index++] = sb.toString();     					
			}
		}
        
        return answer;
    }
}