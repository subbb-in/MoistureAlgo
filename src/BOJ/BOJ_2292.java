package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 1; // 층수
        int range = 1; // 해당 층의 끝 번호

        if (N == 1) {
            System.out.println(1);
        } else {
            while (range < N) {
                range += 6 * cnt;
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
