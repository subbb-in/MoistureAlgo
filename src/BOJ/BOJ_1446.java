package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 지름길
public class BOJ_1446 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N : 지름길 개수, D : 고속도로 길이
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        // 그래프 생성 및 초기화
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>()); // 노드의 개수만큼 생성
        }

        // 지름길 정보를 graph에 추가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());   // 시작 노드
            int v = Integer.parseInt(st.nextToken());   // 도착 노드
            int w = Integer.parseInt(st.nextToken());   // 가중치
            if (v <= D) {   // 지름길의 끝이 도착지를 지나치면 추가하지 않음
                graph.get(u).add(new int[] {v, w});
            }
        }

        int[] dist = new int[D+1];  // 가중치를 기록할 배열
        Arrays.fill(dist, Integer.MAX_VALUE);   // 초기값은 모두 가장 큰 값
        dist[0] = 0;    // 시작 위치는 0

        // int[] a 중에서 두 번째 요소인 a[1]을 기준으로 큐를 정렬, 가중치를 기준으로 오름차순 정렬
        // comparingInt : 기본적으로 오름차순 -> 비용(a[1])이 가장 저렴한 것부터 추출
        // 일반적인 queue는 FIFO 방식이지만, 우선순위 큐는 정해진 정렬 기준에 따라 가장 우선순위가 높은 데이터를 먼저 내보냄
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        que.add(new int[] {0,0});   // 현재 위치, 현재 비용

        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int curPos = cur[0];
            int curCost = cur[1];

            // 만약 현재 비용이 기록된 비용보다 크다면, 이미 더 적은 비용으로 도달한 경로가 존재하므로 무시
            if (curCost > dist[curPos]) continue;

            // 다음 지점으로 이동(일반 도로, 현재 위치에서 한 칸 앞으로 이동)
            // 현재위치에서 한 칸 앞으로 이동한 위치가 D(도로의 길이, 간선의 범위)를 넘지않는경우
            // 현재위치에서 한칸 앞으로 이동한 위치까지의 비용이 기존에 기록된 비용보다 작은 경우
            if (curPos+1 <= D && curCost+1 < dist[curPos+1]) {
                dist[curPos+1] = curCost+1;     // 다음 위치까지의 비용 갱신
                que.add(new int[] {curPos+1, curCost+1});   // 우선순위 큐에 추가
            }

            // 지름길로 이동 (현재 위치에서 연결된 모든 지름길을 탐색)
            for (int[] edge : graph.get(curPos)) {
                int np = edge[0];   // 지름길의 도착 위치
                int nc = curCost + edge[1];     // 지름길을 이용한 다음 위치까지의 비용
                // 지름길을 이용한 비용이 더 적다면 비용 갱신
                if (nc < dist[np]) {
                    dist[np] = nc;  // 다음 위치까지의 비용 갱신
                    que.add(new int[] {np, nc});    // 우선순위 큐에 추가
                }
            }
        }
        System.out.println(dist[D]);
    }
}
