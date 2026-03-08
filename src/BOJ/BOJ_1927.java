package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 최소 힙
public class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 연산의 개수
        int N = Integer.parseInt(br.readLine());
        // 우선순위 큐
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            // 입력되는 숫자 X
            int X = Integer.parseInt(br.readLine());
            if (X == 0) {   // X가 0이고
                if (minHeap.isEmpty()) {    // 큐가 비어있다면
                    sb.append(0).append("\n");  // 0을 출력
                } else {    // 큐가 비어있지 않다면
                    sb.append(minHeap.poll()).append("\n");     // 가장 작은 값을 출력
                }
            } else {    // 0이 아니라면 heap에 값을 넣음
                minHeap.add(X);
            }
        }
        System.out.println(sb.toString());
    }
}
