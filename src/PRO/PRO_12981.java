package PRO;

import java.util.HashSet;
import java.util.Set;

// 영어 끝말 잇기
public class PRO_12981 {

    public int[] solution(int n, String[] words) {

        // 최종 반환 배열 : 사람번호, 턴 수
        int[] arr = new int[2];

        // 중복 검사를 위한 Set 선언 및 초기화
        Set<String> res = new HashSet<>();

        // 기본 인덱스를 불가능 값인 -1로 초기화
        int idx = -1;

        // 첫 번째 단어의 마지막 글자를 담음
        char ch = words[0].charAt(words[0].length() - 1);

        // set에 첫 번째 단어를 넣음
        res.add(words[0]);

        // 단어 배열만큼 반복
        for (int i = 1; i < words.length; i++) {

            // 다음 배열 요소(String)를 담음
            String next = words[i];

            // 1. 끝말잇기가 아니라면 해당 인덱스 반환
            if (ch != next.charAt(0)) {
                idx = i + 1;
                break;
            }

            // 2. 중복된 요소가 있다면 해당 인덱스 반환
            if (res.contains(next)) {
                idx = i + 1;
                break;
            }

            // 3. 두 상황 모두 해당하지 않으면 Set에 담기
            res.add(next);

            // 다음 검사를 위한 ch 갱신
            ch = next.charAt(next.length() - 1);

        }

        // 배열의 첫 번째 : 사람번호
        arr[0] = idx % n;
        if (arr[0] == 0) {
            arr[0] = n;
        } else if (arr[0] == -1) {
            arr[0] = 0;
        }

        // 배열의 두 번째 : 턴 수
        arr[1] = ((idx - 1) / n) + 1;
        if (arr[0] == 0) arr[1] = 0;

        return arr;
    }
}
