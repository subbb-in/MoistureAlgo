package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        // input & output
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 문자열 입력
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine()); //  명령어 개수

        Stack<Character> left = new Stack<>();  // 커서 왼쪽 관리
        Stack<Character> right = new Stack<>(); // 커서 오른쪽 관리

        // 초기 모든 문자는 커서 왼쪽
        for (char c : str.toCharArray()) {
            left.push(c);
        }

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            char com = command.charAt(0);
            switch (com) {
                case 'L' :  // 커서를 오른쪽으로
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case 'D' :  // 커서를 왼쪽으로
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                case 'P' :  // 왼쪽에 추가
                    char ch = command.charAt(2);
                    left.push(ch);
                    break;
                case 'B' :  // 왼쪽 글자를 삭제함
                    if (!left.isEmpty()) left.pop();
                    break;
            }
        }
        // 결과 출력
        for (char c : left) sb.append(c);
        while(!right.isEmpty()) sb.append(right.pop());

        System.out.println(sb.toString());

    }   // main
}   // class
