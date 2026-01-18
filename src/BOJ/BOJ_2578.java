package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578 {

    static int N;
    static int count; // 빙고 갯수
    static int[][] bingo;

    public static void main(String[] args) throws IOException {
        // 입력 받을 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빙고판 칸수
        N = 5;

        // 빙고판
        bingo = new int[N][N];

        StringTokenizer st;

        // 빙고판 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 몇 번째에 부르는지
        int call = 0;

        // 정답 부르기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                call++;
                int num = Integer.parseInt(st.nextToken());
                bingoCall(num); // 빙고 숫자를 불러서 지우기
                bingoCheck(); // 부르고 난 이후마다 빙고 갯수 검사
                if (count >= 3) { // countk가 3 이상 되면 반복을 멈추고 몇 번째에 불렀는지 반환
                    System.out.println(call);
                    return;
                }
            }
        }
    }

    // 빙고 숫자 불러서 지우기
    private static void bingoCall(int num) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 순회를 돌며 인자가 해당 숫자와 같으면 해당 인덱스의 값을 -1로 변경
                if (bingo[i][j] == num) {
                    bingo[i][j] = -1;
                }
            }
        }
    }

    // 몇 개의 빙고를 달성했는지 확인하는 메서드
    private static void bingoCheck() {
        count = 0;
        int row = 0;
        int col = 0;
        int main_dia = 0; // 주대각
        int sub_dia = 0; // 부대각
        for (int i = 0; i < N; i++) {

            row = 0;
            col = 0;

            for (int j = 0; j < N; j++) {
                row += bingo[i][j]; // 행의 합을 처리
                col += bingo[j][i]; // 열의 합을 처리

                // 주대각 처리
                if (i == j) {
                    main_dia += bingo[i][j];
                }
                // 부대각 처리
                if (i+j == N -1) {
                    sub_dia += bingo[i][j];
                }
            }
            if (row == -5) {
                count++;
            }
            if (col == -5) {
                count++;
            }
            if (main_dia == -5) {
                count++;
            }
            if (sub_dia == -5) {
                count++;
            }
        }
    }
}
