import java.io.*;
import java.util.*;

/*
 * 클래스 만들기 - 숫자, 순서, 빈도수
 * Message를 담은 리스트 만들기
 * comparator 정렬 1.빈도수 2.순서 
 */
public class Main {
	public static class Message {
		int num; // 숫자
		int order; // 입력 순서
		int count; // 빈도수

		public Message(int num, int order, int count) {
			super();
			this.num = num;
			this.order = order;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		//key-메시지 숫자, value-메시지 숫자의 정보를 담은 Message클래스
		HashMap<Integer, Message> hm = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			//현재 메시지 숫자
			int nowNum = Integer.parseInt(st.nextToken());
			//현재 메시지 숫자를 처음 입력받을 경우 해시맵에 추가
			if(hm.get(nowNum) == null ) {
				hm.put(nowNum, new Message(nowNum, i, 1));
			}
			//해시맵이 현재 메시지 숫자를 가지고 있다면 count+1
			else {
				hm.get(nowNum).count++;
			}	
		}
		
		//해시맵의 value를 가지고와 1.빈도수 2.입력순서 순으로 정렬
		List<Message> values = new ArrayList<>(hm.values());
		Collections.sort(values, new Comparator<Message>() {
			@Override
			public int compare(Message o1, Message o2) {
				if(o1.count == o2.count) {
					return o1.order - o2.order;
				}
				return o2.count - o1.count;
			}
		});
		
		//해시맵의 value를 돌면서 count만큼 메시지 출력해주기
		for (Message m : values) {
			for (int i = 0; i < m.count; i++) {
				bw.write(m.num + " ");
			}  
		}

		bw.close();
	}
}
