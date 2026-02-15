package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157 {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toLowerCase();

        // 알파벳 배열과 최대값, 인덱스 초기화
        int[] spell = new int[26];
        int max = 0;
        int idx = 0;

        // 각 글자의 갯수를 카운트함
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 97;
            spell[ch]++;
        }

        // max 갱신
        for (int i = 0; i < spell.length; i++) {
            if (spell[i] >= max) {
                max = spell[i];
                idx = i;
            }
        }

        // max가 같다면 ? 반환
        for (int i = 0; i < spell.length; i++) {
            if (max == spell[i] && i != idx) {
                System.out.println("?");
                return;
            }
        }

        // 글자로 변환
        char ch = (char)(idx+65);
        System.out.println(ch);
    }

}
