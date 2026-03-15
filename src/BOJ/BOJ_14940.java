package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 쉬운 최단거리
public class BOJ_14940 {

    static int N, M, tx, ty;
    static int dx[]={0,0,1,-1};
    static int dy[]={1,-1,0,0};
    static int[][] map;
    static int[][] ans;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N : 세로, M : 가로
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 정답 배열 초기화
        ans = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(ans[i], -1);
        }

        // 방문 확인 배열 초기회
        visited = new boolean[N][M];

        // 지도 초기화
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                // 입력값이 0이라면 정답안에도 0 지정
                if (tmp == 0) {
                    ans[i][j] = 0;
                } else if (tmp == 2) {  // 타겟 지점 마킹
                    tx = j;
                    ty = i;
                    ans[i][j] = 0;
                }
                map[i][j] = tmp;
            }
        }

        // bfs
        bfs(ty, tx);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    // bfs 메서드
    static void bfs(int y, int x) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {y, x});  // 첫 번째 y, x를 넣고
        visited[y][x] = true;   // 방문처리
        // 큐가 비워질 때까지 반복
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int cy = cur[0];
            int cx = cur[1];
            for (int i = 0; i < 4; i++) {
                // 다음 좌표 지정
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                // 조건 검사  : 갈 수 있는 곳이라면
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[ny][nx]==1 && !visited[ny][nx]) {
                    // 방문처리, 거리 마크, 큐에 넣기
                    visited[ny][nx] = true;
                    ans[ny][nx] = ans[cy][cx] +1;
                    que.add(new int[] {ny, nx});
                }
            }
        }
    }
}
