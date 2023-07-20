import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n, m;
 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			char[] charArr= br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = Character.getNumericValue(charArr[j]);
			}
		}

		int len = Math.min(n,m);  
		
		outLoop:
		while(len > 0) {
			for (int i = 0; i < n-len+1; i++) {
				for (int j = 0; j < m-len+1; j++) {
					int point = map[i][j];
					if ((point == map[i][j+len-1]) & (point == map[i+len-1][j]) & (point == map[i+len-1][j+len-1]) ) {
//						System.out.println("point "+ point + " len "+ len);
						break outLoop;
					}
				}
			}
			len--;
		}

		System.out.println(len*len);
	}

}

