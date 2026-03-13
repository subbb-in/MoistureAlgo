package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2304 {

    static ArrayList<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());    // 기둥의 개수

        // 최종 너비
        int ans = 0;
        // 기둥의 개수만큼 반복
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            list.add(new Node(width, height));
        }

        Collections.sort(list); // width를 기준으로 정렬
        int tempMax = 0;
        int idx = 0;
        // max 찾기
        for (int i = 0; i < N; i++) {
            Node node = list.get(i);
            if (tempMax < node.height) {
                tempMax = node.height;
                idx = i;
            }
        }

        // left
        Node leftTop = list.get(0);
        for (int i = 1; i <= idx; i++) {
            Node node = list.get(i);
            if(leftTop.height <= node.height) {  // 만약 스택에 넣은 값과 다음 노드의 값을 비교했을 때 , 다음 노드의 높이가 더 크다면
                ans += (node.width-leftTop.width)* leftTop.height; // 이전 max 노드의 가로길이와 빼고 세로 높이를 곱해서 너비를 더해줌
                leftTop = node;
            }
        }

        // right
        Node rightTop = list.get(N-1);
        for (int i = N-2; i >= idx; i--) {
            Node node = list.get(i);
            if (rightTop.height <= node.height) {
                ans += (rightTop.width-node.width)*rightTop.height;
                rightTop = node;
            }
        }

        ans += tempMax;

        System.out.println(ans);
    }

    static class Node implements Comparable <Node> {
        int width;
        int height;

        public Node(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public int compareTo(Node o) {
            return this.width - o.width;
        }
    }
}
