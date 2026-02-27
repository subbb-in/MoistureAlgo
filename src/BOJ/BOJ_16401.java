package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 과자 나눠주기
public class BOJ_16401 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 조카의 수
        int M = Integer.parseInt(st.nextToken());
        // 과자의 수
        int N = Integer.parseInt(st.nextToken());

        // 과자의 길이
        st = new StringTokenizer(br.readLine());
        long[] cookieLen = new long[N];
        for (int i = 0; i < N; i++) {
            cookieLen[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(cookieLen);

        // 전체를 나눈 값 : 아마 최대값이 됨
        long start = 1;
        long end = cookieLen[N - 1];
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            int cnt = 0;

            if (mid == 0) break;    // 0으로 나누는 것 방지

            // 현재 길이(mid) 로 만들 수 있는 과자 조각의 총 개수
            for (int i = 0; i < N; i++) {
                cnt += (int) (cookieLen[i] / mid);
            }

            if (cnt >= M) {
                // 조카들에게 다 줄 수 있음 -> 길이를 더 늘려보자
                result = mid;
                start = mid + 1;
            } else {
                // 조카들에게 다 못 줌 -> 길이를 줄이자
                end = mid - 1;
            }

        }
        System.out.println(result);
    }
}
