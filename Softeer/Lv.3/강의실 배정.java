//https://softeer.ai/practice/6291

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int maxClass = 0;
    static int[][] timeTable;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        timeTable = new int[n][2];
        
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            timeTable[i][0] = start;
            timeTable[i][1] = finish;
        }


        Arrays.sort(timeTable, (a,b) -> a[1] - b[1]);
        int nowEnd = 0;
        for(int i = 0; i<n; i++){
            if(nowEnd <= timeTable[i][0]){
                nowEnd = timeTable[i][1];
                maxClass++;
            }
        }

        System.out.println(maxClass);
        
    }

}


