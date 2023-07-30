import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		//출근한 사람을 저장할 해시맵
		HashMap<String, Integer> hm = new HashMap<>();
		
        //n번 동안 반복
		for (int i = 0; i < n; i++) {
            //이름 enter or leave 입력받고 공백으로 나누어 저장
			String[] log = br.readLine().split(" ");
            
            //enter이라면 리스트에 추가, leaver면 리스트에서 제거
			if(log[1].equals("enter"))
				hm.put(log[0], 1);
			else
				hm.remove(log[0]);
		}
		
		//해시맵 키 set을 배열로 저장 후 알파벳 순으로 정렬
		String[] enter = hm.keySet().toArray(new String[hm.size()]);
		Arrays.sort(enter);
		 
		//배열 뒤에서부터 출력
		for (int i = enter.length-1; i >=0; i--) {
			System.out.println(enter[i]);
		}
 		
	}
}
