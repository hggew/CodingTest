import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		String[][] arr = new String[n][m];

		// 이차원 배열 넣어주기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = st.nextToken();
			}
		}

		List<List<String>> boxList = new ArrayList<>();
		for (int i = 0; i < n / 2; i++) {
			List<String> box = new ArrayList<>();
			List<String> left = new ArrayList<>();
			List<String> bottom = new ArrayList<>();

			for (int x = i; x < n - i; x++) {
				for (int y = i; y < m - i; y++) {
					// 상자 위아래
					if (x == i)
						box.add(arr[x][y]);
					else if (x == n - i - 1)
						bottom.add(arr[x][y]);
					else {
						// 상자 왼쪽
						if (y == i)
							left.add(arr[x][y]);
						// 상자 오른쪽
						else if (y == m - i - 1)
							box.add(arr[x][y]);
					}
				}
			}
			for (int j = bottom.size() - 1; j >= 0; j--) {
				box.add(bottom.get(j));
			}

			for (int j = left.size() - 1; j >= 0; j--) {
				box.add(left.get(j));
			} 
			boxList.add(box);
		} 
        
		int listSize = boxList.size();
		int[] rotation = new int[listSize];
		for (int i = 0; i < listSize; i++) {
			int rot = (n - (i * 2)) * 2 + (m - 2 - (i * 2)) * 2;
			if(rot == 0)
				rotation[i] = r;
			else
				rotation[i] = r % ((n - (i * 2)) * 2 + (m - 2 - (i * 2)) * 2);
		}

		for (int i = 0; i < listSize; i++) {
			if (rotation[i] == 0 || boxList.get(i).size()==0)
				continue;
			List<String> temp = boxList.get(i).subList(rotation[i], boxList.get(i).size());
			temp.addAll(temp.size(), boxList.get(i).subList(0, rotation[i]));
			boxList.set(i, temp);
		}
 

		String[][] result = new String[n][m];
		for (int i = 0; i < n / 2; i++) {
			if(boxList.get(i).size() == 0)
				continue;
			String[] temp = boxList.get(i).toArray(new String[boxList.get(i).size()]);
			int index = 0;
			for (int x = i; x < n - i; x++) {
				// 상자 위쪽
				if (x == i) {
					for (int y = i; y < m - i; y++) {
						result[x][y] = temp[index++];
					}
				}
				// 상자 아래
				else if (x == n - i - 1) {
					for (int y = m - i - 1; y >= i; y--) {
						result[x][y] = temp[index++];
					}
				}
				else if (i < x && x < n - i - 1) {
					// 상자 왼쪽
					result[x][i] = temp[temp.length - x+i];
					// 상자 오른쪽
					result[x][m - i - 1] = temp[index++];
				}
			}

		}
		
		
		//회전시킨 결과 출력
		StringBuilder sb = new StringBuilder();
				
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(result[i][j]).append(" "); 
			} 
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}// main
}
