import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> pair = new HashMap<>();
		pair.put('{', 0);
		pair.put('}', 0);
		pair.put('(', 1);
		pair.put(')', 1);
		pair.put('[', 2);
		pair.put(']', 2);
		pair.put('<', 3);
		pair.put('>', 3);

		Set<Character> left = new HashSet<>();
		left.add('<');
		left.add('(');
		left.add('[');
		left.add('{');
		Set<Character> right= new HashSet<>();
		right.add('>');
		right.add(')');
		right.add(']');
		right.add('}');
		 
		
		
		for (int T = 1; T <= 10; T++) {
			int n = Integer.parseInt(br.readLine());
			Deque<Character> bracket = new ArrayDeque<>();
			int result  =1;
			
			sb = new StringBuilder();
			sb.append(br.readLine());
			for (int i = 0; i < n; i++) {
				//큐에 넣기
				if(left.contains(sb.charAt(i))) {
					bracket.add(sb.charAt(i));					
				}
				//큐에서 빼기
				else if (right.contains(sb.charAt(i))) {
					if(pair.get(bracket.peekLast()) == pair.get(sb.charAt(i)) ){
						bracket.pollLast();						
					}else {
						result = 0;
						break;
					}
				}
			} 
			sb = new StringBuilder();
			sb.append("#").append(T).append(" ");
			sb.append(result);
			System.out.println(sb.toString());
		}
	}

}
