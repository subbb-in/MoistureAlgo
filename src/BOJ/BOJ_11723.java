package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723 {

    static int[] arr = new int[21];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

            switch (command) {
                case "add":
                    add(num);
                    break;
                case "remove":
                    remove(num);
                    break;
                case "check":
                    check(num);
                    break;
                case "toggle":
                    toggle(num);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }
        System.out.println(sb);
    }

    /*
        add : x 를 추가함
     */
    public static void add(int x) {
        if (arr[x] == 0) {
            arr[x]++;
        }
    }

    /*
        remove : x를 제거
     */
    public static void remove(int x) {
        if (arr[x] == 1) {
            arr[x]--;
        }
    }

    /*
        check : x가 있으면 1을, 없으면 0을 출력
     */
    public static void check(int x) {
        if (arr[x] == 1) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    /*
        toggle : x가 있으면 제거하고 없으면 추가함
     */
    public static void toggle(int x) {
        if (arr[x] == 1) {
            arr[x]--;
        } else {
            arr[x]++;
        }
    }

    /*
        all : 1부터 20까지 채움
     */
    public static void all() {
        int i = 1;
        while (i <= 20) {
            if (arr[i] == 0) {
                arr[i]++;
            }
            i++;
        }
    }

    /*
        empty : 공집합으로 변환
     */
    public static void empty() {
        int i = 1;
        while (i <= 20) {
            if (arr[i] == 1) {
                arr[i]--;
            }
            i++;
        }
    }
}
