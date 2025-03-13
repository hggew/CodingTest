//https://softeer.ai/practice/6273

import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k; // 레일 개수, 택배 바구니 무게, 일 시행횟수
    static int[] rail; //레일 전용 무게
    static boolean[] visited; // 순열 구할때 방문 처리
    static int[] settedRail;  // 순열로 구해진 레일
    static int minWeight=Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        rail = new int[n];
        settedRail = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++)
            rail[i] = Integer.parseInt(st.nextToken());

        setRail(0);
        System.out.println(minWeight);
        
    }

    //순열
    static void setRail(int cnt){
        if(cnt == n){ // 레일 셋팅 완료
            // 여기서 무게 확인
            int nowRail = 0;
            int nowWeight = 0;
            int totalWeight = 0;
            int t =0;
            while(t < k){ //k번만큼 이동
                if(nowWeight + settedRail[nowRail%n] <= m){ //현재 무게 + 다음레일이 m보다 작다면 담기
                    nowWeight = nowWeight + settedRail[nowRail%n];
                    nowRail++;
                }else{
                    totalWeight += nowWeight; // 전체이동 무게에 추가
                    t++; // 이동횟수 추가
                    nowWeight = 0; // 바구니 비우기
                }
            }

            // 지금 레일 셋팅에서 이동한 무게와 지금까지 최소한의 무게 비교
            if(totalWeight < minWeight){
                minWeight = totalWeight;
            }
            return;
            
        }
        
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                settedRail[cnt] = rail[i];
                visited[i] = true;
                setRail(cnt+1);
                visited[i] = false;
                
            }
        }
    }

    
}
