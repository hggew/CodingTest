import java.util.Scanner;
import java.util.*;
import java.util.Map.Entry;
 
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int dupe = 0; // 최댓 횟수 중복 플래그
		char result = 0;  // 최대 횟수의 문자
		char[] input = {};
		HashMap<Character, Integer> alphabet = new HashMap<>();
		
		//문자열 대문자 전환 후 배열에 저장
		input = sc.next().toUpperCase().toCharArray(); 
		
		//문자 별 횟수 저장
		for (int i = 0; i < input.length; i++) {
			alphabet.put(input[i], alphabet.getOrDefault(input[i], 0)+1);
		}
		
		//최대 횟수 찾기
		int max = Collections.max(alphabet.values());
		
		//중복 확인
		for (Map.Entry<Character, Integer> e : alphabet.entrySet()) {
			if(e.getValue() == max) {
				result = e.getKey();  // 최대 횟수의 문자 저장
				dupe++;
			}
		}
		
		if(dupe > 1) {  //최대 횟수가 중복일 경우
			System.out.println("?");
		}else {			//최대 횟수가 1개일 경우
			System.out.println(result);
		}
 
    }
}
 