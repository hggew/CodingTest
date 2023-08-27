import java.io.*;
import java.util.*;

public class Main  {
	static int n, d, k, c; // 접시 수, 초밥 가짓수, 연속해서먹는접시수, 쿠폰번호
	static int count, max; // 현재 초밥 가짓수, 먹을 수 있는 초밥 가짓수 최댓값
	static int[] rail, nowCount;	//레일 위 회전초밥, 가짓수별 손님이 먹은 회전초밥의 수
	static List<Integer> nowSushi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		// 레일 위 초밥 입력
		rail = new int[n + k - 1];
		for (int i = 0; i < n; i++) {
			int sushi = Integer.parseInt(br.readLine());
			rail[i] = sushi;
			if (i < k - 1) {
				rail[i + n] = sushi;
			}
		}  

		//레일의 0번부터 k개만큼 먹었을 때 초밥의 종류와 종류별 초밥의 수 구하기
		nowCount = new int[d + 1]; // 1번부터 사용
		nowCount[c] = 1;	//쿠폰의 초밥은 무조건 1개 먹는다
		nowSushi = new LinkedList<Integer>();
		for (int i = 0; i < k; i++) {
			nowSushi.add(rail[i]);
			nowCount[rail[i]]++;
		}

		//0번부터 k개의 가짓수 구하기
		count =0;
		for (int i = 1; i <= d; i++) {
			if (nowCount[i] > 0)
				count++;
		}
		max = count;
		
		//k개를 먹을 수 있는 모든 경우에 대해서 가짓수 구하기
		for (int i = k; i < n + k - 1; i++) {
			//이전에 먹었던 초밥의 0번 제거. 0번의 개수가 1개라면 count에서 -1
			nowCount[nowSushi.get(0)] -=1;
			if(nowCount[nowSushi.get(0)] == 0) {
				count--;
			}
			nowSushi.remove(0);
			//현재 새롭게 먹을 초밥 추가. 최근 초밥의 개수가 1이라면 count+1
			nowSushi.add(rail[i]);
			nowCount[rail[i]] += 1;
			if(nowCount[rail[i]] == 1 ) {
				count++;
			}
			//현재 가짓수를 비교해서 최대 가짓수 갱신
			max = max < count ? count : max;
		}
		System.out.println(max);
	}
}