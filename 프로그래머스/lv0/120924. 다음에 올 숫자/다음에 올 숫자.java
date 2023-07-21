class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int mode = 0; //mode 0 : 등차, mode 1 : 등비
        int dif = common[1]- common[0];

        int index = 2;
        
        while(index < common.length) {
        	 if(dif == common[index]-common[index-1]) { //등차수열이라면
        		 mode = 0;
        		 index++;
        	 }else {	//등비수열이라면
        		 dif = common[index]/common[index-1];
        		 mode = 1;
        		 index++;
        	 }
        }
        if(mode == 0) {
        	answer = common[common.length-1] + dif;
        }else {
        	answer = common[common.length-1]*dif;
        }
         
        
        return answer;
    }
}