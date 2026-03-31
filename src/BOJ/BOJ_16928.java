package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//  뱀과 사다리 게임
public class BOJ_16928 {

    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N : 사다리수 , M : 뱀의 수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[101]; // 게임판
        visited = new boolean[101]; // 방문여부

        // 사다리와 뱀 초기화
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start] = end;
        }

        bfs(1);
    }

    static void bfs(int start) {
        // 첫 번째 요소 넣기
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{start, 0});
        visited[start] = true;

        while (!que.isEmpty()) {
            int[] temp = que.poll();

            // 종료 조건
            if (temp[0] == 100) {
                System.out.println(temp[1]);
                return;
            }

            // 주사위 케이스
            for (int i = 1; i <= 6; i++) {
                int next = temp[0] + i;

                // 100을 넘어가면 무시
                if (next > 100) continue;
                // 가려는 칸에 사다리든 뱀이든 있으면 거기로 가야함
                if (arr[next] != 0) {
                    next = arr[next];
                }

                // 방문하지 않은 곳이라면 방문 처리하고, 새로운 곳을 큐에 넣음
                if (!visited[next]) {
                    visited[next] = true;
                    que.offer(new int[]{next, temp[1]+1});

                }
            }
        }
    }
}
