import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		//key-카드숫자 value-카드개수
		HashMap<Long, Integer> hm = new HashMap<>();

		for (int i = 0; i < n; i++) {
			long card = Long.parseLong(br.readLine()); 
			hm.put(card, hm.getOrDefault(card, 0) + 1);
		}
 

		int max = 0;	//카드 개수 중 최댓값
		long num = 0;	//최대갯수 카드의 숫자
		
		for (Entry<Long, Integer> entry : hm.entrySet()) {
			//현재 카드 개수가 더 많다면 max,num 값 갱신
			if (entry.getValue() > max) {
				max = entry.getValue();
				num = entry.getKey();
			}
			//현재 카드 개수와 같다면 더 작은수 num에 저장
			else if (entry.getValue() == max) {
				num = Math.min(num, entry.getKey());
			}
		}
		
		System.out.println(num);

	}

}
