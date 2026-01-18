package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 치즈 도둑
public class SWEA_7733 {
    static int N; // 치즈의 한 변의 길이
    static int cnt; // 최대 치즈 덩어리
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            int max = 0; // 최대 치즈 배열 숫자

            // 치즈맵 배열 초기화
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }

            cnt = 1;
            for (int i = 1; i <= max; i++) {
                visited = new boolean[N][N];
                int num = 0;

                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (map[j][k] == i) {
                            map[j][k] = 0;
                        }
                    }
                }

                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (!visited[j][k] && map[j][k] > 0) {
                            bfs(j, k);
                            num++;
                        }
                    }
                }
                cnt = Math.max(cnt, num);
            }

            System.out.println("#" + tc + " " + cnt);

        }
    }

    static void bfs(int y, int x) {

        // 큐를 생성
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[] {y, x});
        visited[y][x] = true;

        while (!que.isEmpty()) {

            int[] curr = que.poll();  // 큐에서 꺼냄
            int cy = curr[0];  // 변수에 담음
            int cx = curr[1];

            for (int l = 0; l < 4; l++) {  // 4방 탐색
                int nx = cx + dx[l];
                int ny = cy + dy[l];

                // 범위 검증
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                // 기본 조건 검증
                if (map[ny][nx] == 0) continue;

                // 방문 여부 체크
                if (visited[ny][nx]) continue;

                que.add(new int[] {ny, nx});
                visited[ny][nx] = true;

            }

        }// while 문

    } // bfs
}
