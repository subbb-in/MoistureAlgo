package PRO;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 네트워크
public class PRO_43162 {

    static boolean visited[];
    static List<List> list;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        // 방문 확인 배열
        visited = new boolean[n];

        // 리스트형 배열 선언
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }

        // 리스트에 담기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 & i != j) {
                    list.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {

            // 방문처리
            if (!visited[i]) {
                visited[i] = true;
                bfs(i);
                answer++;
            } else continue;
        }

        return answer;
    }

    // BFS
    private static void bfs(int idx) {

        // 큐 선언
        Deque<Integer> que = new ArrayDeque<>();
        visited[idx] = true;

        // 큐에 초기 노드 넣기
        for (int i = 0; i < list.get(idx).size(); i++) {
            int num = (int) list.get(idx).get(i); // 1
            if (!visited[num]) {
                que.offer(num);
            }
        }

        while (!que.isEmpty()) {
            // 큐에서 하나를 꺼냄
            int cur = que.poll();

            // 방문처리
            visited[cur] = true;

            // 다음 큐 조사
            for (int i = 0; i < list.get(cur).size(); i++) {
                int nextCur = (int) list.get(cur).get(i);
                if(!visited[nextCur]) {
                    que.offer(nextCur);
                    visited[nextCur] = true;
                }
            }
        }
    }
}
