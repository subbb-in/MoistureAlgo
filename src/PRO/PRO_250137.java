package PRO;

// 붕대감기
public class PRO_250137 {

    public static void main(String[] args){
        int[] arr = {5, 1, 5};
        int health = 30;    // 최대 체력
        int[][] attacks = {{2,10},{9,15},{10,5},{11,5}};
        System.out.println(solution(arr, health, attacks));
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health; // 현재 체력
        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량
        int con = 0;    // 지속 시간
        int idx = 0;    // 공격 인덱스

        // 마지막 공격의 0번 인덱스가 마지막 체크 시간
        int N = attacks[attacks.length-1][0];

        for (int time = 1; time <= N; time++) {

            // 이번 time에 공격이 있는지 확인
            if (idx < attacks.length && attacks[idx][0] == time) {
                answer -= attacks[idx][1]; // 피해량 만큼 체력 감소
                idx++;
                con = 0;    // 지속시간을 0으로 초기화
                if(answer <= 0) {  // 공격 당한 후 체력 검사 0 이하면 함수 종료
                    return -1;
                }

            } else {    // 해당 턴에 공격이 없다면 체력 회복
                con++; // 지속시간을 증가
                answer += x;
                if (con == t) {
                    answer += y;  // 시전 시간까지 연속으로 회복했다면 추가 회복
                    con = 0;    // 다음 사이클을 위해 초기화
                }
                if (answer > health) answer = health;
            }
        }
        return answer;
    }
}
