package PRO;

import java.util.Arrays;

public class PRO_42577 {
    public static void main(String[] args) {
        String[] arr = {"119", "97674223", "1195524421"};
        System.out.println(solution(arr));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);    // 사전순 정렬

        // 배열 요소 중 바로 뒤에 것만 비교해서 boolean 반환
        for(int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
