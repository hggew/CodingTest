import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());	//요리시간 t 입력
		
		int countA = 0;	//버튼 A를 누른 횟수
		int countB = 0; //버튼 B를 누른 횟수
		int countC = 0; //버튼 C를 누른 횟수
		
		
		// 요리시간을 버튼 A,B,C로 맞출 수 없는 경우 = 10으로 나누어지지 않은 경우
		// -1 을 출력하고 종료
		if(t%10 != 0) {
			sb.append(-1);
			System.out.println(sb.toString());
			return;
		}
		
		//요리시간을 버튼 A 300초로 나눌 수 있을 때까지 버튼 B,C로 맞추기
		while(t%300 != 0) {
			//요리시간을 버튼 B 60초로 나눌 수 있을 때까지 버튼 C로 맞추기
			while(t%60 != 0) {
				t-= 10;		//버튼 C로 시간 줄이기
				countC++;	//버튼 C를 누른 횟수 증가
				// 요리시간이 버튼 A로 맞출 수 있게 되거나 0이 된다면 종료
				if(t%300 == 0 || t==0) 
					break;
			}
			// 요리시간이 0이 된다면 종료
			if(t== 0)
				break;
			
			t -= 60;	//버튼 B로 시간 줄이기
			countB++;	//버튼 B를 누른 횟수 증가
		}
		
		//요리시간이 버튼 A로 맞출 수 있게 되었으므로 버튼 A를 누른 횟수 추가
		countA =  t/300;	
		
		//출력
		sb.append(countA).append(" ").append(countB).append(" ").append(countC);
		System.out.println(sb.toString());
		
	}

}
