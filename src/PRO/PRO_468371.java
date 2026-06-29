package PRO;

// 노란색 신호등
public class PRO_468371 {

    static class Light {
        int green;
        int yellow;
        int total;

        public Light(int green, int yellow, int red) {
            this.green = green;
            this.yellow = green+yellow;
            this.total = green+yellow+red;
        }

        public boolean isYellow(int time) {
            int ttt = time % total == 0 ? total : time%total;
            if (green < ttt && ttt <= yellow) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{2,1,2}, {5,1,1}};
        System.out.println(solution(arr));
    }

    // 초록 노랑 빨강
    // 시간은 1초부터
    // 처음은 초록 시작
    // 모든 n개의 신호등이 노랑불이 되면 정전

    public static int solution(int[][] signals) {

        Light[] lights = new Light[signals.length];

        // 최대 검사 시간 배열
        int[] totalTimes = new int[signals.length];

        for (int i = 0; i < signals.length; i++){
            lights[i] = new Light(signals[i][0], signals[i][1], signals[i][2]);
            totalTimes[i] = lights[i].total;
        }

        int maxTime = getLcm(totalTimes);
        for (int i = 1; i < maxTime; i++) {
            boolean isEqual = true;
            // 신호등 모드 노란불인지 확인
            for (int j = 0; j < lights.length; j++) {
                if (!lights[j].isYellow(i)){
                    isEqual = false;
                    break;
                }
            }
            // 노란불인 경우 해당 시간 반환
            if (isEqual) {
                return i;
            }
        }

        return -1; // 불가능한 경우
    }

    private static int getLcm(int[] nums){
        // 1인 경우는 자기 자신이 최소 공배수
        if(nums.length == 1) {
            return nums[0];
        }

        // 첫 2개의 최대 공약수를 구하여 최소 공배수 구하기
        int gcd = getGcd(nums[0], nums[1]);
        int lcm = (nums[0]*nums[1]) / gcd;

        // 2개 이상인 경우 계속 최소 공배수 구하기
        for (int i = 2; i < nums.length; i++) {
            gcd = getGcd(nums[i], lcm);
            lcm = (lcm * nums[i]) / gcd;
        }
        return lcm;
    }

    // 최대 공약수 구하기
    private static int getGcd(int num1, int num2){
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGcd(num2, num1%num2);
    }
}
