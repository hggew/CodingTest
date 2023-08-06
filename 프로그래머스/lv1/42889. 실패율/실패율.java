import java.util.*;

class Solution {
 	public static List<Integer> solution(int N, int[] stages) {
        //스테이지 정렬을 저장할 리스트 
 		List<Integer>  answer = new ArrayList<>();
        
        int player = stages.length;
        
        //인덱스=스테이지번호. 0번을 제외하고 사용 
        int[] ing = new int[N+1];	//스테이지 진행중인 플레이어 수
        int[] challenge = new int[N+1];	//스테이지에 도전한 플레이어 수
        
        //실패율계산 key-스테이지번호, value-실패율
        HashMap<Integer,Double> fail = new HashMap<>();
        
        for(int i = 0; i<player; i++) {  //stages 
        	for (int j = 1; j <= stages[i]; j++) {
        		if(j > N)
        			break;
				challenge[j]+=1;
			}
        	if(stages[i] <=N)
        		ing[stages[i]] += 1;
        }
       
        
        //실패율 계산
        for (int i = 1; i<=N; i++) {
        	double failRate = 0.0;
        	if(ing[i] != 0 | challenge[i] != 0) 
        		failRate = (double)ing[i]/challenge[i]; 
        	
        	fail.put(i, failRate);
		}
 //       System.out.println(fail);
        
        
        //해시맵의 키를 리스트로 저장.
        //1.실패율 내림차순 2.스테이지번호 오름차순을 기준으로 정렬
        //해시맵의 키를 리스트로 저장.
        //1.실패율 내림차순 2.스테이지번호 오름차순을 기준으로 정렬
        answer = new ArrayList<>(fail.keySet());
        Collections.sort(answer,(o1,o2) -> Double.compare(fail.get(o2), fail.get(o1)) );
         
        return answer;
    }
}