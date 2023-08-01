import java.io.*;
import java.util.*;

public class Main  {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//스위치 개수
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		//n개의 스위치 입력
		//key-스위치번호 value-스위치상태
		HashMap<Integer, Integer> switches = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			switches.put(i, Integer.parseInt(st.nextToken()));
		}
		
		int student = Integer.parseInt(br.readLine());	//학생 수
		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());  	//학생 성별
			int location = Integer.parseInt(st.nextToken());	//스위치 번호
			
			//남학생의 경우 키가 location의 배수인지 확인하고 스위치 변경
			if(gender == 1) {
				for (Integer key : switches.keySet()) {
					if(key%location == 0) {
						switches.put(key, (switches.get(key)+1)%2 );
					}
				}
			}
			//여학생의 경우 인덱스 2개이용 현재 위치 좌우 확인
			else {
				int plusIndex = location+1;
				int minusIndex = location-1;
				while(true) {
					//인덱스의 범위가 넘거나 좌우가 대칭이 아니라면 좌우상태 체크 중단
					if(plusIndex>n || minusIndex<0 || switches.get(minusIndex) != switches.get(plusIndex)) {
						plusIndex--;
						minusIndex++;
						break;
					}
					//좌우를 확인하는 인덱스 이동
					plusIndex++;
					minusIndex--;					
				}
				//대칭인 범위만큼 스위치 변경
				for (int j = minusIndex; j <= plusIndex; j++) {
					switches.put(j, (switches.get(j)+1)%2);
				}
			}
			
		
		}
		//해시맵의 key를 가져와 오름차순으로 정렬 -> 출력 시 사용
		List<Integer> keys = new ArrayList<>(switches.keySet());
		Collections.sort(keys);
		
		int outCnt = 0;
		StringBuilder sb = new StringBuilder();
		for (Integer k : keys) {
			sb.append(switches.get(k)).append(" ");
			outCnt++;
			if(outCnt%20 == 0) {
				System.out.println(sb.toString());
				sb = new StringBuilder();
			}
		}
		System.out.println(sb.toString());
		
			
	}
}
