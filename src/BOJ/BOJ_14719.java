package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빗물
public class BOJ_14719 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // H : 세로 길이 , W : 가로 길이
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 전체 순회
        for (int i = 1; i < W - 1; i++) {
            int right = 0;
            int left = 0;

            // 좌측
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

            // 우측
            for (int j = i + 1; j < W; j++) {
                right = Math.max(right, arr[j]);
            }

            // 계산
            if (arr[i] < left && arr[i] < right) {
                ans += Math.min(left, right) - arr[i];
            }
        }

        System.out.println(ans);
    }
}
