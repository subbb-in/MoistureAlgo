package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 타노스
public class BOJ_20310 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 주어진 문자열과 글자 단위로 쪼갠 배열
        String str = br.readLine();
        char[] ch = new char[str.length()];
        int zero = 0;
        int one = 0;
        for (int i = 0; i < ch.length; i++) {
            ch[i] = str.charAt(i);  // 배열 안에 한 글자씩 쪼개서 넣어줌
            if (ch[i] == '0') { // i 번째 글자가 0이라면 0을 늘려줌
                zero++;
            } else one++;   // 1이라면 1을 늘려줌
        }

        // 각 개수를 2로 나눔
        if (zero != 0) zero /= 2;
        if (one != 0) one /= 2;

        // 1은 뒤에서부터 제거
        for (int i = ch.length-1; i >= 0; i--) {
            if (ch[i] == '1' && one != 0) {
                one--;
            } else if (ch[i] == '1' && one == 0) {
                ch[i] = 'N';
            }
        }

        // 0은 앞에서부터 제거
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '0' && zero != 0) {
                zero--;
            } else if (ch[i] == '0' && zero == 0) {
                ch[i] = 'N';
            }
        }

        // 전체 순회하면서 기록
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '0') {
                sb.append('0');
            } else if (ch[i] == '1') {
                sb.append('1');
            }
        }

        System.out.println(sb.toString());

    }
}
