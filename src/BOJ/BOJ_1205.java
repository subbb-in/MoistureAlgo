package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1205 {
    static long[] rank;
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 리스트에 있는 점수 N 개
        long taesu = Long.parseLong(st.nextToken());   // 태수의 새로운 점수
        int P = Integer.parseInt(st.nextToken());   // 랭킹에 올라갈 수 있는 점수의 개수

        // N이 0이면 무조건 1등
        if(N == 0) {
            System.out.println(1);
            return;
        }

        // 배열을 초기화 하고 N 만큼 값을 입력
        rank = new long[P];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rank[i] = Long.parseLong(st.nextToken());
        }

        // 랭킹이 꽉 차면
        if (N == P && rank[N-1] >= taesu) {
            System.out.println(-1);
            return;
        }

        int ans = 1;
        for (int i = 0; i < N; i++) {
            if (rank[i] > taesu) {  // 순차적으로 비교해서 태수의 순위를 늘려감
                ans++;
            } else {
                break;
            }
        }
        System.out.println(ans);
    }
}
