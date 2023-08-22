class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;	//이동횟수

        //처음 큐1, 큐2 원소의 합 구하기
        long sum1 = 0;
        long sum2 = 0;
        for (int i : queue1) {
			sum1 += i;
		}
        for (int i : queue2) {
			sum2 += i;
		} 
        
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
        
       // 두 큐의 합이 같아질 때까지 pop, push 반복
        while(sum1 != sum2) {
        	answer++;	//이동횟수 증가
        	//sum1의 원소합이 더 크다면 q1에서 pop, q2에 push
        	if(sum1>sum2) {
        		sum1 -= q[index1];
        		sum2 += q[index1];
        		index1++; 
        		index1 = index1%q.length;
        	}
        	//sum2의 원소합이 더 크다면 q2에서 pop, q1에 push
        	else if(sum2 > sum1) {
        		sum2 -= q[index2];
        		sum1 += q[index2];
        		index2++; 
        		index2 = index2%q.length;
        	}
        	
        	// 너무 많은 이동을 하면 종료 -> 이부분 잘 모르겠음
            if(answer > queue1.length * 3)
                return -1;
        }
        
        return answer;
    } 
}