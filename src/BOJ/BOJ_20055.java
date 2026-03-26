package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 컨베이어 벨트 위의 로봇
public class BOJ_20055 {
    static int N, zero, step;
    static boolean[] isRobot;
    static int[] belt;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N : 칸수 , K : 내구도가 0인 칸의 최대수
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // 내구도 0인 칸의 수
        zero = 0;
        // 현재 단계
        step = 0;
        // 벨트
        belt = new int[N * 2];
        // 로봇 관리 배열
        isRobot = new boolean[N];

        // 초기 세팅
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
            if (belt[i] == 0) {
                zero++;
            }
        }

        // zero가 K개가 되면 반복 종료
        while (zero < K) {
            step++;
            first();
            second();
            third();
        }

        System.out.println(step);
    }

    // 1단계 : 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
    static void first() {
        // 내구도 회전
        int temp = belt[2 * N - 1]; // 마지막 칸의 내구도
        for (int i = 2 * N - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = temp;

        // 로봇 배열 회전
        for (int i = N - 1; i > 0; i--) {
            isRobot[i] = isRobot[i - 1];
        }
        isRobot[0] = false;
        isRobot[N - 1] = false;   // 도착하면 즉시 내림
    }

    // 2단계 : 로봇만 이동
    static void second() {
        for (int i = N - 1; i > 0; i--) {
            if (!isRobot[i] && isRobot[i - 1] && belt[i] > 0) {
                isRobot[i] = true;
                isRobot[i-1] = false;
                belt[i]--;
                if (belt[i] == 0) {
                    zero++;
                }
            }
        }
        isRobot[N-1] = false;
        isRobot[0] = false;
    }

    // 3단계 : 로봇을 올림
    static void third() {
        if (belt[0] > 0) {
            isRobot[0] = true;
            belt[0]--;
            if (belt[0] == 0) {
                zero++;
            }
        }
    }

}
