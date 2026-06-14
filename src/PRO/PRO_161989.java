package PRO;

// 덧칠하기
public class PRO_161989 {

    public static void main(String[] args) {
        int N = 8;  // 한 변의 길이
        int M = 4;  // 롤러의 길이
        int[] arr = {2, 3, 6};    // 구역 번호 배열
        System.out.println(solution(N, M, arr));
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;

        boolean[] wall = new boolean[n + 1];
        // 색칠이 필요한 벽을 표기함
        for (int i = 0; i < section.length; i++) {
            wall[section[i]] = true;
        }
        // 전체를 돌면서 횟수 카운트
        for (int i = 1; i <= n; i++) {
            if (wall[i] == false) { // 이미 칠해져있다면 패스
                continue;
            }
            // 색칠이 필요하다면 해당 칸으로부터 m칸 색칠
            if (wall[i] == true) {
                for (int j = i; j < i + m; j++) {
                    if (j < n + 1) {
                        wall[j] = false;
                    }
                }
                answer++;   // 색칠 횟수를 증가시킴
            }
        }
        return answer;
    }

}
