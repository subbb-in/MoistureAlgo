package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 택배 배송
public class BOJ_5972 {
    static int N, M;
    static int ans = 0;
    static ArrayList<ArrayList<Node>> gragh = new ArrayList<>();
    static boolean[] visited;
    static int[] d = new int[50001];

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N : 헛간의 수, M : 소의 길
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        // ArrayList 초기화
        for (int i = 0; i <= N; i++) {
            gragh.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 양방향 간선
            gragh.get(start).add(new Node(end, cost));
            gragh.get(end).add(new Node(start, cost));
        }
        // 1부터 N 까지의 최소거리 구하기
        dijkstra(1);
        System.out.println(d[N]);
    }

    public static void dijkstra(int start) {
        Arrays.fill(d, Integer.MAX_VALUE);   // d 배열의 모든 요소를 Max로 채움

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));   // 시작노드에서 시작노드로 가기 위한 최단 경로는 0
        d[start] = 0;   // 시작 노드에서 시작 노드까지의 가중치는 제자리이므로 0

        while(!pq.isEmpty()) {
            Node temp = pq.poll();
            int nodeNum = temp.goal;    // 현재 노드번호
            int dist = temp.dist;   // 현재 노드의 가중치
            
            if (d[nodeNum] < dist) continue;    // 현재 노드가 이미 최단
            for (int i = 0; i < gragh.get(nodeNum).size(); i++) {   // 현재 노드와 연결된 다른 인접한 노드들을 확인
                int cost = d[nodeNum] + gragh.get(nodeNum).get(i).dist; // cost = 현재 노드의 가중치 + 현재 노드와 다음 노드까지의 간선의 가중치
                if ( cost < d[gragh.get(nodeNum).get(i).goal]) {    // 새롭게 측정한 비용이 다음 노드가 원래 가지고 있던 가중치보다 적을 경우
                    d[gragh.get(nodeNum).get(i).goal] = cost;   // 더 적은 값으로 갱신해줌
                    pq.offer(new Node(gragh.get(nodeNum).get(i).goal, cost));   // 계속 탐색 해봐야 모든 노드들의 최솟값을 알 수 있기 때문에 현재의 가중치를 가지고 계속 탐색
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int goal;   // 목적지
        int dist;   // 가중치

        public Node(int goal, int dist) {
            this.goal = goal;
            this.dist = dist;
        }

        // dist가 작은 순으로 정렬
        @Override
        public int compareTo(Node node) {
            if (this.dist > node.dist) {
                return 1;
            } else if (this.dist == node.dist) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
