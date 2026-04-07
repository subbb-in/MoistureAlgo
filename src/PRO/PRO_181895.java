package PRO;

import java.util.ArrayList;
import java.util.Arrays;

public class PRO_181895 {
    // solution 함수
    public static int[] solution(int[] arr, int[][] intervals) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            for (int k = start; k <= end; k++) {
                list.add(arr[k]);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
