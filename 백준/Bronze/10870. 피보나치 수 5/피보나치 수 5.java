
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		switch (n) {
			case 0:
			case 1:
				System.out.println(n);
				break;
			default:
				int[] fibo = new int[n + 1];
				fibo[0] = 0;
				fibo[1] = 1;
				for (int i = 2; i <= n; i++) {
					fibo[i] = fibo[i - 1] + fibo[i - 2];
				}
				System.out.println(fibo[n]);
				break;
		}
	}

}
