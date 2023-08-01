import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		//key-확장자명 value-개수
		HashMap<String, Integer> extensions = new HashMap<>();
		for (int i = 0; i < n; i++) {
			//확장자만 자르기
			String file = br.readLine().split("\\.")[1]; 
			extensions.put(file, extensions.getOrDefault(file, 0)+1);
		}
		
		//확장자가 들어있는 key 리스트로 저장 후 사전순 정렬
		List<String> keys = new ArrayList<>(extensions.keySet());
		Collections.sort(keys);
		for (String k : keys) {
			bw.write(k + " " + extensions.get(k) +"\n");
		}
		
 
		
//		bw.write(pArr[Integer.parseInt(q)] + "\n");
		bw.close();
	}
}
