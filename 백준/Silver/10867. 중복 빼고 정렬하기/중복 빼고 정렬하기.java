import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//n 입력
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());

		//n개의 정수를 입력받고 set으로 저장
		Set<Integer> numSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			numSet.add(Integer.parseInt(st.nextToken()));
		}
		
		//정렬을 위해 set을 list로 변경
		List<Integer> numList = new ArrayList<>(numSet);
		Collections.sort(numList);
		
		for (Integer i : numList) {
			System.out.print(i + " ");
		}
	}
}
