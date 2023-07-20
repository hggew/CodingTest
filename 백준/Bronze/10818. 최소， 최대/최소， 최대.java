import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
    	 
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] num = new int[n];
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
			if( max < num[i]) {
				max = num[i];
			}
			if(min > num[i]) {
				min = num[i];
			}
		}
		
		System.out.println(min+" "+max);
		
		
		
    }
}
 