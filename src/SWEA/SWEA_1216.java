package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 회문 2
public class SWEA_1216 {

    public static void main(String[] args) throws IOException {
        // 입력 받을 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열을 변형할 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 공백기준으로 나눔
        StringTokenizer st;

        // flag 변수
        boolean flag;

        // 10개의 테스트 케이스만큼 반복
        for (int tc = 1; tc <= 10; tc++) {
            int T = Integer.parseInt(br.readLine());

            // 최대 회문 값
            int max = 1;

            // map 2차원 배열
            char[][] map = new char[100][100];

            // 배열을 채움
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j <100; j++) {
                    map[i][j] = br.readLine().charAt(j);
                }
            }

            for (int len = 0; len < 100; len++) { // 전체 배열을 돌기
                for (int j = 2; j <= 100; j++) { // 가로 검사 시작
                    char[] c = new char[j];
                    flag = false;

                    for (int k = 0; k < 100 - j; k++) { // 반대편에서 들어옴
                        for (int l = 0; l < j; l++) { // 전체 길이의 절반만 for문을 돌림
                            c[l] = map[len][l+k];
                        }
                        for (int l = 0; l < j/2; l++) {
                            if(c[l] != c[j-l]) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) { // 만약 플래그가 참으로 들어온다면 최댓값 갱신 검증을 받음
                            max = Math.max(max, j);
                        }
                    }
                }

            }
            // 출력 값
            System.out.println("#"+tc+" "+max);
        }

    }
}
