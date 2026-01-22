package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ZOAC 4
public class BOJ_23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()); // 행
        int W = Integer.parseInt(st.nextToken()); // 열
        int N = Integer.parseInt(st.nextToken()); // 세로 기준
        int M = Integer.parseInt(st.nextToken()); // 가로 기준

        // 정답 수
        int widthCnt = 0;
        int heightCnt = 0;

        if (W % (M + 1) == 0) {
            widthCnt = W / (M + 1); // 한 줄에 들어가는 최대 인원
        } else {
            widthCnt = (W/(M+1))+1;
        }

        if (H % (N + 1) == 0) {
            heightCnt = H / (N + 1); // 한 열에 들어가는 최대 인원
        } else {
            heightCnt = (H / (N+1)) +1;
        }
        System.out.println(widthCnt * heightCnt);
    }
}
