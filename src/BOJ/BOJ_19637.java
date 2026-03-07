package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// if문 좀 대신 써줘
public class BOJ_19637 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());   // 칭호의 개수
        int M = Integer.parseInt(st.nextToken());   // 캐릭터 수

        // 칭호 배열
        String[] str = new String[N];
        // 범위 배열
        long[] range = new long[N];

        // 칭호와 범위 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            str[i] = st.nextToken();
            range[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            // 한 명의 점수
            int score = Integer.parseInt(br.readLine());
            int start = 0;
            int end = N-1;
            while (start <= end) {
                int mid = (start + end)/2;

                if (score <= range[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
            sb.append(str[start]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
