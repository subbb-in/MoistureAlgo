package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 교환
public class BOJ_1522 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char[] arr = word.toCharArray();
        int ans = Integer.MAX_VALUE;    // 정답

        // 반복하면서 A의 개수를 찾음
        int Acnt = 0;
        for (char ch : arr) {
            if (ch == 'a') {
                Acnt++;
            }
        }

        // a가 없거나 , a만 있는 경우 미리 종료
        if (Acnt == 0 || Acnt == arr.length) {
            System.out.println(0);
            return;
        }

        // 슬라이딩 윈도우 : 원형큐 방식이기 때문에 전체를 순회해도됨
        for (int i = 0; i < arr.length; i++) {
            int Bcnt = 0;
            for (int j = 0; j < Acnt; j++) {
                if (arr[(i+j)%arr.length] == 'b') {
                    Bcnt++;
                }
            }
            ans = Math.min(Bcnt, ans);
        }

        System.out.println(ans);
    }
}
