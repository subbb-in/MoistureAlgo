package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17615 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 볼의 총 개수
        int N = Integer.parseInt(br.readLine());
        // String
        String str = br.readLine();
        // R BBB RR BB R B RRR
        char[] arr = str.toCharArray();
        int R = 0;  // 빨간색
        int B = 0;  // 파란색
        for (char a : arr) {
            if (a == 'R') R++;
            if (a == 'B') B++;
        }
        // 답이 0이 되는 경우 먼저 처리
        if (R == 0 || B == 0) {
            System.out.println(0);
            return;
        }
        char right = arr[arr.length-1];
        char left = arr[0];

        int ans = Integer.MAX_VALUE; // 정답

        // 빨간공(R)을 오른쪽으로
        if(right == 'R') {
            int cntR = 1;
            for (int i = N-2; i >= 0; i--) {
                if (arr[i] == 'R') {
                    cntR++;
                } else {
                    break;
                }
            }
            ans = Math.min(R-cntR, ans);
        } else {
            ans = R;
        }

        // 파란공(B)을 오른쪽으로
        if (right == 'B') {
            int cntB = 1;
            for (int i = N-2; i >= 0; i--) {
                if (arr[i] == 'B') {
                    cntB++;
                } else {
                    break;
                }
            }
            ans = Math.min(B-cntB, ans);
        } else {
            ans = Math.min(B, ans);
        }

        // 빨간공(R)을 왼쪽으로
        if (left == 'R') {
            int cntR = 1;
            for (int i = 1; i < N-1; i++) {
                if (arr[i] == 'R') {
                    cntR++;
                } else {
                    break;
                }
            }
            ans = Math.min(R-cntR, ans);
        } else {
            ans = Math.min(R, ans);
        }

        // 파란공(B)을 왼쪽으로
        if (left == 'B') {
            int cntB = 1;
            for (int i = 1; i < N-1; i++) {
                if (arr[i] == 'B') {
                    cntB++;
                } else {
                    break;
                }
            }
            ans = Math.min(B-cntB, ans);
        } else {
            ans = Math.min(B, ans);
        }

        System.out.println(ans);
    }
}
