import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());	// 분기 입력
		
		Deque<Integer> q = new ArrayDeque<>(); 	//업무의 남은 시간을 저장할 큐
		Deque<Integer> s = new ArrayDeque<>(); 	//업무의 만점 점수를 저장할 큐
		
		int score = 0; // 업무를 해결하고 얻은 점수 저장
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int mode = Integer.parseInt(st.nextToken());	//업무 입력
			
			//현재 주어진 업무가 없는 경우
			if(mode ==0) {
				// 이전에 받은 업무를 모두 처리했다면 다음 업무 받기
				if(q.isEmpty()) 
					continue;
				// 큐에서 이전에 받은 업무를 처리
				int nowTask = q.pollFirst() -1;
				// 업무를 다 처리했다면 만점점수를 획득하고 다음 업무 받기
				if(nowTask == 0) {
					score += s.pollFirst();
					continue;
				}
				// 업무가 남았다면 다시 큐에 저장하고 다음 업무 받기
				q.offerFirst(nowTask);
				continue;
			}
			
			int a = Integer.parseInt(st.nextToken());	//업무의 만점
			int t = Integer.parseInt(st.nextToken());	//업무 해결 시간
			
			//현재 업무의 해결시간이 1이라면 바로 처리하고 점수 획득 -> 다음 업무 받기
			if(t == 1) {
				score += a;
				continue;
			}
			
			q.offerFirst(t-1);	//업무 1분 해결하고 남은 시간 큐에 저장
			s.offerFirst(a);	//해당 업무의 만점 점수를 큐에 저장
		}
	
		//출력
		sb.append(score);
		System.out.println(sb.toString());
		
	}
}
