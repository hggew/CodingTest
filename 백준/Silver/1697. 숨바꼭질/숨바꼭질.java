import java.io.*;
import java.util.*;

public class Main  {
    static int n, k, sec, count;
    static Deque<Integer> q = new ArrayDeque<>();
    static Set<Integer> used = new HashSet<>();

    static void move(int time) {
    	sec++;	// 큐에 넣는 숫자들의 횟수 
    	count = 0;
        for (int i = 0; i < time; i++) {
            int now = q.poll();
            if (now == k) {
                return;
            } 
            
            if (addNumAtQ(now-1) || addNumAtQ(now+1) || addNumAtQ(now*2)) {
                return;
            }
        }

        move(count);

    }
    
    static boolean addNumAtQ(int num) {
        if(num == k) {
            return true;
        }
        if (!used.contains(num) && -100000< num && num <300000) {
        	count ++;
            q.add(num);
            used.add(num);
        }
        return false;
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if(n== k) {
        	System.out.println(0);
        	return;
        }
        	

        q.add(n);
        used.add(n);
        move(1);
        System.out.println(sec);

    }

}