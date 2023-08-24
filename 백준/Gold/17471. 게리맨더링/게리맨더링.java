import java.io.*;
import java.util.*;

public class Main {

	static boolean[] isVisited, connectA, connectB;
	static boolean isDivided;
	static int[][] list;
	static int n; // 구역의 개수
	static int peopleA, peopleB, difMin, connectCount; // A구역 인구, B구역 인구, 인구 차이 최솟값, 다른 구역과 연결된 구역의 수
	static int[] people; // 구역별 인구
	static int[] areaA, areaB;
	static Deque<Integer> q;

	static void divide(int size, int cnt, int start) {
		if (cnt == size) {
			// areaB 구역 구하기
			int indexB = 0;
			findB: 
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < areaA.length; j++) {
					if (areaA[j] == i)
						continue findB;
				}
				areaB[indexB++] = i;
			}

			// 구역이 모두 연결되어있는지 확인
			connectA = new boolean[size];
			connectB = new boolean[n - size];

			// A구역
			q = new ArrayDeque<>();
			q.offer(areaA[0]);
			connectA[0] = true;
			connectCount = 1;
			while (!q.isEmpty()) {
				int now = q.poll();
				for (int i : list[now]) {
					for (int j = 0; j < areaA.length; j++) {
						if (connectA[j])
							continue;
						if (i == areaA[j]) {
							q.offer(i);
							connectA[j] = true;
							connectCount++;
						}
					}
				}
			}
			if (connectCount != areaA.length)
				return;
			 
			// B구역
			q = new ArrayDeque<>();
			q.offer(areaB[0]);
			connectCount = 1;
			connectB[0] = true;
			while (!q.isEmpty()) {
				int now = q.poll();
				for (int i : list[now]) {
					for (int j = 0; j < areaB.length; j++) {
						if (connectB[j])
							continue;
						if (i == areaB[j]) {
							q.offer(i);
							connectB[j] = true;
							connectCount++;
						}
					}
				}
			}
			if (connectCount != areaB.length)
				return;
			

			// areaA의 인구, areaB의 인구를 구해서 차이값구하기
			peopleA = 0;
			for (int i = 0; i < areaA.length; i++) {
				peopleA += people[areaA[i]];
			}
			peopleB = 0;
			for (int i = 0; i < areaB.length; i++) {
				peopleB += people[areaB[i]];
			}

			// 최소 인구차이 갱신
			if (difMin > Math.abs(peopleA - peopleB)) {
				isDivided = true;
				difMin = Math.abs(peopleA - peopleB);
			}

			return;
		}

		for (int i = start; i < n; i++) {
			areaA[cnt] = i;
			divide(size, cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 구역의 개수
		st = new StringTokenizer(br.readLine());

		// 구역 별 인구 입력
		people = new int[n]; // 구역 별 인구
		for (int i = 0; i < n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		// 인접 구역 정보 입력
		list = new int[n][0];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			list[i] = new int[size];
			for (int j = 0; j < size; j++) {
				int to = Integer.parseInt(st.nextToken()) - 1;
				list[i][j] = to;
			}
		}

		difMin = Integer.MAX_VALUE;
		for (int i = 1; i <= n / 2; i++) {
			areaA = new int[i];
			areaB = new int[n - i];
			divide(i, 0, 0);
		}
		if(!isDivided)
			System.out.println(-1);
		else
			System.out.println(difMin);
	}
}
