package PRO;

import java.util.Arrays;

// 숫자 카드 나누기
public class PRO_135807 {
    public static void main(String[] args) {
        int[] arrayA = {10,17};
        int[] arrayB = {5,20};
        System.out.println(solution(arrayA, arrayB));
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int n = arrayA.length;
        int m = arrayB.length;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        // 각 배열의 최대 공약수 구하기
        int x = arrayA[0];
        for (int i = 1; i < n; i++) {
            x = method(arrayA[i], x);
        }

        int y = arrayB[0];

        for (int i = 1; i < m; i++) {
            y = method(arrayB[i], y);
        }

        if (!divided(arrayB, x)) {
            answer = Math.max(answer, x);
        }

        if (!divided(arrayA, y)) {
            answer = Math.max(answer, y);
        }
        return answer;
    }

    private static int method(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return method(y, x % y);
        }
    }

    private static boolean divided(int[] arr, int a) {
        boolean divided = false;
        if (a <= 1) {
            return true;
        }
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] % a == 0) {
                divided = true;
            }
        }
        return divided;
    }
}

