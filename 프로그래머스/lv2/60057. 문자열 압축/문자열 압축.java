class Solution {
   public int solution(String s) {
        int answer = 1000;	//초기값. 입력받을 수 있는 문자열의 최대 길이
        
        int len = s.length();	//입력받은 문자열의 길이
        
        //문자열을 1부터 len만큼 잘라보기
        for (int i = 1; i <= len; i++) {
			String sub = s.substring(0,i);	//처음 i길이만큼의 문자열
			String result = "";	//문자열을 압축하여 표현
			int cnt = 0;	//i길이만큼의 문자열이 반복되는 횟수
			//문자열을 i길이만큼 잘라가며 탐색
			for (int j = 0; j < len; j+=i) {
				//문자열의 마지막은 i길이만큼 나누어떨어지지 않을 수 있으므로 subString의 endIndex를 문자열의 길이와 i길이 중 작은 값으로 선택
				String now = s.substring(j,Math.min(j+i, len));	
				//현재 자른 문자열이 앞선 자른 문자열과 같다면 cnt++
				if(sub.equals(now))
					cnt++;
				//현재 자른 문자열이 앞서 자른 문자열과 다르다면 result에 압축된횟수와 문자열을 추가
				else {
					if(cnt <= 1)
						result += sub;
					else
						result = result+ cnt + sub;
					cnt = 1;
					sub = now;
				}
			}
			//마지막으로 자른 문자열의 경우 result에 추가되지 않으므로 여기서 추가함
        	if(cnt <= 1)
				result += sub;
			else
				result = result+ cnt + sub;
        	
        	//최소 압축 길이 갱신
        	answer = answer > result.length() ? result.length() : answer;
		}
        
        return answer;
    }
}