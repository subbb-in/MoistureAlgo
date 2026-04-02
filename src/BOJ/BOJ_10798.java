package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 세로 읽기
public class BOJ_10798 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 가로 최대값
        int weightMax = 0;
        List<String> list = new ArrayList<>(5);

        for (int i = 0; i < 5; i++) {
            list.add(br.readLine());
        }

        // 최대값 찾기
        for (int i = 0; i < 5; i++) {
            weightMax = Math.max(weightMax, list.get(i).length());
        }

        char[][] arr = new char[5][weightMax];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < weightMax; j++) {
                if (j < list.get(i).length()) {
                    arr[i][j] = list.get(i).charAt(j);
                } else {
                    arr[i][j] = '-';
                }
            }
        }

        for (int i = 0; i < weightMax; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] != '-') {
                    sb.append(arr[j][i]);
                }
            }
        }

        System.out.println(sb.toString());

    }
}
