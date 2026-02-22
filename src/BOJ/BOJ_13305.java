package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주유소
public class BOJ_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 도시의 수
        int N = Integer.parseInt(br.readLine()) - 1;
        // 도로의 길이 : 2 3 1
        long[] road = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            road[i] = Long.parseLong(st.nextToken());
        }

        // 리터당 기름 가격 : 5 2 4 1
        long[] oil = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            oil[i] = Long.parseLong(st.nextToken());
        }
        // 합산한 기름 가격
        Long price = 0L;

        // 최저가
        long minPrice = oil[0];

        for (int i = 0; i < N; i++) {
            minPrice = Math.min(oil[i], minPrice);  // min 값을 갱신함
            price += road[i] * minPrice;
        }
        System.out.println(price);
    }
}
