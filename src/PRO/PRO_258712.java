package PRO;

import java.util.HashMap;
import java.util.Map;

// 가장 많이 받은 선물
public class PRO_258712 {
    // 각자의 선물을 관리할 int 2차원 배열 : 1개 필요
    // 선물 지수를 관리할 int 1차원 배열 : 1개 필요
    // 이름과 인덱스 매치를 빠르게 할 수 있는 Map 1개 필요
    // 선물의 최대값을 관리할 int 1차원 배열 : 1개 필요

    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(solution(friends, gifts));
    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0; // 가장 선물을 많이 받는 사람의 선물수
        int num = friends.length;

        int[][] fromto = new int[num][num]; // 각자의 선물 숫자 관리
        int[] score = new int[num];     // 선물 지수 관리

        Map<String, Integer> name = new HashMap<>(num); // 인덱스를 빠르게 조회할 수 있게하는 map
        for (int i = 0; i < num; i++) {
            name.put(friends[i], i);
        }

        // 전체 선물 관계 셋업
        for (int i = 0; i < gifts.length; i++) {
            String rel = gifts[i];
            int giver = name.get(rel.split(" ")[0]);   // 이름으로 찾은 인덱스 번호
            int taker = name.get(rel.split(" ")[1]);

            fromto[giver][taker]++;
            score[giver]++;
            score[taker]--;
        }

        // 다음달 선물 계산
        int[] maxGift = new int[num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == j) continue;  // 본인은 pass

                if (fromto[i][j] > fromto[j][i]) maxGift[i]++;  // 내가 준 게 더 크다면 내 인덱스의 숫자를 증가
                else if (fromto[i][j] == fromto[j][i]) {
                    if (score[i] > score[j]) {  // 아니라면 선물 지수를 비교해서 증가시킴
                        maxGift[i]++;
                    }
                }
            }
        }

        // 최대값 계산
        for (int cnt : maxGift) {
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}
