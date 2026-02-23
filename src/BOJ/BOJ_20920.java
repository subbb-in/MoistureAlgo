package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20920 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 단어의 개수
        int M = Integer.parseInt(st.nextToken());   // 단어의 길이 기준

        Map<String, Integer> map = new HashMap<>(100000);
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue;    // 단어의 길이가 M보다 작으면 지나침

            map.put(word, map.getOrDefault(word, 0) + 1);    // 해당 키에 맞는 값을 가져오고 1을 더함
        }

        StringBuilder sb = new StringBuilder();

        map.entrySet().stream()
                .sorted(
                        // 1순위: 빈도수 내림차순
                        Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                                // 2순위: 단어 길이 내림차순
                                .thenComparing(entry -> entry.getKey().length(), Comparator.reverseOrder())
                                // 3순위: 알파벳 사전 순 오름차순 (naturalOrder)
                                .thenComparing(Map.Entry.comparingByKey())
                )
                .forEach(entry -> sb.append(entry.getKey()).append("\n"));

        // 한 번에 출력 (10만 건 출력 시 필수)
        System.out.print(sb);
    }
}
