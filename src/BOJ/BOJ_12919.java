package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// A와 B 2
public class BOJ_12919 {
    static int result;
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // S : 첫 번째 문자열 , T : 두 번째 문자열
        String S = br.readLine();
        String T = br.readLine();

        recur(S, T);

        System.out.println(result);
    }

    // T를 S처럼 줄여나가는 방식
    private static void recur(String S, String T) {
        // 길이가 T가 되면 재귀 종료
        if (S.length() == T.length()) {
            if (S.equals(T)) {  // 문자열이 같은지 비교
                result = 1;
            }
            return;
        }
        // 첫 글자가 B라면
        if (T.charAt(0) == 'B') {
            String substring = T.substring(1);  // 첫 글자를 제외한 1부터 끝까지 문자열에 담고
            StringBuilder sb = new StringBuilder(substring);
            String str = sb.reverse().toString();   // 거꾸로 뒤집어서
            recur(S,str);
        }

        // 첫 글자가 A라면
        if (T.charAt(T.length()-1) == 'A') {
            recur(S, T.substring(0, T.length()-1));
        }
        return;
    }
}
