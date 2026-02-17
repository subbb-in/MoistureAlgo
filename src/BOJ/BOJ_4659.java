package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String input = br.readLine();  // input을 받음
            if(input.equals("end")) break;  // end라면 종료

            if (isValid(input)) {
                sb.append("<").append(input).append("> is acceptable.\n");
            } else {
                sb.append("<").append(input).append("> is not acceptable.\n");
            }
        }
        System.out.print(sb);
    }

    // 3가지 조건을 체크
    public static boolean isValid(String s) {
        boolean hasVowel = false; // 모음 포함 여부
        int vCnt = 0;             // 연속된 모음 개수
        int cCnt = 0;             // 연속된 자음 개수
        char prev = ' ';          // 이전 문자 저장

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            boolean currIsVowel = isVowel(curr);

            // 모음이 하나라도 있는지 체크
            if (currIsVowel) hasVowel = true;

            // 모음/자음 3개 연속 체크
            if (currIsVowel) {
                vCnt++;
                cCnt = 0;
            } else {
                cCnt++;
                vCnt = 0;
            }
            if (vCnt >= 3 || cCnt >= 3) return false;

            // 같은 글자 연속 체크 (ee, oo 제외)
            if (i > 0 && curr == prev) {
                if (curr != 'e' && curr != 'o') return false;
            }
            prev = curr;
        }

        return hasVowel; // 모음이 하나도 없으면 false, 있으면 true
    }

    // 도우미 함수: 자음/모음 판별을 단순화
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
