package PRO;

import java.util.PriorityQueue;

// 더 맵게
public class PRO_42626 {
    public static void main(String[] args) {
        int[] scov = {1,2,3,9,10,12};
        int k = 7;
        System.out.println(solution(scov, k));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        // 우선순위 큐 선언
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 배열 que에 담기
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        // 가장 먼저 나올 숫자가 K보다 작으면 반복
        while (queue.peek() < K) {
            // queue 의 사이즈가 1이면 K를 넘을 방법이 없음
            if (queue.size() == 1) return -1;
            // 음식 섞기
            queue.add(queue.poll() + queue.poll()*2);
            answer++;
        }
        return answer;
    }
}
