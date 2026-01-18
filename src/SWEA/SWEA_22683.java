package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_22683 {

    static int N, K; // 지도의 한변의 길이, 벨 수 있는 횟수
    static char[][] map; // 지도 배열
    static int sy, sx;               // 시작 위치(X)
    static final int[] dy = {-1, 0, 1, 0}; // 0:↑,1:→,2:↓,3:←
    static final int[] dx = {0, 1, 0, -1};

    static class Node {
        int y, x, k, dir, cost;
        Node(int y, int x, int k, int dir, int cost) {
            this.y = y; this.x = x; this.k = k; this.dir = dir; this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                String row = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    map[i][j] = row.charAt(j);
                    if (map[i][j] == 'X') { // 시작 위치
                        sy = i; sx = j;
                    }
                }
            }

            int ans = bfs();

            System.out.println("#" + tc + " " + ans);

        } // test case
    } // main

    private static int bfs() {
        boolean[][][][] vis = new boolean[N][N][K + 1][4];
        Deque<Node> q = new ArrayDeque<>();

        // 시작 방향은 '위(0)'
        vis[sy][sx][K][0] = true;
        q.add(new Node(sy, sx, K, 0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 목표에 도달하면 조작 횟수 반환
            if (map[cur.y][cur.x] == 'Y') return cur.cost;

            // 1) 전진
            int ny = cur.y + dy[cur.dir];
            int nx = cur.x + dx[cur.dir];
            if (check(ny, nx)) {
                char cell = map[ny][nx];
                if (cell == 'G' || cell == 'Y' || cell == 'X') {
                    if (!vis[ny][nx][cur.k][cur.dir]) {
                        vis[ny][nx][cur.k][cur.dir] = true;
                        q.add(new Node(ny, nx, cur.k, cur.dir, cur.cost + 1));
                    }
                } else if (cell == 'T') {
                    // 나무면 베고 지나가야 함
                    if (cur.k > 0 && !vis[ny][nx][cur.k - 1][cur.dir]) {
                        vis[ny][nx][cur.k - 1][cur.dir] = true;
                        q.add(new Node(ny, nx, cur.k - 1, cur.dir, cur.cost + 1));
                    }
                }
            }

            // 2) 오른쪽 회전
            int rd = (cur.dir + 1) % 4;
            if (!vis[cur.y][cur.x][cur.k][rd]) {
                vis[cur.y][cur.x][cur.k][rd] = true;
                q.add(new Node(cur.y, cur.x, cur.k, rd, cur.cost + 1));
            }

            // 3) 왼쪽 회전
            int ld = (cur.dir + 3) % 4;
            if (!vis[cur.y][cur.x][cur.k][ld]) {
                vis[cur.y][cur.x][cur.k][ld] = true;
                q.add(new Node(cur.y, cur.x, cur.k, ld, cur.cost + 1));
            }
        }

        // 도달 불가
        return -1;

    } // bfs

    // 범위검증
    private static boolean check(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }

} // class
