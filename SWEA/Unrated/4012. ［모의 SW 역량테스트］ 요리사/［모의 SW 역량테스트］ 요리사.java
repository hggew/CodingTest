import java.io.*;
import java.util.*;

public class Solution {
	static int[] foodA;	//조합 별 음식A의 재료 저장
	static int[] foodB;	//조합 별 음식A의 재료 저장
	static int sA,sB = 0; //각 음식의 시너지 
	static List<Integer> difs; //음식의 시너지 차이를 저장
	static int[] foodComps; //시너지를 구할 때 재료 i,j를 저장하는 배열
	static int sum;
	
	static int n; //식재료 수
	static int[][] s;		//음식 간 시너지 정보
	static int[] components;	//식재료 총모음
	
	public static int getSynergy(char type, int cnt, int start) {
		int[] food = new int[n/2];
		// 음식 A, 음식B 중 어느 음식의 시너지 합을 구하는지 판단
		switch(type) {
			case 'A' :
				food = foodA;
				break;
			case 'B' :
				food = foodB;
				break;
		}

		
		if(cnt == 2) {
			sum += s[foodComps[0]][foodComps[1]];
			sum += s[foodComps[1]][foodComps[0]];
//			System.out.println(foodComps[0] +"/"+foodComps[1] + " / " +sum);
			return sum;
		}
		for (int i = start; i < n/2; i++) {
			foodComps[cnt] = food[i];
			getSynergy(type, cnt+1, i+1);
		}
		
		return sum;
	}
	
	public static void findComponents(int count, int start) {
		//식재료 조합을 모두 구했으면 식재료간의 시너지 합 구하기
		if(count == n/2) {
			//음식B의 식재료 찾기
			for (int i = 0, j = 0; i < n; i++) {
				if(components[i] == 0)
					foodB[j++]= i;
			}   
//			System.out.println("foodA / foodB");
//			for (int i = 0; i < n/2; i++) {
//				System.out.println(foodA[i] +"/"+foodB[i]);
//			}
			
			
			sum = 0;
			sA = getSynergy('A',0,0);
			sum = 0;
			sB = getSynergy('B',0,0);
//			System.out.println(sA +  " / "+ sB);
			difs.add(Math.abs(sA-sB));
			return;
		}
		
		for (int i = start; i < n; i++) {
			foodA[count] = i;
			components[i] = 1; //방문처리
			findComponents(count+1, i+1);	//다음 식재료 찾기
			components[i] = 0; //방문처리 되돌리기
			}
			 
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken()); //테스트 케이스 수
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine()); 	// 식재료 수 입력
			
			//음식 시너지 입력
			s = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					s[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			components = new int[n];	//식재료 n개 할당
			foodA = new int[n/2];
			foodB = new int[n/2];
			foodComps = new int [2];
			difs = new ArrayList<>();
			findComponents(0, 0);
			
			//시너지 차이의 리스트 오름차순 정렬
			Collections.sort(difs);
//			System.out.println(difs);
			
			//출력
			sb.append("#").append(t).append(" ").append(difs.get(0)).append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
