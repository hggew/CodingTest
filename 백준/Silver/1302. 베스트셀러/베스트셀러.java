import java.io.*;
import java.util.*;
import java.util.Map.Entry; 

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		// key-책이름 value-판매횟수
		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String book = br.readLine();
			hm.put(book, hm.getOrDefault(book, 0)+1);
		} 
		
		int max = 0;  //판매 최댓값을 저장할 변수
		String name = ""; //판매 최댓값의 책이름
		for (Entry<String, Integer> entry : hm.entrySet()) {
			if(entry.getValue() > max) {
				name = entry.getKey();
				max = entry.getValue();
			}
			//최댓값이 여러개일 경우 사전 순으로 앞선 책이름 저장
			//str1.compareTo(str2) -> 같다면 0 / srt1이 먼저라면 음수 / srt2가 먼저라면 양수 반환
			if(entry.getValue() == max)
				name = ( name.compareTo(entry.getKey()) < 0 ) ? name : entry.getKey();
		}
		
		System.out.println(name);
	}
}
 