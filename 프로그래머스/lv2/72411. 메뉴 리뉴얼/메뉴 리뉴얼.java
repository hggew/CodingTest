import java.util.*;

public class Solution {

	static String[] nowMenu; 			// 스카피가 원하는 크기의 메뉴 조합 저장
	static Set<String> set; 			// 만들어진 모든 메뉴 조합 저장
	static List<String> availableMenu;	// 구성가능한 모든 코스 메뉴 
	static int courseMaxCount;			// 현재 만드려는 크기의 코스 최대 주문횟수
	static String courseMaxMenu;		// 현재 만드려는 최대 주문횟수의 코스 메뉴

	// 손님이 주문한 단품메뉴로 스카피가 원하는 크기의 메뉴 조합 만들기
	public static void makeCourse(int start, int cnt, int size, String[] order, String[] orders) {
		if (cnt == size) {
			String menu = String.join("", nowMenu);	//배열로 만들었던 메뉴조합을 문자열로 변환

			// 이전에 만들었던 조합이라면 다음 조합 찾기
			if (set.contains(menu))
				return; 
			set.add(menu); 

			int courseCount = checkAvailable(orders); // 구성 가능한 메뉴조합인지 확인하고 손님이 주문한 횟수 반환
			// 최소 주문량 2를 초과한다면 최대주문횟수와 비교
			if(courseCount>=2) {
				// 현재 조합이 최대 주문횟수라면 최대주문횟수 갱신, 코스메뉴 갱신
				if(courseCount > courseMaxCount) {
					courseMaxCount = courseCount;
					courseMaxMenu = menu; 			
				}
				// 현재 조합이 이전의 최대 주문횟수와 같다면 코스메뉴에 현재 조합 추가
				else if(courseCount == courseMaxCount) {
					courseMaxMenu += " " + menu; 				
				}
			}
			return;
		}

		// 스카피가 원하는 크기의 메뉴 조합 만들기
		for (int i = start; i < order.length; i++) {
			nowMenu[cnt] = order[i];
			makeCourse(i + 1, cnt + 1, size, order, orders);
		}
	}

	// 메뉴 조합이 구성가능한지 확인하는 함수
	public static int checkAvailable(String[] orders) {
		int cnt = 0;	//현재 메뉴 조합을 손님이 주문한 횟수 
		// 각 손님의 주문에서 현재 메뉴 조합이 모두 있는지 확인
		for (int i = 0; i < orders.length; i++) {
			int flag = 0;	//구성가능 여부
			for (String s : nowMenu) {
				if (!orders[i].contains(s)) {
					flag = 1;
					break;
				}
			}
			// 각 손님이 현재 메뉴 조합을 모두 주문했다면 cnt 증가
			if (flag == 0) 
				cnt++;
		}		
		return cnt;
	}

	public static String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		// 손님들이 주문한 메뉴를 오름차순으로 정렬
		for (int i = 0; i < orders.length; i++) {
			String[] str = orders[i].split("");
			Arrays.sort(str);
			orders[i] = String.join("", str);
		}
 

		set = new HashSet<>();
		availableMenu = new ArrayList<>();
		// 각 손님이 주문한 메뉴를 스카피가 원하는 개수로 조합 만들기
		for (int c : course) {
			courseMaxCount= 0;
			courseMaxMenu = "";
			for (int i = 0; i < orders.length; i++) {
				String[] order = orders[i].split("");	//메뉴 조합을 만들기 위해 주문 목록을 배열로 변경
				nowMenu = new String[c];			//현재 메뉴의 크기 하당
				makeCourse(0, 0, c, order, orders);	//메뉴 조합 구하기
			}
			//여기서 최종 메뉴 추가 
			//구성불가능한 주문이거나 구성가능하지만 최대주문량이 아닌 경우 다음 손님에서 메뉴 조합 찾기
			if(courseMaxMenu.equals("")) 
				continue;
			
			String[] maxMenu = courseMaxMenu.split(" ");
			for (String s : maxMenu) {
				availableMenu.add(s);
			}
		}
 
		// 코스메뉴 오름차순 정렬
		Collections.sort(availableMenu); 
		answer = availableMenu.toArray(new String[availableMenu.size()]);

		return answer;
	} 
}
