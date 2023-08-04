import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int result = 0; // 출력할 비밀번호 종류의 수

		// 입력
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		String pw = br.readLine();

		st = new StringTokenizer(br.readLine());
		HashMap<Character, Integer> cnt = new HashMap<>();
		cnt.put('A', Integer.parseInt(st.nextToken()));
		cnt.put('C', Integer.parseInt(st.nextToken()));
		cnt.put('G', Integer.parseInt(st.nextToken()));
		cnt.put('T', Integer.parseInt(st.nextToken()));
//		int[] cnt = new int[4];
//		for (int i = 0; i < 4; i++) {
//			cnt[i] = Integer.parseInt(st.nextToken());
//		}

		// 슬라이딩 윈도우 첫번째
		StringBuilder tempPW = new StringBuilder();
		tempPW.append(pw.substring(0, p));
//		String tempPW = pw.substring(0, p);
		// 슬라이딩윈도우의 문자 별 개수 구하기
		HashMap<Character, Integer> tempCnt = new HashMap<>();
		tempCnt.put('A', 0);
		tempCnt.put('C', 0);
		tempCnt.put('G', 0);
		tempCnt.put('T', 0);
		for (int j = 0; j < tempPW.length(); j++) {
			tempCnt.put(tempPW.charAt(j), tempCnt.getOrDefault(tempPW.charAt(j), 0) + 1);
		}

//		System.out.println(tempPW);
//		System.out.println(tempCnt);

		for (int i = 0; i <= s - p; i++) {
			result += 1;
			// 문자들의 최소개수 비교
			for (Character c : cnt.keySet()) {
				if (cnt.get(c) > tempCnt.get(c)) {
					result -= 1;
					break;
				}
			}

			if (i != s - p) {
				// 슬라이딩윈도우에서 제일 앞의 문자 개수 -1
				char first = tempPW.charAt(i);
				tempCnt.put(first, tempCnt.getOrDefault(first, 0) - 1);
//				System.out.println(first + " / " + i);

				// 슬라이딩 윈도우 새로만들기 : 임시문자열(1-p)+원래pw에서 1글자
				char last = pw.charAt(p + i);
//				System.out.println(last + " / " + (p+i)); 
				tempPW.append(last);
//				System.out.println("new tempPW : " + tempPW);
				// 슬라이딩윈도우 문자별 개수 새로 구하기
				tempCnt.put(last, tempCnt.getOrDefault(last, 0) + 1);
			}

		}

		System.out.println(result);

	}

}