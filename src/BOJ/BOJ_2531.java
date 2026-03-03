package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2531 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 접시의 수
        int N = Integer.parseInt(st.nextToken());
        // 초밥의 가짓수
        int D = Integer.parseInt(st.nextToken());
        // 연속해서 먹는 접시의 수
        int K = Integer.parseInt(st.nextToken());
        // 쿠폰 번호
        int C = Integer.parseInt(st.nextToken());

        // 접시
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] sushiCount = new int[D + 1]; // 각 초밥 종류별 개수를 저장하는 배열
        int typeCount = 0; // 현재 먹고 있는 초밥 종류의 수
        int maxTypes = 0; // 최대로 먹을 수 있는 초밥 종류의 수

        // 초기 K개의 초밥 확인
        for (int i = 0; i < K; i++) {
            if (sushiCount[arr[i]] == 0) {
                typeCount++; // 새로운 종류의 초밥을 먹으면 증가
            }
            sushiCount[arr[i]]++;
        }

        // 초기 윈도우의 최대 종류 수 계산
        maxTypes = typeCount;
        if (sushiCount[C] == 0) {
            maxTypes++;
        }

        // 슬라이딩 윈도우 시작
        for (int i = 1; i < N; i++) {
            int removeSushi = arr[i - 1]; // 이전 윈도우의 가장 앞 초밥 제거
            sushiCount[removeSushi]--;
            if (sushiCount[removeSushi] == 0) {
                typeCount--;
            }

            int addSushi = arr[(i + K - 1) % N]; // 새로운 윈도우의 가장 뒤 초밥 추가
            if (sushiCount[addSushi] == 0) {
                typeCount++;
            }
            sushiCount[addSushi]++;

            // 최대 종류 수 갱신 (쿠폰 고려)
            int currentTypes = typeCount;
            if (sushiCount[C] == 0) {
                currentTypes++;
            }
            maxTypes = Math.max(maxTypes, currentTypes);
        }

        System.out.println(maxTypes);


    }
}
