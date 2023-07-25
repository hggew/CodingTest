import java.util.*;
import java.util.Map.Entry;
 
class Solution {
	public  int solution(int a, int b, int c, int d) {
		int answer = 0;

		// 키 - 주사위숫자 , 값-주사위숫자가 나온 횟수
		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put(a, 1);
		hm.put(b, hm.getOrDefault(b, 0) + 1);
		hm.put(c, hm.getOrDefault(c, 0) + 1);
		hm.put(d, hm.getOrDefault(d, 0) + 1);

		// 점수를 계산할 변수
		int[] pqr = { 0, 0, 0 };
		// pqr 인덱스를 확인할 변수
		int index = 0; 

		// 네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점
		if (hm.size() == 1) {
			answer = 1111 * a;
		} else if (hm.size() == 2) {
			if (hm.get(a) == 2) { // p:2개, q:1개 => (p + q) × |p - q|
				// p와 q 찾기
				for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
					pqr[index++] = entry.getKey();
				}
				answer = (pqr[0] + pqr[1]) * (Math.abs(pqr[0] - pqr[1]));
			} else { // p:3개, q:1개 => (10 × p + q)^2
				// p와 q 찾기
				for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
					System.out.println(entry.getValue() + " /" + entry.getKey());
					if (entry.getValue() == 3)
						pqr[0] = entry.getKey();
					else
						pqr[1] = entry.getKey();
				}
				System.out.println(Arrays.toString(pqr));
				answer = (int) Math.pow(10 * pqr[0] + pqr[1], 2);
			}

		} else if (hm.size() == 3) { // p:2개, q:1개 , r:1개 => q*r
			// q와 r 찾기
			for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
				if (entry.getValue() == 1)
					pqr[index++] = entry.getKey();
			}
			answer = pqr[0] * pqr[1];
		} else if (hm.size() == 4) { // 네 주사위에 적힌 숫자가 모두 다르다면 가장 작은 숫자가 점수
			int min = Integer.MAX_VALUE;
			for (int i : hm.keySet()) {
				min = Math.min(min, i);
			}
			answer = min;
		}

		return answer;
	}
}