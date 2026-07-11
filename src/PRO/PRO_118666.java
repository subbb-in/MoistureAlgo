package PRO;

import java.util.HashMap;
import java.util.Map;

// 성격 유형 검사
public class PRO_118666 {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5,3,2,7,5};
        System.out.println(solution(survey, choices));
    }

    public static String solution(String[] survey, int[] choices) {

        StringBuilder sb = new StringBuilder();

        // survey 문자 처리
        // hashMap으로 각 글자별로 점수를 기록함
        Map<Character, Integer> score = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            if (choices[i] > 4) {
                char ch = survey[i].charAt(1);
                int sc = choices[i] - 4;
                score.put(ch, score.getOrDefault(ch, 0)+sc);
            } else if (choices[i] < 4) {
                char ch = survey[i].charAt(0);
                int sc = 4 - choices[i];
                score.put(ch, score.getOrDefault(ch, 0)+sc);
            }
        }

        // 단어 취합
        if (score.getOrDefault('R', 0) < score.getOrDefault('T',0)) {
            sb.append('T');
        } else {
            sb.append('R');
        }

        if (score.getOrDefault('C', 0) < score.getOrDefault('F', 0)) {
            sb.append('F');
        } else {
            sb.append('C');
        }

        if (score.getOrDefault('J', 0) < score.getOrDefault('M', 0)) {
            sb.append('M');
        } else {
            sb.append('J');
        }

        if (score.getOrDefault('A', 0) < score.getOrDefault('N', 0)) {
            sb.append('N');
        } else {
            sb.append('A');
        }

        return sb.toString();
    }
}
