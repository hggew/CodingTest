import java.io.*;
import java.util.*;

public class Main {

    static int minNum, minKevin;

    static class Friend{
        int num, kevin; //친구의 번호, 친구와의 케빈베이컨 수
        public Friend(int num, int kevin){
            this.num=num;
            this.kevin = kevin ;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] relation = new int[n][n];
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

 

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += relation[i][j] ;
            }
            if(minKevin > count){
                minKevin = count;
                minNum = i+1;
            }
        }

        System.out.println(minNum);
    }

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