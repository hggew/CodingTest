import java.io.*;
import java.util.*;
import java.util.Map.Entry; 

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		//key-나이 value-회원이름리스트
		HashMap<Integer, List<String>> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			//해시맵에 list형태로 저장하려면 이름도 리스트로 받아야함
			List<String> name = new ArrayList<String>(); 
			name.add(st.nextToken());
			
			//회원을 처음 입력받는 경우
			if(hm.get(age) == null ) {
				hm.put(age, name);
			}else { //해당 나이의 회원을 추가로 입력받는 경우 
				hm.get(age).addAll(name);
			}
		}
		
		//전체 회원 출력 시 반복문을 한번 더 써서 해당 나이의 회원 리스트를 전부 출력함
		for (Entry<Integer, List<String>> entry : hm.entrySet()) {
			for (String s : entry.getValue()) {
				System.out.println(entry.getKey() + " " + s);
			}
		}
		 
	}
}
 