import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine() ) != null) {

            int num = Integer.parseInt(input);

            int cnt = 1;
            long result = 1;

            while (result % num != 0) {
                result = (result * 10 + 1) % num;
                cnt++;
            }
            System.out.println(cnt);

        }

    }
}