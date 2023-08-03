import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		int last = 0; //back에 사용. push할 때마다 값 갱신

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
//			String command = st.nextToken();
			switch (st.nextToken()) {
				//명령어 push : 숫자를 하나 더 입력받고 큐에 추가
				case "push":
					last = Integer.parseInt(st.nextToken());
					q.add(last);
					break;
				//명령어 pop : 큐 사이즈 확인 후 poll 사용
				case "pop": 
					if (q.size() == 0)
						sb.append(-1).append("\n");
					else
						sb.append(q.poll()).append("\n");
					break;
				//명령어 size 	
				case "size":
					sb.append(q.size()).append("\n");
					break;	
					//명령어 empty : isEmpty 사용	
				case "empty":
					if (q.isEmpty())
						sb.append(1).append("\n");
					else
						sb.append(0).append("\n");
					break;	
				//명령어 front : 큐의 헤드 확인 후 출력	
				case "front":
					if (q.peek() == null)
						sb.append(-1).append("\n");
					else
						sb.append(q.peek()).append("\n");
					break;
				//명령어 back : 큐 사이즈 확인 후 큐가 비어있지않다면 큐를 ArrayList로 저장하고 마지막 값 출력	
				case "back":
					if (q.size() == 0)
						sb.append(-1).append("\n") ;
					else {
						sb.append(last).append("\n");
//						List<Integer> temp = new ArrayList<Integer>(q);
//						sb.append(temp.get(temp.size()-1)).append("\n");
					}
					break;
			}//switch
		} //for end
		System.out.println(sb.toString());
	}
}
