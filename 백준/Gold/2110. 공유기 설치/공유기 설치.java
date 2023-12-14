import java.io.*;
import java.util.*;

public class Main {
    static int n, c;    //도현이 집의 수, 설치할 공유기 수
    static int[] house; //도현이 집의 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        //집 좌표 입력
        house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house); //좌표 오름차순으로 정렬
        setWIFI();
    }

    static void setWIFI() {
        int high = house[n - 1] - house[0] +1 ;
        int low = 0;
        while (low < high) {
            int mid = (high + low) /2;
            if(countSetted(mid) <c){
                high= mid;
            }
            else
                low = mid+1;
        }
        System.out.println(low-1);
    }

    //거리(dis) 이상마다 공유기를 설치할 수 있는 집 개수 구하기
    static int countSetted(int dis) {
        // 첫번째 집은 무조건 설치한다고 가정
        int start = house[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (house[i] - start >= dis) {
                count++;
                start = house[i]; // 모든 집에 대해서가 아닌 직전에 설치된 집에 대해서 거리구하기
            }
        }
        return count;
    }
}