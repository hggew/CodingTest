import java.io.*;
import java.util.*;

public class Main {

	static int n, m; 		// n : 연꽃,개구리 수, m : 통나무 수
	static Frog[] frogs; 	// 개구리 배열
	static int[][] wood; 	// 연꽃끼리 연결된 통나무의 주제 저장
	static int[] lotuses; 	// 연꽃배열 : 연꽃에 배치된 개구리 인덱스 저장
	static boolean topicMatch;

	static class Frog {
		int[] interest;	// 주제 4개에 대한 흥미도
		int[] lotus;	// 선호 연꽃
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		frogs = new Frog[n];
		// 흥미도 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			frogs[i] = new Frog();
			frogs[i].interest = new int[4];
			for (int j = 0; j < 4; j++) {
				frogs[i].interest[j] = Integer.parseInt(st.nextToken());
			}
		}

		// 선호하는 연꽃 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			if (a == b) {
				frogs[i].lotus = new int[1];
				frogs[i].lotus[0] = a;
			} else {
				frogs[i].lotus = new int[2];
				frogs[i].lotus[0] = a;
				frogs[i].lotus[1] = b;
			}
		}
		// 통나무 초기화
		wood = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				wood[i][j] = -1;
			}
		}
		// 통나무 주제 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken()) - 1;
			wood[a][b] = t;
		}

		//연꽃 초기화
		lotuses = new int[n];
		for (int i = 0; i < n; i++) {
			lotuses[i] = -1;
		}
		topicMatch = false;
		setFrog(0, 0);

		// 모든 개구리가 적절히 배치되었다면 
		if (topicMatch) {
			System.out.println("YES");
			for (int i : lotuses) {
				System.out.print(i + 1 + " ");
			}
		} 
		// 개구리가 배치될 수 없다면
		else {
			System.out.println("NO");
		}

	}

	static void setFrog(int start, int cnt) {
		// 가지치기 : 현재 개구리 번호와 연꽃에 배치된 개구리의 숫자가 다르면 개구리배치 돌아가기
		if (cnt != start)
			return;

		// 모든 개구리를 연꽃에 배치했다면 주제 확인
		if (start == n) {
			// 모든 연꽃에 개구리가 있는지 확인
			for (int i : lotuses) {
				if (i == -1)
					return;
			}

			// 모든 통나무 확인
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 통나무가 연결되지 않았다면 다음 통나무 확인
					if (wood[i][j] == -1)
						continue;
					int topic = wood[i][j]; // i번째연꽃과 j번째 연꽃이 연결된 통나무의 주제
					// i연꽃에 앉은 개구리와 j연꽃에 앉은 개구리의 주제에 대한 흥미도가 다르다면 대화x -> 탐색 종료
					if (frogs[lotuses[i]].interest[topic] != frogs[lotuses[j]].interest[topic]) {
						topicMatch = false;
						return;
					}
				}
			}
			// 모든 통나무의 주제가 맞다면 -> 대화가 다 통한다면
			topicMatch = true;
			return;
		}

		// 모든 개구리를 순회하며 선호하는 연꽃에 배치하기
		for (int i = start; i < n; i++) {
			// 개구리마다 선호하는 연꽃의 개수가 다르므로 반복문은 선호연꽃의 개구만큼
			for (int j = 0; j < frogs[i].lotus.length; j++) {
				int nowLotus = frogs[i].lotus[j]; // 개구리가 선호하는 연꽃
				// 선호연꽃에 자리가 비어있다면 개구리 배치시키기
				if (lotuses[nowLotus] == -1) {
					lotuses[nowLotus] = i;
					setFrog(i + 1, cnt + 1); // 다음 개구리 확인
					// 모든 개구리가 적절히 배치되었다면 탐색 종료
					if (topicMatch)
						return;
					lotuses[nowLotus] = -1; // 개구리 배치 해제
				}
			}
		}
	} // end setFrog

}