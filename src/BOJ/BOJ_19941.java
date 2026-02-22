package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19941 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 식탁의 길이
        int K = Integer.parseInt(st.nextToken());   // 햄버거 선택할 수 있는 거리
        int ans = 0;

        char[] ch = br.readLine().toCharArray();    // 햄버거 혹은 사람 정보를 담을 char 배열
        boolean[] check = new boolean[N];

        for (int i = 0; i < N; i++) {
            // 이미 짝을 찾았다면 패스
            if (check[i]) continue;

            for (int j = 1; j <= K; j++) {
                if (i+j >= N) break;    // 범위 검증

                char std = ch[i];
                if (std == 'H') {   // 햄버거일 때
                    if (ch[i+j] == 'P' && !check[i+j]) {
                        ans++;
                        check[i] = true;
                        check[i+j] = true;
                        break;
                    }
                } else if (std == 'P'){    // 사람일 때
                    if (ch[i+j] == 'H' && !check[i+j]) {
                        ans++;
                        check[i] = true;
                        check[i+j] = true;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
