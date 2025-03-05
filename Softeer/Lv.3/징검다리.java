//https://softeer.ai/practice/6293

import java.io.*;
import java.util.*;

public class Main {

    
    static int n; //돌의 개수
    static int maxJump = 0; // 최대 점프 횟수
    static int[] rock; //돌의 높이 
    static int[] dp;

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        rock = new int[n];
        for(int i = 0; i<n; i++){
            rock[i] = Integer.parseInt(st.nextToken());
        }        
        dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i<n; i++){
            int nowJump = 1;
            for(int j = 0; j<i; j++){
                // sb.append("i=").append(i).append("/j=").append(j).append("------------------------\n");
                if(rock[j] < rock[i] ) { //현재 돌이 이전 돌보다 크고
                    if(dp[j] >= nowJump)  {//이전돌의 건넘 횟수와 비교했을 때 
                        nowJump = dp[j]+1; //이전돌 건넘횟수+1을 현재 건넘횟수에 저장

                        // sb.append("i = ").append(i).append(" ").append(rock[i]).append(" j = ").append(j).append(" ").append(rock[j]);
                        // sb.append(" / nowJump ").append(nowJump).append("\n");
                    }
                }
            }
            dp[i] = nowJump;
        }

        // for(int i = 0; i<n; i++){
        //     sb.append(dp[i]).append("@");
        // }
        // sb.append("\n");
        
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
        // System.out.println(sb);
        
    }
}
