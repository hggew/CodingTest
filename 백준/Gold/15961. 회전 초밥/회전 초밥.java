import java.io.*;
import java.util.*;

public class Main  {
	static int n, d, k, c; // 접시 수, 초밥 가짓수, 연속해서먹는접시수, 쿠폰번호
	static int count, max; // 현재 초밥 가짓수, 먹을 수 있는 초밥 가짓수 최댓값
	static int[] rail, nowCount;
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

		//
		nowCount = new int[d + 1]; // 1번부터 사용
		nowCount[c] = 1;
		nowSushi = new LinkedList<Integer>();
		for (int i = 0; i < k; i++) {
			nowSushi.add(rail[i]);
			nowCount[rail[i]]++;
		}

		count =0;
		for (int i = 1; i <= d; i++) {
			if (nowCount[i] > 0)
				count++;
		}
		max = count;
		
		for (int i = k; i < n + k - 1; i++) {
			nowCount[nowSushi.get(0)] -=1;
			if(nowCount[nowSushi.get(0)] == 0) {
				count--;
			}
			nowSushi.remove(0);
			nowSushi.add(rail[i]);
			nowCount[rail[i]] += 1;
			if(nowCount[rail[i]] == 1 ) {
				count++;
			}
			max = max < count ? count : max;

		}
		System.out.println(max);

	}
}