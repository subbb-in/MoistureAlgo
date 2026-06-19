package PRO;

// 이웃한 칸
public class PRO_250125 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;
        System.out.println(solution(board, h, w));
    }

    public static int solution(String[][] board, int h, int w) {
        int answer = 0;
        String center = board[h][w];    // 중앙의 단어
        int rows = board.length;      // 전체 길이
        int cols = board[0].length;   // 전체 행

        for (int i = 0; i < 4; i++) {
            int nx = w + dx[i]; // 다음 위치
            int ny = h + dy[i];
            if (!check(ny, nx, rows, cols)) continue; //  범위가 넘어가면 패스

            // 그 센터에 있는 글자가 다음 좌표의 글자와 같은지 비교
            if (center.equals(board[ny][nx])) {
                answer++;
            }
        }
        return answer;
    }

    // 범위 검증
    private static boolean check(int ny, int nx, int h, int w) {
        if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
            return false;
        }
        return true;
    }
}
