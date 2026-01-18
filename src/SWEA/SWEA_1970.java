package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 회문 2
public class SWEA_1970 {

    public static void main(String[] args) throws IOException {

        // 입력 받을 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());  // 거스름돈

            int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            int[] result = new int[8];

            for (int i = 0; i < 8; i++) {
                result[i] = N / money[i];
                N %= money[i];
            }
            System.out.println("#"+tc);
            for (int i = 0; i < 8; i++) {
                System.out.print(result[i]+ " ");
            }
            System.out.println();
        }

    }
}
