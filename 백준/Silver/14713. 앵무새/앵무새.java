import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	//앵무새의 수
		int parrotWord = 0;	//앵무새가 말한 단어의 수
		List<Deque<String>> qList = new ArrayList<Deque<String>>(n); //앵무새가 말한 문장 큐 리스트로 저장
		for (int i = 0; i < n; i++) {
			Deque<String> q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				q.offer(st.nextToken());
				parrotWord++;
			}
			qList.add(q);
		}
		//cseteram이 받아적은 문장 string배열로 저장
		String[] cseteram = br.readLine().split(" ");
		
		// 앵무새의 총 단어 수 와 cseteram이 받아적은 단어 수가 다르다면 impossible 출력
		if(cseteram.length != parrotWord) {
			System.out.println("Impossible");
			return;
		}
		
		boolean isPossible = false;
		//cseteram이 받아적은 단어를 확인하며 앵무새 단어 큐 리스트에 있는지 확인
		for (int i = 0; i < cseteram.length; i++) {
			isPossible = false;
			//큐 리스트를 순회하며 큐의 첫 단어가 cseteram의 단어인지 확인. 일치하면 poll하고 다음 단어 확인
			for (int j = 0; j < n; j++) {
				if(cseteram[i].equals(qList.get(j).peek())) {
					qList.get(j).poll();
					isPossible = true;
					break;
				}
			}
			//큐 리스트 순회가 끝나도 cseteram의 단어가 없다면 탐색 종료 Impossible 출력
			if(!isPossible) {
				System.out.println("Impossible");
				return;
			}
		}
		
		//Impossible 출력에 걸리지 않았다면 cseteram의 단어와 앵무새단어가 일치하다는 뜻이므로 Possible 출력
		System.out.println("Possible");
		
	}
}