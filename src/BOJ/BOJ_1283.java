package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1283 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // 옵션의 개수
        int N = Integer.parseInt(br.readLine());
        // 알파벳 사용 여부
        boolean[] used = new boolean[26];

        for (int i = 0; i < N; i++) {
            String com = br.readLine();
            String[] words = com.split(" ");
            boolean found = false;

            // 1. 첫 글자 검사
            for (int j = 0; j < words.length; j++) {
                char first = Character.toUpperCase(words[j].charAt(0));
                if (!used[first - 'A']) {
                    used[first - 'A'] = true;
                    found = true;

                    // 해당 단어에 [] 씌움
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);
                    break;
                }
            }

            // 2. 다음 글자들 검사
            if (!found) {
                for (int j = 0; j < words.length; j++) {
                    for (int k = 0; k < words[j].length(); k++) {
                        char ch = Character.toUpperCase(words[j].charAt(k));
                        if (!used[ch - 'A']) {
                            used[ch - 'A'] = true;
                            found = true;
                            words[j] = words[j].substring(0, k) + "[" + words[j].charAt(k) + "]" + words[j].substring(k + 1);
                            break;
                        }
                    }
                    if (found) break;
                }
            }

            // 3. 출력
            for (int j = 0; j < words.length; j++) {
                sb.append(words[j]).append(j == words.length - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
