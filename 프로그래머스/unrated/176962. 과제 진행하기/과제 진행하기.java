import java.util.*;

public class Solution {
	
	static class Homework implements Comparable<Homework>{
		String name;
		int time;
		int playTime;
		public Homework(String name, int time, int playTime) {
			super();
			this.name = name;
			this.time = time;
			this.playTime = playTime;
		}
		@Override
		public String toString() {
			return "Homework [name=" + name + ", time=" + time + ", playTime=" + playTime + "]";
		}
		@Override
		public int compareTo(Homework o) {
			return this.time - o.time;
		}
		 
	}
	
	public static String[] solution(String[][] plans) {
        String[] answer = {};
        List<String> result = new ArrayList<>();

        int len = plans.length;
        
        Homework[] work = new Homework[len];
        for (int i = 0; i < len; i++) {
        	String[] time = plans[i][1].split(":");
        	int m = Integer.parseInt(time[0])*60+ Integer.parseInt(time[1]); 
			work[i] = new Homework(plans[i][0],  m, Integer.parseInt(plans[i][2]));
		}
        
        Arrays.sort(work); 
        
        Deque<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < len; i++) { 
        	//마지막 과제 수행
        	if(i == len-1) {
        		result.add(work[i].name);
        		while(!q.isEmpty()) {
        			result.add(work[q.pollLast()].name);
        		}
        		continue;
        	}
        	
        	
        	 int between = work[i+1].time - work[i].time;
        	 if(work[i].playTime <= between) {
        		 work[i].time += work[i].playTime;
        		 result.add(work[i].name);       		 
        		 between -=work[i].playTime;
        	 }
        	 //다음 과제 시작 시간 전까지 과제를 수행하지 못했다면 큐에 넣기
        	 else {
        		 work[i].playTime -= between;
        		 q.add(i);
        		 continue;
        	 }
        	 
        	 //다음 과제를 수행할 시간이 되었음
        	 if(between == 0)
        		 continue;
        	  
        	 while(!q.isEmpty()) {
        		 int doing = q.peekLast(); 
        		 if(work[doing].playTime <= between) { 
        			 result.add(work[doing].name);
        			 between-= work[doing].playTime;
        			 q.pollLast();
        		 }
        		 else {
        			 work[doing].playTime -= between;
        			 break;
        		 }
        		 if(between == 0)
        			 continue;
        	 } 
		}
       
        answer = result.toArray(new String[result.size()]);
        return answer;
    } 
 
}
