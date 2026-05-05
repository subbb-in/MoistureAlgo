package PRO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 시소 짝꿍
public class PRO_152996 {
    public static void main(String[] args) {
        int[] arr = {100, 180, 360, 100, 270};

        System.out.println(solution(arr));
    }

    public static long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);   // 무게 오름차순 정렬
        Map<Double, Integer> map = new HashMap<>();

        for(int i:weights) {
            double a = i*1.0;
            double b = (i*2.0)/3.0;
            double c = (i*1.0)/2.0;
            double d = (i*3.0)/4.0;
            if (map.containsKey(a)) answer += map.get(a);
            if (map.containsKey(b)) answer += map.get(b);
            if (map.containsKey(c)) answer += map.get(c);
            if (map.containsKey(d)) answer += map.get(d);
            map.put((i*1.0), map.getOrDefault((i*1.0), 0)+1);
        }

        return answer;
    }
}
