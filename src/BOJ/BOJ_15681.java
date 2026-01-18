package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리와 쿼리
public class BOJ_15681 {

    static StringBuilder sb = new StringBuilder();

    static int N, R, Q;
    static List<Integer>[] list; // 리스트로 구성된 배열
    static int[] arr, cnt; //

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 트리 정점의 수
        R = Integer.parseInt(st.nextToken()); // 루트의 번호 R
        Q = Integer.parseInt(st.nextToken()); // 쿼리의 수 Q

        list = new ArrayList[N+1]; // 배열리스트 초기화
        for (int i = 1; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        cnt = new int[N+1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
            list[B].add(A);
        }

        arr = new int[Q]; // 쿼리문의 루트가 들어갈

        for (int i = 0; i < Q; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solution();

    } // main

    private static void solution() {

        dfs(R, -1);
        for(int x : arr) sb.append(cnt[x]).append("\n");
        System.out.println(sb.toString());

    }

    private static void dfs(int r, int prev) {

        // arr의 첫번째 값을 루트로 하여 갯수 파악
        cnt[r] = 1;

        for (int a : list[r]) {
            if(a == prev) continue;
            dfs(a, r);
            cnt[r] += cnt[a];
        }
    }
}
