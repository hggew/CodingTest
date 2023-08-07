import java.io.*;
import java.util.*;

public class Main  {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		// top 입력
		st = new StringTokenizer(br.readLine());
		Stack<Integer> top = new Stack<>();
		Stack<Integer> index = new Stack<>();
		
		int[] laser = new int[n];
		for (int i = 1; i <= n; i++) {
			int nowNum = Integer.parseInt(st.nextToken());
			if(top.isEmpty()) {
				top.push(nowNum);
				index.push(i);
				laser[i-1] = 0;
				continue;
			}
			if(top.peek() > nowNum) {
				laser[i-1] = index.peek();
				index.push(i);
				top.push(nowNum);
			}else {
				while(true) {
					if(top.isEmpty()) {
						laser[i-1] = 0;
						index.push(i);
						top.push(nowNum);	
						break;
					}
					if(top.peek()>nowNum) {
						laser[i-1] = index.peek();
						index.push(i);
						top.push(nowNum);
						break;
					}
					else {
						index.pop();
						top.pop();						
					}
				}
			}
			  
		} 
		
		//출력
		for (Integer i : laser) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());

	}

}
