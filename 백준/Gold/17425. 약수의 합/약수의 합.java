import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        int testMax = 1000001;

        // 배열로 f(N) 먼저 구해놓기
        long[] fn = new long[testMax];
        Arrays.fill(fn, 1L);

        for (int j = 2; j < testMax; j++) {
            for (int k = 1; j*k < testMax; k++) {
                    fn[j*k] += j;
            }
        }

        //f(N)의 합 g(N) 찾기
        long[] gn = new long[testMax];
        for(int i = 1; i< testMax; i++){
            gn[i] += gn[i-1] + fn[i];
        }


        // 테스트케이스 입력받고 g(N) 찾아서 출력
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(gn[n]).append("\n");
        }
        System.out.println(sb);
    }
}