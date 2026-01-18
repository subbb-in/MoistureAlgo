package BOJ;

import java.util.Scanner;

public class BOJ_4779 {

    // 재귀함수에서도 사용해야하기 때문에 static으로 선언
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();

            // 가변 문자열을 처리할 스트링 빌더
            sb = new StringBuilder();

            // 제곱을 처리해주는 Math.pow 함수
            int num = (int)Math.pow(3, N);  // 해당 함수의 반환값이 double 이기 때문에 강제 형변환

            for (int i = 0; i < num; i++) {
                sb.append("-"); // 3의 N 제곱만큼 반복하여 sb 문자열에 추가함
            }

            function(0, num);
            System.out.println(sb);
        }
    }

    private static void function(int st, int n) {

        // 기저 조건
        // n(막대의 수) 이 1이 되면 멈춤
        if(n == 1){
            return;
        }

        int div = n/3;

        for (int i = st + div; i < st+2*div; i++) {
            sb.setCharAt(i, ' ');
        }

        function(st, div);
        function(st+2*div, div);
    }
}
