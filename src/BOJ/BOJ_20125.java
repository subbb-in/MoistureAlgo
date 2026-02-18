package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20125 {
    static int N;
    static char[][] cookie;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 칸의 길이
        cookie = new char[N+1][N+1];
        boolean head = false;
        int headX = 0;
        int headY = 0;

        // 쿠키 판을 입력 받음
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                cookie[i][j] = line.charAt(j-1);
                if (cookie[i][j] == '*' && !head) {
                    headX = j;
                    headY = i;
                    head = true;    // 다시 돌지 않도록 true로 변경
                }
            }
        }

        // 심장의 좌표
        int heartX = headX;
        int heartY = headY+1;
        System.out.println(heartY+" "+heartX);  // 첫번째 출력

        // 왼팔
        int left = 0;
        int curX = heartX -1;
        while (curX >= 1 && cookie[heartY][curX] == '*') {
            left++;
            curX--;
        }

        // 오른팔
        int right = 0;
        curX = heartX+1;
        while (curX <= N && cookie[heartY][curX] == '*') {
            right++;
            curX++;
        }

        // 허리
        int center = 0;
        int curY = heartY+1;
        while (curY <= N && cookie[curY][heartX] == '*') {
            center++;
            curY++;
        }

        int centerEndY = heartY+center;

        // 왼다리
        int leftLeg = 0;
        curY = centerEndY + 1;
        while (curY <= N && cookie[curY][heartX-1] == '*') {
            leftLeg++;
            curY++;
        }

        // 오른다리
        int rightLeg = 0;
        curY = centerEndY + 1;
        while (curY <= N && cookie[curY][heartX+1]=='*') {
            rightLeg++;
            curY++;
        }

        System.out.println(left+" "+right+" "+center+" "+leftLeg+" "+rightLeg);
    }
}
