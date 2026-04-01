package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 블랙잭
public class BOJ_2798 {
    static int N, M, sum;
    static int[] card, result;
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        card = new int[N];
        result = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 가까운 답
        sum = 0;

        dfs(0, 0);

        System.out.println(sum);
    }

    static void dfs(int depth, int start) {
        // 종료 조건
        if (depth == 3) {
            int temp = 0;
            for (int i = 0; i < 3; i++) {
                temp += result[i];
            }
            if (temp > M) return;
            if (sum <= temp) sum = temp;
            return;
        }

        // 재귀 부분
        for (int i = start; i < N; i++) {
            result[depth] = card[i];
            dfs(depth+1, i+1);
        }
    }
}
