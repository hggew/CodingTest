import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;	//소들의 수, 선별할 소의 수
	static int[] cow;	//소들의 몸무게
	static List<Integer> weightSum;	//m마리 소의 몸무게 합 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 소 몸무게 입력
		st = new StringTokenizer(br.readLine());
		cow = new int[n];
		for (int i = 0; i < n; i++) {
			cow[i] = Integer.parseInt(st.nextToken());			
		} 
		
		weightSum = new ArrayList<>();
		getWeightSum(0, 0, 0);
		
		// m마리 소의 몸무게 합 중 소수가 없다면 -1 출력
		if(weightSum.size() == 0) {
			System.out.println(-1);
			return;
		}
		
		// m마리 소의 몸무게 합 중 소수가 있다면 나란히 출력
		Collections.sort(weightSum);	//오름차순 정렬
		for (Integer i : weightSum) {
			System.out.print(i + " ");
		}
	} 
	
	//m마리 소의 몸무게 합 구하기
	static void getWeightSum(int sum, int cnt, int start ) {
		if (cnt == m) {
			//소수인지 확인  : 1과 자신을 제외하고 나누어 떨어지는 수가 있으면 안됨
			int modCnt = 0;
			for (int i = 2; i < sum; i++) {
				if(sum%i == 0)
					modCnt++;
			}
			if(modCnt == 0) {
				// 중복 몸무게 제거
				for (Integer i : weightSum) {
					if(sum == i)
						return;
				}
				weightSum.add(sum);
			}
			return;
		}

		for (int i = start; i < n; i++) {
			sum+=cow[i];
			getWeightSum(sum, cnt+1, i+1);
			sum -= cow[i];
		}
	}
	
}