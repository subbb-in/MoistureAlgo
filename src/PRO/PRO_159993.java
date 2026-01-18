package PRO;

import java.util.ArrayDeque;
import java.util.Deque;

// 미로 탈출
public class PRO_159993 {

    static int N, M; // 가로와 세로
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };
    static int[][] dist;
    static char[][] toCharMap;
    static int answer;
    static int tmp;

    public static int solution(String[] maps) {
        N = maps.length; // 세로
        M = maps[0].length(); // 가로

        answer = -1;
        int sx = -1; // 시작 지점
        int sy = -1;
        int endY = -1;
        int endX = -1;
        int ly = -1;
        int lx = -1;

        // dist 배열 초기화
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = -1;
            }
        }
        toCharMap = new char[N][M];

        // 지도 만들기
        for (int i = 0; i < N; i++) {
            String str = maps[i];
            for (int j = 0; j < str.length(); j++) {
                toCharMap[i][j] = str.charAt(j);
                if (toCharMap[i][j] == 'S') {
                    sx = j;
                    sy = i;
                }
                if (toCharMap[i][j] == 'E') {
                    endY = i;
                    endX = j;
                }
                if (toCharMap[i][j] == 'L') {
                    ly = i;
                    lx = j;
                }
            }
        }

        // 1차 BFS
        tmp = 0;
        int lever = bfs(sy, sx, 'L');
        if (lever == -1)
            return -1;

        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = -1;
            }
        }

        // 2차 BFS
        int goal = bfs(ly, lx, 'E');
        if (goal == -1)
            return -1;

        // 최종 값
        return lever + goal;
    }

    private static int bfs(int sy, int sx, char target) {

        // 큐 생성
        Deque<int[]> que = new ArrayDeque<>();

        // 시작지점을 큐에 넣음
        que.offer(new int[] { sy, sx });

        // 출발지를 0으로 대입
        dist[sy][sx] = 0;

        while (!que.isEmpty()) {
            // 첫번째 큐를 꺼냄
            int[] cur = que.poll();
            int cy = cur[0];
            int cx = cur[1];

            // 4방 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위 검증
                if (nx < 0 || nx >= M || ny < 0 || ny >= N)
                    continue;

                // -1이 아닌 곳만 갈 수 있음
                if (dist[ny][nx] != -1)
                    continue;

                // 갈 수 있는 곳인지
                if (toCharMap[ny][nx] == 'X')
                    continue;

                // 이전 배열에서 1을 더한 값을 ny, nx 에
                dist[ny][nx] = dist[cy][cx] + 1;

                if (toCharMap[ny][nx] == target) {
                    return dist[ny][nx];
                }

                // 다음 큐를 넣음
                que.offer(new int[] { ny, nx });

            }
        }
        return -1;
    }
}
