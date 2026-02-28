package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int base = 0;
        int pointer = 0;

        while(base < 30000) {
            base++; // 찾아볼 숫자
            String cur = String.valueOf(base);

            for (int i = 0; i < cur.length(); i++) {
                if(cur.charAt(i) == str.charAt(pointer)) {
                    pointer++;  // 현재 숫자의 자리수가 내가 찾는 문자열의 위치가 나오면 다음 포인터로 이동
                }

                // 문자열의 끝까지 갔다면 해당 숫자(base)를 출력
                if(pointer == str.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}
