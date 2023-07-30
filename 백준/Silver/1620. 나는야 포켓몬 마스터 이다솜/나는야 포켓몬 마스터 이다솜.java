import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		//배열 - 번호, 이름   -> 번호 입력 시 사용
		String[] pArr = new String[n+1];
		
		//key-이름 value-번호   -> 이름 입력 시 사용
		HashMap<String, Integer> pokemon = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			pokemon.put(name, i);
			pArr[i] = name;
		}

		for (int i = 0; i < m; i++) {
			String q = br.readLine();
			// 포켓몬 이름 입력
			if(pokemon.containsKey(q)) {
				bw.write(pokemon.get(q) + "\n");
				continue;
			}
			// 포켓몬 번호 입력
			else {
				bw.write(pArr[Integer.parseInt(q)] + "\n");
			}
		}

		bw.close();
	}
}
