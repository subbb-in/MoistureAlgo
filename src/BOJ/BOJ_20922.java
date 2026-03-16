package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 겹치는 건 싫어
public class BOJ_20922 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N : 수열 길이 , K : 같은 정수 길이
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // origin : 입력 배열 , arr : 계산 배열
        int[] origin = new int[N];
        int[] arr = new int[100001];

        // 배열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;    // 정답
        int start = 0;
        int end = 0;

        // 이분탐색
        while (end < N) {
            int cur = origin[end];

            if (arr[cur] < K) {
                arr[cur]++;
                end++;
                max = Math.max(max, end - start);   // max 갱신
            } else {
                arr[origin[start]]--;
                start++;
            }
        }

        System.out.println(max);
    }
}
