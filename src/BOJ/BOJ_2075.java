package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// N번째 큰 수
public class BOJ_2075 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 배열
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                que.add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < N - 1; i++) {
            que.poll();
        }
        System.out.println(que.peek());
    }
}
