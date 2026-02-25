package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 지난 일수
        int N = Integer.parseInt(st.nextToken());
        // 최대치 기준일
        int X = Integer.parseInt(st.nextToken());

        // 방문 배열
        int[] visit = new int[N];
        // 구간합 배열
        int[] vSum = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visit[i] = Integer.parseInt(st.nextToken());
        }

        long currSum = 0;
        for (int i = 0; i < X; i++) {
            currSum += visit[i];
        }

        long maxVisit = currSum;
        int cnt = 1;

        // 슬라이딩 윈도우
        for (int i = X; i < N; i++) {
            // 새로운 값을 추가하면서 오래된 값은 제거
            currSum = currSum + visit[i] - visit[i-X];

            if (currSum > maxVisit) {
                maxVisit = currSum;
                cnt = 1;
            } else if(currSum == maxVisit) {
                cnt++;  // 최댓값과 같다면 cnt 증가
            }
        }

        if (maxVisit == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisit);
            System.out.println(cnt);
        }
    }
}
