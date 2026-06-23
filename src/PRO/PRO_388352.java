package PRO;

// 비밀 암호 해독
public class PRO_388352 {
    // static 변수
    static int answer;
    static int[] recur;

    public static void main(String[] args) {
        int n = 10;
        int[][] q = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
        int[] ans = {2,3,4,3,3};
        System.out.println(solution(n, q, ans));
    }

    public static int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        recur = new int[5];

        comb(1, 0, n, q, ans);

        return answer;
    }

    // 조합 생성 재귀 메서드
    private static void comb(int start, int depth, int n, int[][] q, int[] ans) {
        // 종료 조건
        if (depth == 5) {
            // 완성된 후보가 모든 힌트 조건 만족 여부 검증
            if (check(recur, q, ans, n)) {
                answer++;
            }
            return;
        }

        // 재귀
        for (int i = start; i <= n; i++) {
            recur[depth] = i;
            comb(i+1, depth+1, n, q, ans);
        }
    }

    // 후보가 조건을 만족하는지 체크하는 메서드
    private static boolean check(int[] candi, int[][] q, int[] ans, int n) {
        // 빠른 조회를 위해 candi에 포함된 숫자들을 boolean 배열에 마킹
        boolean[] present = new boolean[n+1];
        for (int num : candi) {
            present[num] = true;
        }

        // 모든 시도를 순회
        for (int i=0; i < q.length; i++) {
            int[] arr = q[i];
            int expected = ans[i];  // 이번 idx에서 맞았어야하는 수
            int actual = 0;

            // arr의 숫자 중 몇 개가 있는지 카운트
            for (int num : arr) {
                if (present[num]) {
                    actual++;
                }
            }

            // 힌트와 실제가 다르면 바로 종료
            if (actual != expected) {
                return false;
            }
        }   // for문 종료

        return true;
    }
}
