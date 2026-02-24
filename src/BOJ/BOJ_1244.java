package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
    static int N;
    static int[] button;

    public static void main(String[] args) throws IOException {
        // input 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // N개의 스위치
        N = Integer.parseInt(br.readLine());

        // 8개의 스위치 상태를 받음
        button = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            button[i] = Integer.parseInt(st.nextToken());   // 스위치 상태를 넣음
        }

        // 학생수
        int std = Integer.parseInt(br.readLine());
        for (int i = 0; i < std; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());  // 성별
            int num = Integer.parseInt(st.nextToken());     // 받은 자연수

            if (gender == 1) {
                manButton(num);
            } else {
                womanButton(num);
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(button[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }

    public static void manButton(int num) {
        for (int i = num; i <= N; i += num) {
            button[i] = 1-button[i];
        }
    }

    public static void womanButton(int num) {
        // 본인 번호의 스위치 변경
        button[num] = 1 - button[num];
        // 양쪽 번호가 같다면 변경
        int i = 1;
        while (true) {
            if (!range(num - i) || !range(num + i)) {
                break;
            }
            if (button[num - i] == button[num + i]) {
                button[num - i] = 1 - button[num - i];
                button[num + i] = 1 - button[num + i];
                i++;
            } else {
                break;
            }
        }
    }

    public static boolean range(int idx) {
        return idx >= 1 && idx <= N;
    }

}
