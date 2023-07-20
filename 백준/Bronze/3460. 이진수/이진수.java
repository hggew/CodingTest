
import java.util.*;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			for (int j = 0; n > 0; j++) {
				if(n%2 == 1) {
					sb.append(j).append(" ");
				}
				n /= 2;
			}
			System.out.println(sb.toString());
		}
		
		

	}

}
