import java.io.*;
import java.util.*;

public class Main {

 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); 
		int[] people = new int[n]; //응시자 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());	//총감독관이 감시할수 있는 수
		int c = Integer.parseInt(st.nextToken());	//부감독관이 감시할수 있는 수
		
		long count = 0;	//감독관의 총 수
		for (int i = 0; i < n; i++) {
			//총감독관수
			count++;
			people[i] = people[i] > b ? people[i] -b : 0;
			//부감독관
			count += people[i] /c;
			count += people[i]%c != 0 ? 1:0;
			
		}
		System.out.println(count);
	}
	
	 

 
}