//https://softeer.ai/practice/7698

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        int[] candidate = new int[t];
        String five = "++++ ";
        String one ="|";
        
        for(int i =0; i<t; i++){
            candidate[i] = Integer.parseInt(br.readLine());
            for(int j = 0; j< candidate[i]/5; j++){
                sb.append(five);
            }
            
            for(int j = 0; j< candidate[i]%5; j++){
                sb.append(one);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        
        
    }
}
