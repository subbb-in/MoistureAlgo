package ETC;

import java.util.ArrayList;
import java.util.List;

public class ETC_26_3_Autoever_1 {

    private static class Server {
        long cumulative = 0;    // 누적 처리량(데이터양 합)
        int freeAt = 0; // 이 시각부터 재사용 가능
    }

    public static void main(String[] args) {
        int[] dataAmt = {4,4,1,2};
        int[] time = {4,1,2,3};
        System.out.println(solution(dataAmt, time));
    }

    public static long solution(int[] dataAmount, int[] processTime) {
        int n = dataAmount.length;
        List<Server> servers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // 시각 t에 놀고 있는 서버 중 누족 처리량 최소 서버 선택
            Server target = null;
            for (Server s : servers) {
                if (s.freeAt <= i) {
                    if (target == null || s.cumulative < target.cumulative) {
                        target = s;
                    }
                }
            }

            // 놀고 있는 서버가 없으면 새로 개설
            if (target == null) {
                target = new Server();
                servers.add(target);
            }

            // 작업 배정
            target.cumulative += dataAmount[i];
            target.freeAt = i + processTime[i];
        }

        // 누적 처리량 최댓값 반환
        long answer = 0;
        for (Server s : servers) {
            answer = Math.max(answer, s.cumulative);
        }
        return answer;
    }
}
