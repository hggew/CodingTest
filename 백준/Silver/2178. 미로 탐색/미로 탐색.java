import java.io.*;
import java.util.*;

public class Main  {
    static int n, m;
    static char[][] miro;   //미로를 저장할 이차원배열

    // 우하좌상 탐색
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    //bfs에서 큐에 저장할 떼 사용
    static class Point {
        int x, y, count;    //미로의 x,y좌표, 이동횟수

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //미로입력
        miro = new char[n][m];
        for (int i = 0; i < n; i++) {
            miro[i] = br.readLine().toCharArray();
        }

        boolean[][] isVisited = new boolean[n][m];  //방문 처리 배열
        bfs(isVisited);

    }

    static void bfs(boolean[][] isVisited) {
        Deque<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0, 1));
        isVisited[0][0] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx == n-1 && ny == m-1){
                    System.out.println(now.count+1);
                    return;
                }
                if(checkIndex(nx, ny) && !isVisited[nx][ny]){
                    q.offer(new Point(nx, ny, now.count+1));
                    isVisited[nx][ny] = true;
                }

            }

        }

    }

    // 새로운 좌표가 미로 범위 이내이고 1인지 확인하는 함수
    static boolean checkIndex(int x, int y){
        if(0<=x && x<n && 0<=y && y<m && miro[x][y] =='1')
            return true;
        return false;
    }
}
