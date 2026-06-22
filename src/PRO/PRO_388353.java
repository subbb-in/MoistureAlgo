package PRO;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class PRO_388353 {
    // 연속되지 않은 알파벳의 경우 : 지게차
    // 연속된 알파벳 : 크레인

    // static 변수
    static int N, M;
    static char[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) {
        String[] storage = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests = {"A", "BB", "A"};
        System.out.println(solution(storage, requests));
    }

    public static int solution(String[] storage, String[] requests) {
        int answer = 0; // 모든 요청을 순서대로 완료한 뒤 남은 컨테이너 수
        N = storage.length;
        M = storage[0].length();

        // 배열 채우기
        map = new char[N+2][M+2];
        for (int i = 0; i < N+2; i++) {
            Arrays.fill(map[i], '.');   // 바깥 지역은 '.'
        }

        for (int i = 0; i < N; i++) {
            String str = storage[i];
            for (int j = 0; j < M; j++) {
                map[i+1][j+1] = str.charAt(j);  // 철자 1개를 배열에 입력
            }
        }

        // request 가져오기 : command의 길이가 1이면 지게차, 아니면 크레인
        for (int i = 0; i < requests.length; i++) {
            String command = requests[i];
            char ch = command.charAt(0);
            if (command.length() == 1) {
                car(ch);    // 지게차
            } else {
                crane(ch);
            }
        }

        // 남은 개수 카운트
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] != '.') answer++;
            }
        }

        return answer;
    }

    // 지게차 메서드 : BFS
    private static void car(char ch){
        ArrayDeque<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[N+2][M+2];
        ArrayList<int[]> remove = new ArrayList<>();

        que.add(new int[]{0,0});
        visited[0][0] = true;

        while (!que.isEmpty()) {
            int[] curr = que.poll();

            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];

                // 범위 검증
                if (ny < 0 || ny >= N+2 || nx < 0 || nx >= M+2) continue;

                if (visited[ny][nx]) continue;  // 방문한 곳이라면 pass

                if (map[ny][nx] == '.') {
                    visited[ny][nx] = true;
                    que.add(new int[]{ny, nx}); // 빈 공간이면 타고 들어감
                } else if (map[ny][nx] == ch) { //
                    visited[ny][nx] = true;
                    remove.add(new int[]{ny, nx});
                }
            }
        }

        // BFS 완료 후 remove 리스트 제거
        for (int[] arr : remove) {
            map[arr[0]][arr[1]] = '.';
        }
    }

    // 크레인 메서드
    private static void crane(char ch){
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == ch) {
                    map[i][j] = '.';
                }
            }
        }
    }
}
