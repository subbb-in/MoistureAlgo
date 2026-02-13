package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9655 {
    public static void main(String[] args) throws IOException {
        // 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 결과 출력
        if(N % 2 == 0) {
            System.out.println("창영");
        } else {
            System.out.println("상근");
        }
    }
}
