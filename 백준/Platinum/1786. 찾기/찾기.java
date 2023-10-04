import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count = 0;

		char[] text = br.readLine().toCharArray();
		int n = text.length; // 텍스트의 길이
		char[] pattern =  br.readLine().toCharArray();
		int m = pattern.length; // 패턴의 길이

		// 부분일치 테이블 만들기
		int[] pi = new int[m];
		int j = 0;
		for (int i = 1; i < m; i++) {
			while (j > 0 && pattern[i] != pattern[j]) {
				j = pi[j - 1];				
			}
			if (pattern[i] == pattern[j])
				pi[i] = ++j;
		}

//		for (int k : pi) {
//			System.out.print(k+" ");
//		}
//		System.out.println();

		// 매칭 
		j = 0;
		
		for (int i = 0; i < n; i++) {
			while(j>0 && text[i] != pattern[j]) {
				j = pi[j-1];				
			}
			if (pattern[j] == text[i]) {
				if(j==m-1) {
					count++;
					sb.append(i - j+1).append(" ");
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		 

		// 출력
		System.out.println(count);
		System.out.println(sb.toString());

	}

}