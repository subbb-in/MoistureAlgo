package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 1,2,3 더하기 4
public class BOJ_15989 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // T : 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine());

        // 주어지는 수는 최대 10,000
        int[] dp = new int[10001];

        // 1로 만드는 경우
        for (int i = 0; i <= 10000; i++) {
            dp[i] = 1;
        }

        // 2로 만드는 경우
        for (int i = 2; i <= 10000 ; i++) {
            dp[i] += dp[i-2];
        }

        // 3으로 만드는 경우
        for (int i = 3; i <= 10000 ; i++) {
            dp[i] += dp[i-3];
        }

        // 주어지는 tc는 같은 dp 배열 안에서 해결 가능
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
