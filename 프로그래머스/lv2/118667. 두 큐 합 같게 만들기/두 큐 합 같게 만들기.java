class Solution {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        for (int i : queue1) {
			sum1 += i;
		}
        for (int i : queue2) {
			sum2 += i;
		}
        
        long half = (sum1+ sum2)/2;

        
        int index1 = 0;					//큐1의 시작 인덱스
        int index2 = queue1.length;		//큐2의 시작 인덱스

        //큐1과 큐2를 하나의 배열로 만들기
        int[] q = new int[queue1.length+queue2.length];
        for (int i = 0; i < queue1.length; i++) {
			q[i] = queue1[i];
		}
        for (int i = 0; i < queue2.length; i++) {
			q[i+ queue1.length] = queue2[i];
		}
        
       // 큐의 합이 같아질 때까지 반복
        while(sum1 != half) {
        	answer++;
        	if(sum1>half) {
        		sum1 -= q[index1];
        		sum2 += q[index1];
        		index1++;
        		index1 = index1%q.length;
        	}
        	else if(sum2 > half) {
        		sum2 -= q[index2];
        		sum1 += q[index2];
        		index2++;
        		index2 = index2%q.length;
        	}
        	if(index1 == index2) 
        		return -1; 
            if(answer > queue1.length * 3)
                return -1;
        }
        
        return answer;
    } 
}
