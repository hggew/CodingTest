import java.io.*;
import java.util.*;

public class Main {

	static int n;

	// 1 2
	// 3 4
	static int findLoc(int len, int r, int c) {
		if (len == 2) {
			int now = r * 2 + c % 2;
			return now;
		}
		if (r < len / 2) { // len/2 > r 1 2
			if (c < len / 2) {// 1
				return findLoc(len / 2, r, c);
			} else { // 2
				return len / 2 * len / 2 + findLoc(len / 2, r, c - len / 2);

			}

		} else { // 3 4
			if (c < len / 2) {// 3
				return (len / 2 * len) + findLoc(len / 2, r - len / 2, c);
			} else { // 4
				return (len / 2 * len) + (len / 2 * len / 2) + findLoc(len / 2, r - len / 2, c - len / 2);

			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int len = (int) Math.pow(2, n);

		System.out.println(findLoc(len, r, c));

	}

}
