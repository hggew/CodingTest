import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>(); //스택 생성
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();	//명령어 입력
			switch (command) {
				//명령어 push : 스택에 넣을 숫자 입력 후 push
				case "push":
					int num = Integer.parseInt(st.nextToken());
					stack.push(num);	
					break;
				//명령어 pop : 스택사이즈 확인 후 -1 출력 or pop
				case "pop":
					if(stack.size()==0)
						System.out.println(-1);
					else {
						System.out.println(stack.pop());
					}	
					break;
				//명령어 size : size 사용
				case "size":
					System.out.println(stack.size());
					break;
				//명령어 empty : isEmpty 사용
				case "empty":
					if(stack.isEmpty())
						System.out.println(1);
					else
						System.out.println(0);
					break;
				//명령어 peek : 스택사이즈 확인 후 -1 출력 or peek
				case "top":
					if(stack.size()==0)
						System.out.println(-1);
					else {
						System.out.println(stack.peek());
					}		
					break;
 			}

		}

	}
}
