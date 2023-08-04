import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//카드를 저장할 큐
		Deque<Integer> card = new ArrayDeque<>();
		
		//큐에 카드 넣기 (1부터 n까지)
		for (int i = 1; i <= n; i++) {
			card.add(i);			
		}
		
		//큐에 카드가 1장 남을 때까지 반복
		while(card.size()>1) {
			card.pollFirst();	//가장 위의 카드 버리기
			int first = card.pollFirst();	//그다음 위의 카드를 뽑아서 저장
			card.add(first);				//큐 마지막에 넣기
		}
		
		//남은 카드 한 장 출력
		System.out.println(card.pollFirst());
		
		
		
	}

}
