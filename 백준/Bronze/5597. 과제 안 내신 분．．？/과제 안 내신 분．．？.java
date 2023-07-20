import java.util.*;

public class Main {

	public static void main(String[] args) {
    	 
		Scanner sc = new Scanner(System.in);
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 1; i < 31; i++) {
			hm.put(i, 0);
		}
		for (int i = 0; i < 28; i++) {
			hm.put(sc.nextInt(), 1);
		}
		int[] num = new int[2];
		int index = 0;
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			if(entry.getValue() == 0) {
				num[index++] = entry.getKey();
			}
		}
		
		System.out.println(Math.min(num[0], num[1]));
		System.out.println(Math.max(num[0], num[1]));
		
		
		
		
    }
}
 