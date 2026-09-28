package PRO;

// 타겟 넘버
public class PRO_43165 {

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0,0);
        return answer;
    }

    private static int dfs(int[] numbers, int target, int idx, int sum){
        // 모든 숫자를 다 사용했을 때
        if (idx == numbers.length) {
            return sum == target ? 1 : 0;
        }

        // 현재 숫자를 더하는 경우 / 빼는 경우
        return dfs(numbers, target, idx+1, sum+numbers[idx])
                + dfs(numbers, target, idx+1, sum - numbers[idx]);
    }
}
