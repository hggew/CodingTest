//https://softeer.ai/practice/7594

import java.io.*;
import java.util.*;

public class Main {

    static int n; // 격자 크기
    static int[][] map; // 격자
    static boolean[][] visited; // 방문처리
    static int maxBeauty = 0; // 최대 아름다움

    // 시계방향
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());    
            for(int j = 0 ; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findBeauty(0,0,0,0);
        
        System.out.println(maxBeauty);
    
    }


    static void findBeauty(int r, int c, int nowBeauty, int t){
        if(c == n){ // 줄바꿈처리
            r++;
            c=0;
        }
        
        if(r==n || t== 4) { // 격자 마지막까지 확인 or 결합 4번 완료
            maxBeauty = Math.max(nowBeauty, maxBeauty);
            return;            
        }

        if(visited[r][c]) {// 현재 위치 방문했다면 다음 칸으로 이동
            findBeauty(r, c+1, nowBeauty, t);
            return;
        }
        
        
        for(int i=0; i<4; i++){ // 인접한 나무 찾기
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(isInMap(nr, nc) && !visited[nr][nc]){ // 격자 안이고 방문한적 없다면 결합
                visited[r][c] = true;
                visited[nr][nc] = true;
                findBeauty(r, c+1, nowBeauty+ map[r][c] + map[nr][nc], t+1);
                //백트레킹
                visited[r][c] = false;
                visited[nr][nc] = false;
            }
        }
        
        findBeauty(r, c+1, nowBeauty, t); // 결합하지 않은 경우   
    }

    static boolean isInMap(int x, int y){
        if(x < 0 || x >= n || 0 > y || y >= n )
            return false;
        return true;
    }
}


