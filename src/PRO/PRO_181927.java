package PRO;

import java.util.Arrays;

// 마지막 두 원소
public class PRO_181927 {
    public static void main(String[] args) {
        int[] list = {2, 1, 6};

        System.out.println(Arrays.toString(solution(list)));
    }

    public static int[] solution(int[] num_list) {
        int size = num_list.length;

        int[] answer = new int[size + 1];

        int end = 0;
        if (num_list[size - 1] > num_list[size - 2]) {
            end = num_list[size - 1] - num_list[size - 2];
        } else {
            end = num_list[size - 1] * 2;
        }
        for (int i = 0; i < size; i++) {
            answer[i] = num_list[i];
        }
        answer[size] = end;

        return answer;
    }
}
