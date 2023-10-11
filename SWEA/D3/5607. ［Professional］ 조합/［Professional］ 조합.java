import java.io.*;
import java.util.*;

public class Solution {

	static long factorial[];
	static int p = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		factorial = new long[1000001];
		calcFactorial();

		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			long result = factorial[n];
			long rf = (factorial[n - r] * factorial[r]) % p;
			rf = pow(rf, p-2);

			result = result * rf % p;

			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());

	}

	static void calcFactorial() {
		factorial[0] = 1;
		for (int i = 1; i <= 1000000; i++) {
			factorial[i] = factorial[i - 1] * i % p;
		}
	}

	// a^n 구하기 최적화방법
	static long pow(long a, long n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return a;
		if (n % 2 == 0) {
			long temp = pow(a, n / 2);
			return (temp * temp) % p;
		}
		long temp = pow(a, n - 1) % p;
		return (temp * a) % p;
	}

}

/*
 * (a*b) % p = a%p * b% p
 * 
 */