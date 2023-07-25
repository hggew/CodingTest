import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        
        //key-문자열의 길이 value-빈도수
        HashMap<Integer,Integer> hm = new HashMap<>();

        for (String st : strArr) {
            hm.put(st.length(), hm.getOrDefault(st.length(), 0)+1);
        }

        //빈도수(vlaue) 중 가장 큰 값 찾기
        for (int value : hm.values()) {
            answer = Math.max(answer, value);
        }

        return answer;
    }
}