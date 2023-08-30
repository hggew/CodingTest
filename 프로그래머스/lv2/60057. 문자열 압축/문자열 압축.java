class Solution {
   public static int solution(String s) {
        int answer = 1000;
        
        int len = s.length();
        
        for (int i = 1; i <= len; i++) {
			String sub = s.substring(0,i);
			String result = "";
			int cnt = 0; 
        	for (int j = 0; j < len; j+=i) {
				String now = s.substring(j,Math.min(j+i, len)); 
				if(sub.equals(now))
					cnt++;
				else {
					if(cnt <= 1)
						result += sub;
					else
						result = result+ cnt + sub;
					cnt = 1;
					sub = now;
				}
			}
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