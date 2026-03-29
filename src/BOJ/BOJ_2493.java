package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 탑
public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());    // 탑의 수
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 스택에 높이, 인덱스 배열을 저장
        Stack<int[]> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            // 스택이 비어있지 않다면
            while (!stack.isEmpty()) {
                int[] top = stack.peek();
                if (top[0] >= height) {
                    sb.append(top[1]).append(" ");
                    break;
                }
                stack.pop();    // 기존 것을 빼냄
            }

            // 스택이 비어있다면
            if (stack.isEmpty()) {
                sb.append("0 ");
            }

            // 스택에 현재 탑을 추가함
            stack.push(new int[]{height, i});
        }
        System.out.println(sb.toString().trim());
    }
}
