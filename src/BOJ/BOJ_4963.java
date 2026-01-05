package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 섬의 개수
public class BOJ_4963 {
    static int w, h; // 너비와 높이
    static int cnt; // 최종 카운트
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map; // 지도
    static boolean[][] visited; // 방문 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break; // 마지막을 의미하는 입력값이 들어오면 종료

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken()); // 지도 입력 받음
                }
            }

            visited = new boolean[h][w]; // 방문 체크 초기화

            bfs();

            System.out.println(cnt);

        } // while 문

    } // main 메서드

    static void bfs() {

        // 큐 만들기
        Queue<int[]> que = new LinkedList<>();
        cnt = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                if (map[i][j] == 0) continue; // 바다면 지나감
                if (visited[i][j]) continue; // 이미 처리한 섬

                // 새로운 섬 발견
                cnt++;
                que.add(new int[]{i, j}); // 큐에 넣음
                visited[i][j] = true;  // 방문 처리

                while (!que.isEmpty()) {

                    int[] curr = que.poll();  // 큐에서 뽑음
                    int y = curr[0];  // 배열 요소를 변수에 저장
                    int x = curr[1];

                    for (int k = 0; k < 8; k++) { // 8방 탐색
                        int nx = x + dx[k];
                        int ny = y + dy[k];


                        // 범위 검증
                        if (nx < 0 || nx >= w || ny < 0 || ny >= h) continue;

                        // 육지 여부 확인
                        if (map[ny][nx] == 0) continue;

                        // 방문 여부 확인
                        if (visited[ny][nx]) continue;

                        // 방문 처리
                        visited[ny][nx] = true;

                        // 큐에 넣음
                        que.add(new int[]{ny, nx});

                    }

                } // while문

            } // j
        } // i

        // 8방 탐색

    } // bfs

} // 클래스