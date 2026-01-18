package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2527 {

    public static void main(String[] args) throws IOException {

        // 입력받을 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 0; tc < 4; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 각 좌표를 받음
            // A 사각형
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            // B 사각형
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());

            // 안 만나는 경우
            if (a1 < x2 || b1 < y2 || a2 < x1 || b2 < y1) {
                System.out.println("d");
            } // 한 점에서 만나는 경우
            else if ( (x1 == a2 && y1 == b2) || (x1 == a2 && b1 == y2) || (a1 == x2 && b1 == y2) || (a1 == x2 && y1 == b2)) {
                System.out.println("c");
            }  // 선분에서 만나는 경우
            else if (a1 == x2 || y1 == b2 || x1 == a2 || b1 == y2) {
                System.out.println("b");
            } else {
                System.out.println("a");
            }
        }
    }
}
