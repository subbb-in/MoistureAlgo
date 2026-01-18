package PRO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 신고 결과 받기
public class PRO_92334 {
    public static int[] solutionList(String[] id_list, String[] report, int k) {

        // 맵 선언
        Map<String, Set<String>> rep = new HashMap<>();  // 신고한 사람과 피신고자를 넣을 map
        Map<String, Integer> map = new HashMap<>();  // 피신고자와 횟수 기록

        // 초기화
        for (String id : id_list) {
            rep.put(id, new HashSet<>());  // id와 HashSet를 초기화함
            map.put(id, 0); // 신고 당한 사람을 키로 하여금 신고횟수를 증가시킴
        }

        for (String str : report) {
            String[] split = str.split(" "); // 공백 기준으로 나눠서 새로운 배열에 저장
            if(rep.get(split[0]).add(split[1])) { // Set.add(E e)의 반환값이 boolean임
                map.put(split[1], map.get(split[1]) +1); // 신고한 사람 : 피신고자 쌍이 들어있는 report 배열을 돌면서
                // 들어맞는 것이 있다면 신고 횟수를 증가 시킴
            }
        }

        // k번 이상 신고된 id을 새로운 banned 셋에 담아서
        Set<String> banned = new HashSet<>();
        for (String id : id_list) {
            if(map.get(id) >= k ) banned.add(id);
        }

        // 배열로 반환
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            int num = 0;
            String user = id_list[i];  // id 하나를 뽑아서
            for (String reported : rep.get(user)) {  // rep 맵의 값을 구하고 for문을 돌리는데
                if(banned.contains(reported)) {  // banned한 목록에 있는지 확인해서 몇 개인지 확인
                    num++;
                }
            }
            answer[i] = num;

        }

        return answer;
    }
}
