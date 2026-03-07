package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 가희와 키워드
public class BOJ_22233 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 키워드 개수
        int N = Integer.parseInt(st.nextToken());
        // 블로그 글 개수
        int M = Integer.parseInt(st.nextToken());

        // 키워드르 HashSet에 담아야함
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        // StringBuilder를 사용해야함
        StringBuilder sb = new StringBuilder();

        // 블로그 글 개수만큼 반복
        for (int i = 0; i < M; i++) {
            String[] data = br.readLine().split(",");

            for (int j = 0; j < data.length; j++) {
                // 키워드가 목록에 있다면 지움
                if (set.contains(data[j])) {
                    set.remove(data[j]);
                }
            }
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
