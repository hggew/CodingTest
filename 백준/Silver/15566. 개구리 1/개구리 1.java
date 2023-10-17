import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static Frog[] frogs;
	static int[][] wood;
	static int[] lotuses;
	static boolean topicMatch;

	static class Frog {
		int[] interest;
		int[] lotus;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		frogs = new Frog[n];
		//흥미도 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			frogs[i] = new Frog();
			frogs[i].interest = new int[4];
			for (int j = 0; j < 4; j++) {
				frogs[i].interest[j] = Integer.parseInt(st.nextToken());
			}
		}

		//선호하는 연꽃 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(a==b) {
				frogs[i].lotus = new int[1];
				frogs[i].lotus[0] = a;				
			}else {
				frogs[i].lotus = new int[2];
				frogs[i].lotus[0] = a;
				frogs[i].lotus[1] = b;
			}
		}
		//통나무 주제 입력
		wood = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				wood[i][j] = -1;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken())-1;
			wood[a][b] = t; 
		}
		
		lotuses = new int[n];
		for (int i = 0; i < n; i++) {
			lotuses[i] = -1;
		}
		topicMatch = false;
		setFrog(0, 0);
		
		if(topicMatch) {
			System.out.println("YES");
			for (int i : lotuses) {
				System.out.print(i+1 + " ");
			}
		}else {
			System.out.println("NO");
		}
		
		
	}
	
	static void setFrog(int start, int cnt) { 
		if(cnt != start)
			return;		
		
		//모든 개구리를 연꽃에 배치했다면 주제 확인
		if(start == n) {
			//모든 연꽃에 개구리가 있는지 확인
			for (int i : lotuses) {
				if(i == -1)
					return;
			}
			
			//모든 통나무 확인
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(wood[i][j] == -1)
						continue;
					int topic = wood[i][j];
					if(frogs[lotuses[i]].interest[topic] != frogs[lotuses[j]].interest[topic]) {
						topicMatch = false;
						return;
					}
				}
			}
			//모든 통나무의 주제가 맞다면 -> 대화가 다 통한다면
			topicMatch = true;
			return;
			
		}
		
		
		for (int i = start; i < n; i++) {
			
			for (int j = 0; j < frogs[i].lotus.length; j++) {
				int nowLotus = frogs[i].lotus[j]; 
				if(lotuses[nowLotus] == -1) {
					lotuses[nowLotus] = i; 
					
					setFrog(i+1, cnt +1);
					if(topicMatch)
						return;
					lotuses[nowLotus] = -1;					
				}
			}
		}
		
	}
 
}