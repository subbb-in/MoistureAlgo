package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 진우의 달 여행(small)
public class BOJ_17484 {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp[행][열][방향]
        int[][][] dp = new int[N][M][3];

        // 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], INF); // dp
            }
        }

        // 1행 초기값 설정
        for (int j = 0; j < M; j++) {
            for (int dir = 0; dir < 3; dir++) {
                dp[0][j][dir] = map[0][j];
            }
        }

        // DP 수행
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 0: 왼쪽 대각선에서 옴 (이전 위치: i-1행, j+1열)
                if (j + 1 < M) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
                }
                // 1: 아래에서 옴 (이전 위치: i-1행, j열)
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j];

                // 2: 오른쪽 대각선에서 옴 (이전 위치: i-1행, j-1열)
                if (j - 1 >= 0) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + map[i][j];
                }
            }
        }

        // 결과 계산
        int ans = INF;
        for (int j = 0; j < M; j++) {
            for (int dir = 0; dir < 3; dir++) {
                ans = Math.min(ans, dp[N - 1][j][dir]);
            }
        }
        System.out.println(ans);
    }
}