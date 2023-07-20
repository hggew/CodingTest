import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
    	 
		Scanner sc = new Scanner(System.in);
		
		int max = 0;
		int count = 0;
		
		for (int i = 0; i < 9; i++) {
			int nowNum = sc.nextInt();
			if(max < nowNum) {
				max = nowNum;
				count = i+1;
			}
		}
		System.out.println(max);
		System.out.println(count);
		
		
		
    }
}
 