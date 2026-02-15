package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17266 {
    static int len;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine()); // 전체 굴다리 길이
        int light = Integer.parseInt(br.readLine()); // 조명 개수
        arr = new int[light];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < light; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1; // 최소 높이
        int end = len; // 터널 전체 길이
        int cnt = 0; // 최소 높이

        while(start <= end) { // 시작 지점이 끝 지점 보다 작거나 같을 때까지
            int mid = (start+end)/2; // 중간 지점
            if(check(mid)) {
                end = mid -1;
                cnt = mid;
            } else {
                start = mid+1;
            }
        }
        System.out.println(cnt);
    }

    /**
     * 특정 높이일 때 굴다리 전체를 비출 수 있는지 검사하는 함수
     */
    public static boolean check(int height) {
        int prev = 0; // 가로등이 비춘 영역의 마지막 지점

        for (int i = 0; i < arr.length; i++) {
            // 현재 가로등이 비추는 시작점(arr[i] - height)이
            // 이전에 비췄던 끝점보다 뒤에 있다면 빈 공간이 생긴 것
            if(arr[i] - height <= prev) {
                prev = arr[i] + height;
            } else {
                return false;
            }
        }

        // 마지막 가로등이 비추는 곳이 굴다리 길이보다 같거나 큼
        return len - prev <= 0;
    }
}
