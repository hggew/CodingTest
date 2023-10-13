import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	//앵무새의 수
		int parrotWord = 0;
		List<Deque<String>> qList = new ArrayList<Deque<String>>(n);
		for (int i = 0; i < n; i++) {
			Deque<String> q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				q.offer(st.nextToken());
				parrotWord++;
			}
			qList.add(q);
		}
		String[] cseteram = br.readLine().split(" ");
		
		if(cseteram.length != parrotWord) {
			System.out.println("Impossible");
			return;
		}
		
		boolean isPossible = false;
		for (int i = 0; i < cseteram.length; i++) {
			isPossible = false;
			for (int j = 0; j < n; j++) {
				if(cseteram[i].equals(qList.get(j).peek())) {
					qList.get(j).poll();
					isPossible = true;
					break;
				}
			}
			if(!isPossible) {
				System.out.println("Impossible");
				return;
			}
//				break;
		}
		
//		for (int i = 0; i < n; i++) {
//			if(!qList.get(i).isEmpty()) {
//				System.out.println("Impossible");
//				return;
//			}
//		}
		
		System.out.println("Possible");
		
	}
}
