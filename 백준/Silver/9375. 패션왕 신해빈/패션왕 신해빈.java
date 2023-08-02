import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

		for (int t = 0; t < T; t++) {

			int n = Integer.parseInt(br.readLine()); // 의상 수

			// key-의상종류 value-개수
			HashMap<String, Integer> hm = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String category = br.readLine().split(" ")[1];
				hm.put(category, hm.getOrDefault(category, 0) + 1);
			}

			//알몸이 아닌 조합의 개수. 곱셈연산을 해줘야해서 1로 초기화
			int sum = 1;
			//각 의상종류마다 1개씩만 입을 수 있으므로 안입는 경우를 포함하여 sum에 곱해준다
			for (int i : hm.values()) {
				sum *= (i+1); 
			}
			//모든 의상을 안입는 경우(알몸)을 제외하고 출력
			System.out.println(sum-1); 
	
		}
	
	}
}
