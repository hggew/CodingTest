import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		Set<Integer> pop = new HashSet<>();
		int number = 1;
		int popCnt = 0;
		for (int i = 0; i < n; i++) {
			int nowNum = Integer.parseInt(br.readLine());
			if(pop.contains(nowNum) && pop.size()> i) {
				popCnt++;
				continue;
			}
			
			if(stack.contains(nowNum)) {
				
				while(stack.peek() != nowNum) {
					sb.append("-\n");
					pop.add(stack.pop());
					popCnt++;
				}
				if(stack.peek() == nowNum) {
					sb.append("-\n");
					pop.add(stack.pop());
//					stack.pop();
					popCnt++;
				}
				
			}else {
				while(number != nowNum) {
					if(pop.contains(number)) {
						number++;
						continue;
					}					
					sb.append("+\n");
					stack.push(number++);
				}
				if(number == nowNum) {
					stack.push(number);
					sb.append("+\n");
					sb.append("-\n");
					popCnt++;
					pop.add(stack.pop());
//					stack.pop();
				}
			}
		}

		if(popCnt>n) {
			sb = new StringBuilder();
			sb.append("NO");
		}
		System.out.println(sb.toString());
		
		
		
		
		
		
		
	}
}
