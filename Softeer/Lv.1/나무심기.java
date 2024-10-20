import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 토양의 비옥함 F 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int info[] = new int[n];
        for (int i = 0; i < n; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if (info[i] * info[j] > max) max = info[i] * info[j];
            }
        }
        System.out.println(max);


    }
}
