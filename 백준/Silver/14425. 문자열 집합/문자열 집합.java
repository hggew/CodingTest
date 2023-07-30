import java.io.*;
import java.util.*;

/* n,m 입력
 * n개만큼 집합 문자열 받기
 * m개 문자열 받고 집합에 포함인지 확인
 * */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int count = 0; // m개의 문자열이 집합 s에 포함되어 있는 수
		
		//집합 s
		List<String> s = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			s.add(br.readLine());
		} 
		
		//m개의 문자열 하나씩 읽고 집합 s가 포함하고 있는지 확인
		for (int i = 0; i < m; i++) {
			if(s.contains(br.readLine())){
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
