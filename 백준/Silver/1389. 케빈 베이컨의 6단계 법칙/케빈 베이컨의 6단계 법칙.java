import java.io.*;
import java.util.*;

public class Main {

    static int minNum, minKevin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[][] relation = new int[n][n];
        // 케빈베이컨 초기화. 모든 값을 100으로 채워줌. Integer.MAX_VALUE 는 오버플로우 때문에 계산이 되지않아 최대 친구 수인 100으로 설정
        // 자기 자신에 대해서는 0으로 처리
        for (int i = 0; i < n; i++) {
            Arrays.fill(relation[i], 100);
            relation[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            //친구관계 입력. 인덱스처리를 위해 -1
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            relation[a][b] = 1;
            relation[b][a] = 1;
        }

        //최소 케빈베이컨의 수와 사람 초기화
        minNum = 0;
        minKevin = Integer.MAX_VALUE;

        findRelation(n, relation);

        // 각 행을 더해 i번째 사람의 케빈 베이컨 수를 구하기
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += relation[i][j] ;
            }
            // 같은 케빈 베이컨의 경우 더 작은 번호를 출력해야하므로 현재 케빈 베이컨이 더 작은 경우에만 최소값 갱신
            if(minKevin > count){
                minKevin = count;
                minNum = i+1;
            }
        }
        // 최소 케빈 베이컨을 가진 사람의 번호 출력
        System.out.println(minNum);
    }

    // 플로이드 워샬 사용
    static void findRelation(int n, int[][] relation) {
        for (int i = 0; i < n; i++) {
            //직접 친구인 관계 찾기. 케빈 베이컨 == 1
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if(k == i || k == j) continue;
                    relation[j][k] = Integer.min(relation[j][i] + relation[i][k], relation[j][k]);
                }
            }
        }
    }

}