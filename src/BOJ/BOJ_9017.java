package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 크로스 컨트리
public class BOJ_9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N];
            int maxTeamId = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {   // input
                rank[i] = Integer.parseInt(st.nextToken());
                maxTeamId = Math.max(maxTeamId, rank[i]);
            }

            // 팀별 인원수
            int[] teamSize = new int[maxTeamId+1];
            for (int i = 0; i < N; i++) {
                teamSize[rank[i]]++;
            }

            // 점수 계산을 위한 배열
            int[] teamScore = new int[maxTeamId+1]; // 상위 4명 합산 점수
            int[] teamCnt = new int[maxTeamId+1];   // 현재 합산된 팀원수
            int[] fifth = new int[maxTeamId+1]; // 5번째 선수의 점수

            int curScore = 1;
            for (int i = 0; i < N; i++) {
                int teamId = rank[i];

                // 6명 이상인 팀만 점수를 부여받음
                if(teamSize[teamId] >= 6) {
                    teamCnt[teamId]++;

                    // 상위 4명까지만 합산 점수에 포함
                    if (teamCnt[teamId] <= 4) {
                        teamScore[teamId] += curScore;
                    }

                    // 5번째 선수의 점수(등수) 따로 저장
                    else if (teamCnt[teamId] == 5) {
                        fifth[teamId] = curScore;
                    }

                    curScore++;
                }
            }

            // 우승 팀
            int winner = 0;
            int minTotal = Integer.MAX_VALUE;
            int minFifth = Integer.MAX_VALUE;

            for (int i = 1; i <= maxTeamId; i++) {
                // 자격이 있는 팀 중에서만 비교
                if(teamSize[i] >= 6) {
                    if (teamScore[i] < minTotal) {
                        minTotal = teamScore[i];
                        minFifth = fifth[i];
                        winner = i;
                    }
                    // 총점이 같으면 5번째 선수의 점수로 결정
                    else if (teamScore[i] == minTotal) {
                        if (fifth[i] < minFifth) {
                            minFifth = fifth[i];
                            winner = i;
                        }
                    }
                }
            }
            System.out.println(winner);
        }
    }
}
