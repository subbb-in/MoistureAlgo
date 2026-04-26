package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 틱택토
public class BOJ_7682 {
    static char[][] board;  // 보드 배열

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String tic = br.readLine();

            // 만약 end가 들어오면 종료
            if (tic.equals("end")) {
                break;
            }

            int xCnt = 0;
            int oCnt = 0;
            board = new char[3][3];

            // x와 o 개수 카운트
            int idx = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = tic.charAt(idx++);
                    if (board[i][j] == 'X') {
                        xCnt++;
                    } else if (board[i][j] == 'O') {
                        oCnt++;
                    }
                }
            }

            // X와 O가 각각 빙고를 완성했는지 확인
            boolean xWin = checkWin('X');
            boolean oWin = checkWin('O');

            // 조건 1 : X가 이긴 경우
            if (xWin && !oWin && xCnt == oCnt +1) {
                sb.append("valid\n");
            } else if (!xWin && oWin && xCnt == oCnt) {
                sb.append("valid\n");
            } else if (!xWin && !oWin && xCnt == 5 && oCnt == 4) {
                sb.append("valid\n");
            } else {
                sb.append("invalid\n");
            }
        }
        System.out.println(sb.toString());
    }

    // 가로 세로 대각선 빙고 체크하는 메서드
    private static boolean checkWin(char c){
        // 가로 3줄
        for (int i = 0; i < 3; i ++) {
            if (board[i][0] == c && board[i][1] == c && board[i][2] == c) return true;
        }
        // 세로 3줄
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == c && board[1][i] == c && board[2][i] == c) return true;
        }

        // 대각선 2줄 확인
        if (board[0][0] == c && board[1][1] == c && board[2][2] == c) return true;
        if (board[0][2] == c && board[1][1] == c && board[2][0] == c) return true;
        return false;
    }
}
