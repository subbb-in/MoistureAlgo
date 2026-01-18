package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트의 이동
public class BOJ_7562 {

    static int I;
    static int cx, cy; // 현재 위치
    static int goalX , goalY; // 목표 위치
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[][] dist; // 체스판 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int tc = 1; tc <= T; tc++) {

            I = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이

            dist = new int[I][I]; // 지도 배열 초기화

            st = new StringTokenizer(br.readLine());
            cx = Integer.parseInt(st.nextToken());
            cy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());

            bfs(cy, cx);

            System.out.println(dist[goalY][goalX]);
        } // test case


    } // main 메서드

    static void bfs(int cy, int cx) {

        // 큐를 생성
        Queue<int[]> que = new LinkedList<>();

        // 거리 배열 초기화
        for (int i = 0; i < I; i++) {
            for (int j = 0; j < I; j++) {
                dist[i][j] = -1;
            }
        }

        dist[cy][cx] = 0;
        que.add(new int[] {cy, cx}); // 시작 정점을 큐에 넣음

        while (!que.isEmpty()) { // 큐가 비워질 때까지

            int[] curr = que.poll(); // 큐에서 하나를 빼냄
            int x = curr[1]; // 배열의 첫 번째는 x
            int y = curr[0]; // 배열의 0 번째는 y
            if (x == goalX && y == goalY) return; // 목표 지점을 만나면 함수 종료

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 검증
                if (nx < 0 || nx >= I || ny < 0 || ny >= I) continue;

                // 방문 검증
                if (dist[ny][nx] != -1) continue;

                que.add(new int[] {ny, nx});
                dist[ny][nx] = dist[y][x] +1;
            } // 8방 탐색

        } // while 문


    } // bfs 메서드
}
