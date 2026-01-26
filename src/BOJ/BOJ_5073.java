package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼각형과 세 변
public class BOJ_5073 {

    public static void main(String[] args) throws IOException {

        // 버퍼는 while 바깥에 두어야 계속해서 객체를 만들지 않음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int max = Math.max(a, Math.max(b, c));

            // 종료 조건
            if (a == 0 && b == 0 && c == 0) {
                return;
            }

            // 삼각형 가능 여부부터 확인하여 분기를 나눔
            if(max >= (a+b+c-max)){
                System.out.println("Invalid");
            } else {
                // 정삼각형 조건
                if (a == b && b == c && a == c) {
                    System.out.println("Equilateral");
                } else if (a == b || b == c || a == c) { // 이등변삼각형 조건
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            }
        }

    }

}
