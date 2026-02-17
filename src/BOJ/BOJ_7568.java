package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_7568 {

    static int N;
    static ArrayList<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 사람의 수
        N = Integer.parseInt(br.readLine());

        // 사람 수만큼 반복하여 node에
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());  // 무게
            int height = Integer.parseInt(st.nextToken());  // 키
            list.add(new Node(weight, height)); // 순위는 0으로 지정해서 넣음
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;
            Node now = list.get(i);

            for (int j = 0; j < N; j++) {
                if(i == j) continue;
                Node target = list.get(j);

                // 무게와 키가 둘 다 본인보다 커야함
                if(target.weight > now.weight && target.height > now.height) {
                    rank++;
                }
            }
            // sb에 담기
            sb.append(rank).append(" ");
        }

        System.out.println(sb.toString());
    }

    static class Node {
        int weight, height;

        public Node(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
