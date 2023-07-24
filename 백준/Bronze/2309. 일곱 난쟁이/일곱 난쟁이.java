import java.util.Scanner;
import java.util.*;

public class Main {

	public static void main(String[] args) {
    	  
		Scanner sc = new Scanner(System.in);
		int[] minians = new int[9];
		int sum = 0;
		int false1 = 0;
		int false2 = 0;
		List<Integer> trueMinians = new ArrayList<>();
		
		//입력
		for (int i = 0; i < 9; i++) {
			minians[i]= sc.nextInt();
			sum += minians[i];
		} 
		//가짜 난쟁이 찾기
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				if(sum - minians[i] - minians[j] == 100) {
					false1 = i;
					false2 = j;
					break;
				}
			}
		}
		//가짜난쟁이 빼고 truMinians에 저장
		for (int i = 0; i < 9; i++) { 
			if(i != false1 && i!= false2) {
				trueMinians.add(minians[i]);
			}
		} 
		
		//오름차순 정력
		trueMinians.sort(Comparator.naturalOrder());

		//출력
		for (Integer i : trueMinians) {
			System.out.println(i);
		}
		
		
    }
}
 