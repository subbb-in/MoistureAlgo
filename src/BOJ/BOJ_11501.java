package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11501 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();

        // 테스트케이스
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            // day
            int day = Integer.parseInt(br.readLine());
            // day 별 주가 배열
            int[] stock = new int[day];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < day; i++) {
                stock[i] = Integer.parseInt(st.nextToken());
            }
            long ans = 0;
            int max = 0;
            // 순회하면서 최대 이익 갱신
            for (int i = day-1; i >= 0; i--) {
                if(stock[i] > max) {
                    // 현재 주가가 최고가보다 높으면 갱신
                    max = stock[i];
                } else {
                    // 현재 주가가 최고가 보다 낮으면 차익
                    ans += (max - stock[i]);
                }
            }
            sb.append(ans).append("\n");
        } // test case
        System.out.println(sb.toString());
    }   // main
} // solution
