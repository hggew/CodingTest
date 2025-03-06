//https://softeer.ai/practice/6289

import java.io.*;
import java.util.*;

public class Main {
    static int n, m; //회원 수, 친분 수 
    static int[] weight; //역기의 무게
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        weight = new int[n];
        Set<Integer> best = new HashSet<>(); //최고라고 생각하는 회원
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            weight[i] = Integer.parseInt(st.nextToken());
            best.add(i);
        }

        //친분관계 입력
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken())-1;
            int n2 = Integer.parseInt(st.nextToken())-1;

            //자신이 최고가 아닌 회원 삭제
            if(weight[n1] > weight[n2]){ 
                best.remove(n2);
            }
            else if(weight[n2] > weight[n1]){
                best.remove(n1);
            }
            else { //n1회원과 n2회원의 무게가 같을 경우 둘 다 삭제
                best.remove(n1);        
                best.remove(n2);        
            }
        }

        System.out.println(best.size()); //남아있는 회원 수 출력 == 최고라고 생각하는 회원
        
    }
}
