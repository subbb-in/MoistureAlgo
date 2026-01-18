package PRO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PRO_42584 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(arr)));
    }

    private static int[] solution(int[] prices) {

        // 최종 값을 반환할 리스트
        List<Integer> list = new ArrayList<>();

        // 값을 담을 스택
        Stack<Integer> stack = new Stack<>();

        // 주식 가격으로 스택 초기화 : 무엇을 스택으로 담을지 고민된다면 종료 조건을 생각해보자
        for (int i = prices.length-1; i >= 0; i--) {
            stack.push(prices[i]);
        }

        while (!stack.isEmpty()) {
            // 비교할 숫자
            int N = stack.get(stack.size() - 1);
            int cnt = 0;
            for (int i = stack.size() - 2; i >= 0; i--) {
                cnt++;

                if (stack.get(i) < N) {
                    break;
                }
            }
            list.add(cnt);
            stack.pop();
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
