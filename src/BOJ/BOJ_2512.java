package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {
    public static void main(String[] args) throws IOException {
        // iput
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지방의 수
        int N = Integer.parseInt(br.readLine());
        // 각 지방의 요구 금액을 담을 배열
        int[] money = new int[N];

        int low = 0;
        int high = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, money[i]);
        }

        int budjet = Integer.parseInt(br.readLine());
        int result = 0;

        // 이분 탐색
        while(low <= high) {
            // 현재 가정 상한액
            int mid = (low+high) / 2;
            // 예산 총액이 클 수 있어서 long
            long sum = 0;

            for (int m : money) {
                // 상한액보다 크면 mid 만큼만, 작으면 실제 요청액
                sum += Math.min(m, mid);
            }

            if(sum <= budjet) {
                // 현재 상한액으로 재정이 가능하면 더 큰 상한액을 시도
                result = mid;
                low = mid+1;
            } else {
                // 예산을 초과한다면 상한액을 낮춤
                high = mid -1;
            }
        }
        System.out.println(result);
    }
}
