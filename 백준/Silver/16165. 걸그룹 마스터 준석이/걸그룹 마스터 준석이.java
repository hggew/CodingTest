import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// key-팀명 value-팀원이름를 가진 리스트
		HashMap<String, List<String>> hm = new HashMap<>();

		// 걸그룹 입력
		for (int i = 0; i < n; i++) {
			String teamName = br.readLine();				// 팀명
			int teamSize = Integer.parseInt(br.readLine()); // 인원수
			List<String> member = new ArrayList<>(); 		// 팀 멤버
			for (int j = 0; j < teamSize; j++) {
				member.add(br.readLine());
			}
			// 사전 순으로 정렬 후 해시맵에 저장
			Collections.sort(member); 
			hm.put(teamName, member);
		}

		// 문제입력
		for (int i = 0; i < m; i++) {
			String quiz = br.readLine();
			int mode = Integer.parseInt(br.readLine());
			switch (mode) {
			case 0:	//팀멤버의 이름을 출력
				for (String s : hm.get(quiz)) {
					System.out.println(s);
				}
				break;
			case 1: //팀명 출력
				//해시맵의  keySet를 이용해 반복하며 해당 key의 value가 팀원을 포함하고있는지 체크
				for (String s : hm.keySet()) {
					if(hm.get(s).contains(quiz))
						System.out.println(s);
				}
				break;
 			}

		}

	}
}
