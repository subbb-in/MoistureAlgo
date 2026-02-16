package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_8979 {
    static int N, K;
    static ArrayList<Node> list = new ArrayList<>();
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 국가의 수
        K = Integer.parseInt(st.nextToken());   // 등수를 알고 싶은 국가 K

        // 배열 선언
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Node(num, gold, silver, bronze,0));    // 초기 등수는 0으로 설정
        }

        Collections.sort(list); // 금, 은, 동 순서로 내림차순 정렬

        list.get(0).rate = 1;

        for (int i = 1; i < list.size(); i++) {
            Node prev = list.get(i-1); // 직전 국가
            Node now = list.get(i);

            // 현재 국가의 번호가 k번이면 출력을 위해 인덱스 기록
            if(now.num == K) {
                idx = i;
            }

            // 공동 순위 관리
            // 만약 이전 국가와 베달 수가 모두 같아면, 이전 국가와 같은 등수 부여
            if(now.gold == prev.gold && now.silver == prev.silver && now.bronze == prev.bronze ){
                now.rate = prev.rate;
            } else {
                // 메달 개수가 하나라도 다르면 , 현재 내 앞에 있는 국가수 +1 순위
                now.rate = i+1;
            }
        }
        System.out.println(list.get(idx).rate);
    }

    // 정렬을 위한 Node 클래스
    static class Node implements Comparable<Node> {
        int num, gold, silver, bronze, rate;

        Node(int num, int gold, int silver, int bronze, int rate) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rate = rate;
        }

        @Override
        public int compareTo(Node o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze;
                } else {
                    return o.silver - this.silver;
                }
            } else {
                return o.gold - this.gold;
            }
        }
    }
}
