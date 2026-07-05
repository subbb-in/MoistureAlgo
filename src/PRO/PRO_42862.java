package PRO;

import java.util.Arrays;

// 체육복
public class PRO_42862 {

    public static void main(String[] args) {
        int n = 5;  // 전체 학생수
        int[] lost = {2,4};     // 도난 당한 학생들 번호
        int[] reserve = {1,3,5};    // 여벌의 체육복 있는 사람
        System.out.println(solution(n, lost, reserve)); // 체육수업 들을 수 있는 최대값
    }

    // 바로 앞 번호나 뒷 번호 학생에게만 가능
    // 여벌 체육복 학생이 도난 가능성 있음 해당 부분 체크 먼저 해야함

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Arrays.sort(reserve);   // 오름차순 정렬
        Arrays.sort(lost);

        // 도난당한 학생 배열 : true 이면 도난
        boolean[] students = new boolean[n+1];

        // 도난 체크
        for (int i = 0; i < lost.length; i++) {
            students[lost[i]] = true;
        }

        // 여벌 체육복 + 도난 학생 체크
        for (int i = 0; i < reserve.length; i++) {
            if (students[reserve[i]] == true) {
                students[reserve[i]] = false;   // 다시 도난 상태를 변경
                reserve[i] = 0;     // 해당 인덱스의 값을 0으로 변경
            }
        }

        // 없는 사람의 번호를 확인하고 해당 번호의 앞 번호 확인
        for (int i = 1; i < students.length; i++) {
            if (students[i] == true) {  // 해당 번호가 도난이면
                for (int j = 0; j < reserve.length; j++) {

                    if (reserve[j] == 0) continue;  // 이미 빌려준 사람이면 continue

                    if (reserve[j] == i-1) {
                        students[i] = false;    // 도난 상태를 변경
                        reserve[j] = 0; // 해당 인덱스의 값을 0으로 변경
                        break;
                    } else if (reserve[j] == i+1) {
                        students[i] = false;
                        reserve[j] = 0;
                        break;
                    }
                }
            }
        }

        // 전체 순회하며 false 값이 몇 개인지 체크
        for (int i = 1; i < students.length; i++) {
            if (students[i] == false) answer++;
        }

        return answer;
    }
}
