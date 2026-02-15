package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2816 {

    static String[] channel;

    public static void main(String[] args) throws IOException {
        // 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 채널 개수
        channel = new String[N]; // 채널 목록
        int idx = 0; // 이동 인덱스

        for (int i = 0; i < N; i++) {
            channel[i] = br.readLine(); // 채널 목록을 배열에 담음
        }


        while (!channel[idx].equals("KBS1")) { // KBS1 채널을 만날 때까지 내리기
            idx++;
            sb.append("1");
        }

        while (!channel[0].equals("KBS1")) {
            upChannel(idx);
            idx--; // 인덱스를 위로 올림
            sb.append("4");
        }

        while (!channel[idx].equals("KBS2")) { // KBS1 채널을 만날 때까지 내리기
            idx++;
            sb.append("1");
        }

        while (!channel[1].equals("KBS2")) {
            upChannel(idx);
            idx--; // 인덱스를 위로 올림
            sb.append("4");
        }
        System.out.println(sb.toString());
    }

    /*
        채널을 위로 올리기
     */
    public static void upChannel(int idx) {
        String temp = channel[idx];
        channel[idx] = channel[idx-1];
        channel[idx-1] = temp;
    }

}
