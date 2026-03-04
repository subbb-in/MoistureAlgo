package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3758 {
    static int K;
    static Node[] teamArray;
    static ArrayList<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 팀의 개수
            K = Integer.parseInt(st.nextToken());   // 문제 개수
            int id = Integer.parseInt(st.nextToken());  // 팀 ID
            int log = Integer.parseInt(st.nextToken()); // 로그 엔트리

            teamArray = new Node[N + 1];
            for (int j = 0; j < log; j++) {
                st = new StringTokenizer(br.readLine());
                int team = Integer.parseInt(st.nextToken());    // 팀 번호
                int num = Integer.parseInt(st.nextToken());     // 문제 번호
                int point = Integer.parseInt(st.nextToken());   // 획득한 점수
                if (teamArray[team] == null) {
                    // 팀이 등록되어 있지 않다면
                    teamArray[team] = new Node(team, 1, j, K);
                } else {
                    teamArray[team].submit++;
                    teamArray[team].time = j;
                }

                // 점수가 클 때만 갱신
                if (point > teamArray[team].problem[num]) {
                    teamArray[team].problem[num] = point;
                }
            }

            List<Node> list = new ArrayList<>();
            // 전체 팀 total 계산
            for (int j = 1; j <= N; j++) {
                if(teamArray[j] != null) {
                    teamArray[j].cal(); // 총점 계산
                    list.add(teamArray[j]);
                }
            }

            // 정렬기준순으로 정렬
            Collections.sort(list);

            // 내 팀 ID 찾기
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).teamId == id) {
                    System.out.println(j+1);
                    break;
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int teamId;
        int submit;
        int time;
        int total;
        int[] problem;

        public Node(int teamId, int submit,int time, int K) {
            this.teamId = teamId;
            this.submit = submit;
            this.time = time;
            this.problem = new int[K+1];
        }

        @Override
        public int compareTo(Node o) {

            if(this.total != o.total) return o.total - this.total;

            if(this.submit != o.submit) return this.submit - o.submit;

            return this.time - o.time;
        }

        public void cal() {
            this.total = 0; // 초기화 후 합산
            for (int score : problem) {
                this.total += score;
            }
        }
    }
}
