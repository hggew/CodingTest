import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main  {
	static int n;
	static int[] sour, bitter;
	static List<Integer> result = new ArrayList<>();
	static List<Integer> dif= new ArrayList<>();

	public static void func(int start, int cnt, int size) {
		if (cnt == size) {
//			System.out.println(result.toString());
			int s = 1;
			int b = 0;
			for (int i : result) {
				s *= sour[i-1];
				b += bitter[i-1];
			}
			dif.add(Math.abs(s-b));
			return;
		}

		for (int i = start; i <= n - size + cnt + 1; i++) {
//			System.out.printf("%d %d  \n", i, cnt);
			result.add(i);
			func(i + 1, cnt + 1, size);
			result.remove(result.size() - 1);

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		sour = new int[n];
		bitter = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
//			System.out.println("------");
			result = new ArrayList<Integer>();
			func(1, 0, i);
//			System.out.println(result.toString());
		}
		
//		System.out.println(dif.toString());
		Collections.sort(dif);
		System.out.println(dif.get(0));

	}

}
