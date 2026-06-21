package PRO;

public class PRO_389479 {
    public static void main(String[] args) {
        int[] player = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;
        System.out.println(solution(player, m, k));
    }

    public static int solution(int[] players, int m, int k) {
        int answer = 0; // 서버 증설 횟수
        int[] server = new int[24]; // 추가 생성 서버

        // 전체 순회하며 증설 횟수 확인
        for (int i = 0; i < players.length; i++) {
            int curServer = players[i] / m; //현재 필요한 서버수

            // 현재 가동 수보다 필요한 서버수가 더 크다면
            if (curServer > server[i]) {
                int add = curServer - server[i];
                answer += add;

                // 추가된 서버 관리
                for (int j = i; j < i+k; j++) {
                    if (j < 24) {
                        server[j] += add;
                    }
                }
            }
        }
        return answer;
    }
}
