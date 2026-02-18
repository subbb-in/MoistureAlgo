package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_25757 {
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 신청한 횟수
        char game = st.nextToken().charAt(0);   // 게임 종류

        for (int i = 0; i < N; i++) {   // 입력을 받아서 set에 넣음
            set.add(br.readLine());
        }

        //  게임이 무엇이냐에 따라 나눔
        switch (game) {
            case 'Y' :
                System.out.println(set.size() / 1);
                break;
            case 'F' :
                System.out.println(set.size() / 2);
                break;
            case 'O' :
                System.out.println(set.size() / 3);
                break;
        }
    }
}
