package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_3273 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 크기 N
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        // HashSet 으로...
        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]); // set에 값을 넣어줌
        }

        int cnt = 0;

        // 타겟 넘버
        int target = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            // 타겟 넘버에서 인덱스에 해당하는 값을 뺐을 때 나오는 값 == 필요한 값 -> 이게 있는지 확인
            // 있으면 cnt 를 증가시킴
            if (set.contains(target - arr[i])) cnt++;
        }
        // 2번 세주니까 2로 나누기
        System.out.println(cnt/2);
    }
}
