//https://softeer.ai/practice/9657
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int map[] = new int[n];
    
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                if(Integer.parseInt(st.nextToken()) == 1) map[i]++;
            }
        }

        //환경 파괴범 죽이기
        for(int j=0; j<2; j++){      
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            for(int i = l-1; i<r; i++){
                if(map[i] != 0 ) map[i]--;
            }
        }

            
        int man =0;
        for(int i = 0; i<n; i++){
            man += map[i];
        }
        System.out.println(man);
    }
}

