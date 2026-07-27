package PRO;

// 퍼즐 게임 챌린지
public class PRO_340212 {
    public static void main(String[] args) {
        int[] diffs = {1,5,3};
        int[] times = {2,4,7};
        long limit = 30;
        System.out.println(solution(diffs, times, limit));
    }

    public static int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        int right = 0;

        // diffs 중 최댓값을 right로 설정
        for (int i = 0; i < n; i++) {
            right = Math.max(right, diffs[i]);
        }

        int left = 1; // 최소 숙련도는 1
        int level = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                int diff = diffs[i];
                long timeCur = times[i];
                long timePre = (i == 0) ? 0 : times[i - 1];

                if (mid >= diff) {
                    sum += timeCur;
                } else {
                    long replay = diff - mid;
                    // (long) 연산으로 오버플로우 방지
                    sum += (timePre + timeCur) * replay + timeCur;
                }

                // 이미 limit을 넘어섰다면 더 계산하지 않고 종료
                if (sum > limit) break;
            }

            if (sum <= limit) {
                level = mid;      // 조건 충족 시 정답 후보 저장 후 더 작은 level 탐색
                right = mid - 1;
            } else {
                left = mid + 1;   // 조건 미달 시 더 높은 level 탐색
            }
        }

        return level;
    }
}
