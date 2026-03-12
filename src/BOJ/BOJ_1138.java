package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1138 {
    public static final int FILL = -1;
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 숫자의 개수
        int[] arr = new int[N];
        Arrays.fill(arr, FILL);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken()); // 왼쪽에 배치된 나보다 큰 수의 개수
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j] == FILL) {
                    if (cnt == num) {
                        arr[j] = i;
                        break;
                    }
                    cnt++;
                }
            }
        }
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int val : arr) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
