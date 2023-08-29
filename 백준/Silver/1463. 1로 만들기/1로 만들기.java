import java.io.*;
import java.util.*;

public class Main  {

	static boolean[] isVisited;
	static Deque<Integer> q, cnt;
	
	
	static void func(int n, int c) {
		if(n<=3) {
			return;
		}
		
		if(n %3== 0 && !isVisited[n/3]) {
			q.add(n/3);
			cnt.add(c+1);
		}
		if(n%2==0 && !isVisited[n/2]) {
			q.add(n/2);
			cnt.add(c+1);
		}
		
		q.add(n-1);
		cnt.add(c+1);
		
		func(q.poll(), cnt.poll());
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); //
        if(n==1) {
			System.out.println(0);
			return;
		}
		if(n<=3) {
			System.out.println(1);
			return;
		}
		
		q = new ArrayDeque<>();
		cnt = new ArrayDeque<>();
		isVisited = new boolean[1000001]; 	//n이 될 수 있는 최댓값인 10^6으로 크기 할당
		
		func(n,0);
		
		System.out.println(cnt.poll()+1);

	}
 

}
