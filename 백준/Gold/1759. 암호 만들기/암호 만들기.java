import java.io.*;
import java.util.*;

public class Main {

	static int l, c;
	static char[] alphabet, pw;
	static StringBuilder sb;

	// 가능성 있는 암호 찾기
	static void findPW(int start, int cnt) {
		// 암호의 조합을 만들면 가능성이 있는지 확인
		if (cnt == l) {
			// 여기서 자음 모음 최소 조건 만족하는지 확인
			int aeiou = 0;	//모음의 개수
			int others = 0;	//자음의 개수
			//현재 암호에서 모음, 자음 개수 찾기
			for (int i = 0; i < l; i++) {
				if (pw[i] == 'a' || pw[i] == 'e' || pw[i] == 'i' || pw[i] == 'o' || pw[i] == 'u')
					aeiou++;
				else
					others++;
			}
			//모음1개, 자음2개의 최소 조건을 만족하면 출력
			if(aeiou >=1 && others>=2) {
				for (char c : pw) {
					sb.append(c);
				}
				sb.append("\n");
			}
			return;
		}
		// 여기서 조합으로 문자열 만들기
		for (int i = start; i < c; i++) {
			pw[cnt] = alphabet[i];
			findPW(i + 1, cnt + 1);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		l = Integer.parseInt(st.nextToken());	// 암호의 길이
		c = Integer.parseInt(st.nextToken());	//암호로 사용할 문자의 개수

		//암호로 사용할 문자 입력
		alphabet = new char[c];	
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}

		// 주어진 알페벳 오름차순으로 정렬
		Arrays.sort(alphabet);

		pw = new char[l];
		findPW(0, 0);	//가능성 있는 암호 찾기
		System.out.println(sb.toString());

	}

}