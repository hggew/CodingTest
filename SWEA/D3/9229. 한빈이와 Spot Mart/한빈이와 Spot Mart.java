import java.util.*;
import java.io.*;

public class Solution {
	static List<Integer> nowGram = new ArrayList<>(); //부분집합의 각 원소를 저장할 리스트
	static List<Integer> grams = new ArrayList<>();		//부분집합의 원소가 2개일 때 무게의 합을 저장할 리스트
	
	//부분집합 중 원소가 2개일 때 구하기
	public static void getSnack(int[]snacks, int m, int count, int start) {
		if(count==2 ) {
			int sum = 0;
			for (int i : nowGram) {
				sum += i;
			}
			if(sum > m)	//무게의 합이 m보다 크다면 저장하지 않음
				return;
			grams.add(sum);
			return;
		}
		
		for (int i = start; i < snacks.length; i++) {
			nowGram.add(snacks[i]);
			getSnack(snacks, m, count+1, i+1);
			nowGram.remove(nowGram.size()-1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			//n개 과자봉지의 무게 입력
			int[] snacks = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			
			//부분집합을 구할 때 사용할 변수 초기화
			nowGram = new ArrayList<>();
			grams = new ArrayList<>();
			getSnack(snacks, m, 0, 0);
			
			//grams에서 한빈이가 들고 갈 수 있는 무게 구하기
			int result = 0;	//한빈이가 최종적으로 들고갈 과자의 무게
			if(grams.size() == 0) //한빈이가 들고갈 수 있는 과자가 없다면 -1 저장
				result = -1;
			else {
				//무게 리스트 내림차순으로 정렬
				Collections.sort(grams, Collections.reverseOrder());
				result = grams.get(0); //grams는 m보다 작거나 같으므로 가장 앞의 값을 가져와서 저장
			}

			sb.append(result);
			System.out.println(sb.toString());
		}
	}

}
