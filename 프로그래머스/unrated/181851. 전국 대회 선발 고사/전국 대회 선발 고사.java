import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
    	int answer = 0;
    	
        // key-등수 value-번호
    	HashMap<Integer, Integer> hash = new HashMap<> ();
    	
    	// 출석을 했다면 해시맵에 추가 
    	for (int i = 0; i < attendance.length; i++) {
    		if(attendance[i] == true) {    			
    			hash.put(rank[i], i);
    		}
		}
    	
    	//올림차순 정렬
    	List<Integer> keyset = new ArrayList<>(hash.keySet());
    	Collections.sort(keyset);
    	
        // 10000 × a + 100 × b + c
        // (10000/Math.pow(10,i*2))  -> 10000, 100, 1
    	for (int i = 0; i < 3; i++) {
    		answer = answer + (int)(10000/Math.pow(10,i*2)) *hash.get(keyset.get(i));			
		}
    	
        
        return answer;
    }
}