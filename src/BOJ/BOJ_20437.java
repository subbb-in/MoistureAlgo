package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 문자열 게임 2
public class BOJ_20437 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // T : 게임의 수, W : 문자열, K : 정수
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            // K가 1인 경우 예외 처리(어떤 문자든 길이는 1)
            if (K == 1) {
                System.out.println("1 1");
                continue;
            }

            // 알파벳별 등장 인덱스를 저장할 리스트 배열
            List<Integer>[] pos = new ArrayList[26];
            for (int j = 0; j < 26; j++) {
                pos[j] = new ArrayList<>();
            }

            // 문자열을 순회하며 인덱스 저장
            for (int j = 0; j < W.length(); j++) {
                pos[W.charAt(j)-'a'].add(j);
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = -1;

            // 각 알파벳 리스트를 확인
            for (int j = 0; j < 26; j++) {
                // j번째 알파벳 리스트의 크기를 확인해야 함
                if (pos[j].size() >= K) {
                    // j번째 알파벳 리스트를 순회
                    for (int start = 0; start <= pos[j].size() - K; start++) {
                        int end = start + K - 1;
                        int length = pos[j].get(end) - pos[j].get(start) + 1;

                        minLen = Math.min(minLen, length);
                        maxLen = Math.max(maxLen, length);
                    }
                }
            }

            if (minLen == Integer.MAX_VALUE || maxLen == -1) {
                System.out.println("-1");
            } else {
                System.out.println(minLen + " " + maxLen);
            }
        }
    }

}
