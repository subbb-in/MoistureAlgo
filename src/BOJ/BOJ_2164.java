package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2164 {
    public static void main(String[] args) throws IOException {
        // input 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int card = Integer.parseInt(st.nextToken());

        // LinkedList 선언
        LinkedList<Integer> list = new LinkedList<>();

        // card의 숫자로 초기화
        for (int i = 1; i <= card; i++) {
            list.add(i);
        }

        while(true){
            // list의 size가 1인지 검사하고, true라면 즉시 값을 출력하고 종료
            if(list.size() == 1) {
                System.out.println(list.getFirst());
                return;
            }
            // 맨 앞에 있는 숫자 1개를 빼기
            list.pollFirst();

            // 그 다음 숫자를 뒤로 옮김
            int second = list.getFirst();
            list.pollFirst();
            list.addLast(second);
        }
    }
}
