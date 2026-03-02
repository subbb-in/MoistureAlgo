package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_2607 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String first = br.readLine();

        int[] firstCnt = new int[26];
        for (int i = 0; i < first.length(); i++) {
            firstCnt[first.charAt(i) - 'A']++;
        }

        int ans = 0;

        for (int i = 0; i < N-1; i++) {
            String target = br.readLine();
            int[] targetCnt = new int[26];

            for (int j = 0; j < target.length(); j++) {
                targetCnt[target.charAt(j) - 'A']++;
            }

            int diff = 0;

            for (int j = 0; j < 26; j++) {
                diff += Math.abs(firstCnt[j] - targetCnt[j]);
            }

            if(diff <= 1 || (diff == 2 && first.length() == target.length())) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
