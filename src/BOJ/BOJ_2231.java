package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 분해합
public class BOJ_2231 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 자연수 N

        int result = 0;
        for (int i = 1; i < N; i++) {
            int num = i;
            int sum = i;

            // 각 자리수 더하기
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            // 종료
            if (sum == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
