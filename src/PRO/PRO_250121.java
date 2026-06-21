package PRO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 데이터 분석
public class PRO_250121 {

    // data는 {code, date, max, remain} 으로 구성
    // ext를 인덱스로 관리할 map 1개 필요. 너무 졸려요

    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";        // 기준
        int valExt = 20300501;      // 기준값
        String sort = "remain";     // 정렬기준
        System.out.println(Arrays.deepToString(solution(data, ext, valExt, sort)));
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 최종 반환값을 위한 ArrayList 선언
        ArrayList<int[]> list = new ArrayList<>(data.length);

        // 인덱스 전환용 map 세팅
        Map<String, Integer> name = new HashMap<>(4);
        name.put("code", 0);
        name.put("date", 1);
        name.put("maximum", 2);
        name.put("remain", 3);

        // 전체 순회하며 조건에 맞는 배열을 list에 add
        int idx = name.get(ext);
        for (int i = 0; i < data.length; i++) {
            if (data[i][idx] < val_ext) {
                list.add(data[i]);
            }
        }

        // 담은 배열을 sort_by에 따라 정렬
        int sort = name.get(sort_by);
        list.sort((a, b) -> Integer.compare(a[sort], b[sort]));
        // list.sort(Comparator.comparingInt(a -> a[sort])); 이렇게 표기할 수 있음

        int[][] answer = list.stream().toArray(int[][]::new);
        return answer;
    }
}
