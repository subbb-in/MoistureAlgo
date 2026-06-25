package PRO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 개인정보 수집 유효기간
public class PRO_150370 {

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {

        ArrayList<Integer> list = new ArrayList<>();

        // 오늘날짜 파싱
        int tDate = convert(today);

        // 약관별 유효기간 저장
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] arr = terms[i].split(" ");
            String str = arr[0];
            int month = Integer.parseInt(arr[1]);
            map.put(str, month);
        }

        // 수집한 정보 전체 순회
        for (int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            String date = temp[0];  // 동의 날짜
            String name = temp[1];  // 약관 종류

            // 동의 날짜 파싱
            int cur = convert(date);
            int expiry = cur + (map.get(name) * 28);

            // 폐기 여부 확인
            if (expiry <= tDate) {
                list.add(i+1);
            }

        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }

    // 날짜 변경 헬퍼 메서드
    private static int convert(String date) {
        String[] arr = date.split("\\.");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);

        return (year*12*28) + (month*28) + day;
    }
}
