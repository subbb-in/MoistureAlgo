package PRO;

import java.util.Arrays;

// 공원
public class PRO_340198 {
    public static void main(String[] args) {
        int[] mats = {5, 3, 2};
        String[][] park = {{"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};

        System.out.println(solution(mats, park));
    }

    public static int solution(int[] mats, String[][] park) {

        int height = park.length;
        int width = park[0].length;

        // 돗자리 크기를 정렬한 뒤 큰 값부터 검사함
        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i]; // 현재 돗자리 크기

            // 탐색과정
            for (int j = 0; j <= height - size; j++) {
                for (int k = 0; k <= width - size; k++) {
                    if (check(j, k, size, park)) {
                        return size;
                    }
                }
            }
        }
        return -1;
    }

    // 가능한지 확인하는 메서드
    private static boolean check(int r, int c, int size, String[][] park) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}
