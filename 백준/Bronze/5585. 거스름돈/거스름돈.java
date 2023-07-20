import java.util.*;
public class Main {

	public static void main(String[] args) {
	 
		Scanner sc = new Scanner(System.in);
		int change = 1000- sc.nextInt();
		int count = 0;
		int[] money = {500,100,50,10,5,1};
		int index = 0;
		while(change > 0) {
			if(change >= money[index] ) {
				count++;
				change -= money[index];
				continue;
			}
			index++;
		}
		System.out.println(count);
		

	}

}
