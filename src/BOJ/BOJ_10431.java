package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10431 {
    public static void main(String[] args) throws IOException {
        // 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());

        // test case 만큼 반복
        for (int i = 1; i <= P; i++) {
            // 총 횟수
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int testNum = Integer.parseInt(st.nextToken()); // 테스트 케이스
            List<Integer> que = new ArrayList<>();

            for (int j = 0; j < 20; j++) {
                int next = Integer.parseInt(st.nextToken());
                boolean check = false;
                for (int k = 0; k < que.size(); k++) {
                    if(que.get(k) > next) {
                        cnt += (que.size() -k);
                        que.add(k, next);
                        check = true;
                        break;
                    }
                }

                // 내가 제일 크면 맨 뒤로
                if(!check) {
                    que.add(next);
                }
            }

            System.out.println(testNum + " " + cnt);
        }
    }
}
