package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 숨바꼭질 3
public class BOJ_13549 {
    static int N, K;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N : 수빈 위치 K : 동생 위치
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        System.out.println(bfs());
    }

    private static int bfs() {
        // 우선순위 큐로 시간 오름차순으로 정렬된 Node를 넣음
        PriorityQueue<Node> que = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        que.offer(new Node(N, 0));  // 현재 위치와 시간을 Node로 넣음

        while (!que.isEmpty()) {
            Node node = que.poll();

            // 목표 위치 K에 도달했을 때
            if (node.p == K) {
                return node.time;
            }

            // 이미 방문한 위치라면 지나감
            if (visited[node.p]) {
                continue;
            }

            visited[node.p] = true;

            // 1. 순간이동 (가중치 0)
            if (node.p * 2 <= 100000 && !visited[node.p*2]) {
                que.offer(new Node(node.p*2, node.time));
            }

            // 2. 뒤로 이동 (가중치 1)
            if (node.p-1 >= 0 && !visited[node.p-1]) {
                que.offer(new Node(node.p-1, node.time+1));
            }

            // 3. 앞으로 이동 (가중치 1)
            if (node.p+1 <= 100000 && !visited[node.p+1]) {
                que.offer(new Node(node.p+1, node.time+1));
            }
        }
            return -1;
    }

    public static class Node {
        int p;  // 현재 위치
        int time;   // 가중치

        public Node(int p, int time) {
            this.p = p;
            this.time = time;
        }
    }
}
