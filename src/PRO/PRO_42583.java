package PRO;

import java.util.ArrayDeque;
import java.util.Deque;

// 다리를 지나는 트럭
public class PRO_42583 {

    public static void main(String[] args) {
        int len = 2;
        int weight = 10;
        int[] truck = {7,4,5,6};
        System.out.println(solution(len, weight, truck));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> que = new ArrayDeque<>();
        int sum = 0;    // 다리 위 무게 변수
        int cnt = 0;    // 시간

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];
            while (true) {
                if (que.isEmpty()) {    // 큐가 비어있다면 que에 truck을 올리고 무게를 더해준 뒤 시간 ++
                    que.add(truck);
                    sum += truck;
                    cnt++;
                    break;
                } else if (que.size() == bridge_length) {   // 다리 길이와 que의 size가 같다면 무게를 뽑음
                    sum -= que.poll();
                } else {
                    if (sum+truck <= weight) {  // 최대 중량보다 작으면 que에 더함
                        que.add(truck);
                        sum += truck;
                        cnt++;
                        break;
                    } else {
                        que.add(0); // 아니라면 0을 넣어줌
                        cnt++;
                    }
                }
            }

        }
        return cnt+bridge_length; 
    }
}
