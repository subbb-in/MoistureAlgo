package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class BOJ_7576 {

    // 토마토 농장의 세로, 가로
    static int N, M;
    static int cnt; // 최대 일수
    // 토마토 농장 배열
    static int[][] map;
    // 시작점이 N 개이기 때문에 전체에서 관리할 큐가 필요함
    static Queue<Tomato> que = new LinkedList<>();
    // dx, dy
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Tomato{
        int x, y, day;

        public Tomato(int day, int y, int x) {
            this.day = day;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    que.offer(new Tomato(0, i, j));
                }
            }
        }
        bfs();
    }

    static void bfs(){
        int day = 0;

        while (!que.isEmpty()) {
            Tomato t = que.poll();
            day = t.day;

            // 4방 탐색
            for (int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }
                if(map[ny][nx] == 0){
                    map[ny][nx] = 1;
                    que.add(new Tomato(day+1, ny, nx));
                }
            }
        }

        if(checkTomato()) {
            System.out.println(day);
        } else System.out.println(-1);
    } // bfs

    static boolean checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
