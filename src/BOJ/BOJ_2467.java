package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 용액
public class BOJ_2467 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색 인덱스
        int start = 0;
        int end = arr.length-1;
        long abs = Long.MAX_VALUE;
        // 최종 좌표의 인덱스
        int x = 0;
        int y = 0;

        while (start < end) {
            // 합을 미리 계산
            int sum = arr[start] + arr[end];
            long curAbs = Math.abs((long)sum);

            // 만약 이 절댓값이 가장 작다면 abs를 갱신함
            if ( curAbs < abs) {
                abs = curAbs;
                x = arr[start];
                y = arr[end];
            }
            // 0과 딱 맞는 경우 바로 종료
            if (sum == 0) {
                break;
            }
            // 만약 start와 end를 더한 값이 0 보다 크면 end를 줄임
            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(x + " " + y);
    }
}
