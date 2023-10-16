import java.io.*;
import java.util.*;

public class Main {
	
	static int d,k ;	// 날짜 수, 호랑이에게 준 떡의 개수
	static int[] fivoD1, fivoD2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		fivoD1 = new int[30];
		fivoD1[0]=fivoD1[2] = fivoD1[3] = 1;
		fivoD2 = new int[30];
		fivoD2[1] = fivoD2[2] = 1;
		getFivo(); 
		findTTeok();
 
	} 
	
	static void getFivo() {
		for (int i = 3; i < d; i++) {
			fivoD1[i] = fivoD1[i-1] + fivoD1[i-2];
			fivoD2[i] = fivoD2[i-1] + fivoD2[i-2];
		}
	}
	
	static void findTTeok() {
		for (int i = 1; i <= 100000 ; i++) {
			for (int j = i; j <= 1000000; j++) {
				if(fivoD1[d-1]*i + fivoD2[d-1]*j == k) {
					System.out.println(i);
					System.out.println(j);
					return;
				}
				else if (fivoD1[d-1]*i + fivoD2[d-1]*j > k)
					break;
			}
		}
	}
}
