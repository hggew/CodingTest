import java.util.*;

public class Solution {

	static String[] nowMenu; // 스카피가 원하는 크기의 메뉴 조합 저장
	static Set<String> set; // 만들어진 모든 메뉴 조합 저장
	static List<String> availableMenu;
	static int courseMaxCount;
	static String courseMaxMenu;

	// 손님이 주문한 단품메뉴로 스카피가 원하는 크기의 메뉴 조합 만들기
	public static void makeCourse(int start, int cnt, int size, String[] order, String[] orders) {
		if (cnt == size) {
			String menu = String.join("", nowMenu);

			// 이전에 만들었던 조합이라면 다음 조합 찾기
			if (set.contains(menu))
				return; 
			set.add(menu); 

			int courseCount = checkAvailable(orders); 
			if(courseCount>=2) {
				if(courseCount > courseMaxCount) {
					courseMaxCount = courseCount;
					courseMaxMenu = menu; 			
				}else if(courseCount == courseMaxCount) {
					courseMaxMenu += " " + menu; 				
				}
			}
			return;
		}

		for (int i = start; i < order.length; i++) {
			nowMenu[cnt] = order[i];
			makeCourse(i + 1, cnt + 1, size, order, orders);
		}
	}

	public static int checkAvailable(String[] orders) {

		int cnt = 0;
		for (int i = 0; i < orders.length; i++) {
			int flag = 0;
			for (String s : nowMenu) {
				if (!orders[i].contains(s)) {
					flag = 1;
					break;
				}
			}
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
				String[] order = orders[i].split("");
				nowMenu = new String[c];
				makeCourse(0, 0, c, order, orders);
			}
			//여기서 최종 메뉴 추가 
			if(courseMaxMenu.equals("")) {
				continue;
			}
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
