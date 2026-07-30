package PRO;

import java.util.ArrayList;
import java.util.List;

// 모음사전
public class PRO_84512 {

    static List<String> list;
    static String[] words = {"A", "E", "I", "O", "U"};

    public static void main(String[] args) {
        String word = "AAAAE";
        System.out.println(solution(word));
    }

    public static int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("", 0);

        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    static void dfs(String str, int depth) {
        list.add(str);
        // 종료 조건
        if (depth == 5) return;

        // 재귀 부분
        for (int i = 0; i < 5; i++) {
            dfs(str+words[i], depth+1);
        }
    }
}
