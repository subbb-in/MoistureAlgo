package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 트럭
public class BOJ_13335 {
    public static void main(String[] args) throws IOException {
        // 입력 받을 객체 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 공백을 기준으로 나눔
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N : 트럭 수
        int N = Integer.parseInt(st.nextToken());

        // W : 다리길이
        int W = Integer.parseInt(st.nextToken());

        // L : 최대 하중
        int L = Integer.parseInt(st.nextToken());

        // 트럭을 받음
        Queue<Integer> truck = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        // sum : 현재 올라간 무게
        int sum = 0;

        // 다리 길이 W를 리스트로 만들기
        Queue<Integer> bridge = new LinkedList<>();

        // 리스트를 0으로 초기화
        for (int i = 0; i < W; i++) {
            bridge.offer(0);
        }

        // 시간
        int time = 0;

        // 트럭이 안남으면 반복 종료
        while (!(truck.isEmpty() && sum == 0)) {

            sum -= bridge.poll();
            if (!truck.isEmpty()) {
                if (truck.peek() + sum <= L) {
                    sum += truck.peek();
                    bridge.add(truck.poll());
                } else {
                    bridge.add(0);
                }
            } else {
                bridge.add(0);
            }

            time++;
        }

        System.out.println(time);

    }
}
