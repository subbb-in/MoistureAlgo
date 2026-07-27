package PRO;

import java.util.ArrayDeque;
import java.util.Queue;

// 리코쳇 로봇
public class PRO_169199 {

    static int h, w;    // 높이, 너비
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) {
        String[] arr = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(solution(arr));
    }

    public static int solution(String[] board) {
        int sx = -1;   // start x 좌표
        int sy = -1;    // start y 좌표
        int gx = -1;    // goal x 좌표
        int gy = -1;    // goal y 좌표
        h = board.length;   // 높이
        w = board[0].length();  // 너비

        // map 초기화
        map = new char[h][w];

        // visited 초기화
        visited = new boolean[h][w];

        // 지도 매핑
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') { // 시작 좌표 마킹
                    sy = i;
                    sx = j;
                }

                // 목표 지점 마킹
                if (map[i][j] == 'G') {
                    gy = i;
                    gx = j;
                }
            }
        }

        // bfs 실행
        int answer = bfs(sy, sx, gy, gx);

        return answer;
    }

    // BFS 메서드
    public static int bfs(int sy, int sx, int gy, int gx) {
        Queue<int[]> que = new ArrayDeque<>();

        que.offer(new int[] {sy, sx, 0});
        visited[sy][sx] = true;

        while(!que.isEmpty()) {
            // 큐에서 하나 뽑기
            int[] poll = que.poll();

            // 4 방향으로 탐색
            for (int i = 0; i < 4; i++) {
                int ny = poll[0];
                int nx = poll[1];

                // 미끄러지기
                while(check(ny, nx)) {
                    ny += dy[i];
                    nx += dx[i];
                }

                ny -= dy[i];
                nx -= dx[i];

                // goal에 도착했다면 횟수 반환
                if (poll[0] == gy && poll[1] == gx) {
                    return poll[2];
                }

                // 방문 체크
                if (visited[ny][nx] == false) {
                    // 통과한 좌표를 que에 넣음
                    que.offer(new int[] {ny, nx, poll[2]+1});

                    // 방문처리
                    visited[ny][nx] = true;
                }
            }
        }
        return -1;
    }

    // 범위 검증
    private static boolean check(int ny, int nx) {
        if (nx >= 0 && nx < w && ny >= 0 && ny < h && map[ny][nx] != 'D') return true;
        return false;
    }
}
