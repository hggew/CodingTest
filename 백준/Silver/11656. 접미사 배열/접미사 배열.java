import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		List<String> suffix = new ArrayList<>();
		
		//문자열 s의 길이만큼 반복
		//substring으로 문자열을 잘라서 리스트 suffix에 저장
		for (int i = 0; i < s.length(); i++) {
			suffix.add(s.substring(i, s.length()));			
		}
		
		//사전 순 정렬
		Collections.sort(suffix);
		
		for (String str : suffix) {
			System.out.println(str);
		}
		

	}

}
