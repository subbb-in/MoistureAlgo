package PRO;

public class PRO_155652 {
    public static void main(String[] args) {
        String str = "aukks";
        String skip = "wbqd";
        int index = 5;
        System.out.println(solution(str, skip, index));
    }

    public static String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        boolean[] check = new boolean[26];  // skip에 있는 철자는 알파벳 boolean 배열로 관리
        for (char c : skip.toCharArray()) {
            check[c-'a'] = true;
        }

        // 문자열 s를 순회
        for (int i = 0; i < s.length(); i++) {
            int no = s.charAt(i) - 'a';  // 현재 반복문의 대상이 될 char 추출
            for (int j = 0; j < index; j++) {
                no++;
                if (no > 25) {
                    no -= 26;
                }
                if (check[no] == true) {
                    j--;
                }
            }
            char ch = (char) (no + 'a');
            sb.append(ch);
        }
        return sb.toString();
    }
}
