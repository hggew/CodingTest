import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        		//numlist길이만큼 배열 할당
        int[] answer = new int [numlist.length];
        
        // key-n과의 차이값, value-numlist의 인덱스
        HashMap<Double, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < numlist.length; i++) {
        	//n과 차이가 음수라면 양수로 전환 후 +0.5
        	//n과 차이가 같지만 양수인 값이 있을 경우, 그 값이 먼저 와야 하므로 
			if(numlist[i] - n < 0) {
				hm.put(Math.abs(numlist[i]-n) +0.5, i);				
			}else {
				hm.put((double) (numlist[i]-n), i);								
			}	
		}
        
        //해시맵 key set 오름차순 정렬
        List<Double> keySet = new ArrayList<>(hm.keySet());
        Collections.sort(keySet);
        
        
        //answer에 해시맵의 value 저장
        int index = 0;
        for (Double d : keySet) {
        	answer[index++] = numlist[hm.get(d)];
		}
        
        return answer;
    }
}