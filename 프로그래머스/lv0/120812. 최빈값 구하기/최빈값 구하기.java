import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        //빈도수 구하기
        //key-숫자 value-빈도수
        for (int i : array) {
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        
        //최빈값 찾기
        int max = Collections.max(hm.values());
        int dupe = 0; //최빈값을 가진 숫자의 개수
        
        //최빈값 중복 확인
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if(max == e.getValue()) {
                dupe++;
                answer = e.getKey();   //최빈값 1개일때 정수 answer에 저장
            }            
        }
        if(dupe>1) { //최빈값 여러 개 일 때, -1 저장
        	answer = -1;           
        }
         
        return answer;
    }
}