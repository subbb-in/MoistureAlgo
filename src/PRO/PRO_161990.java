package PRO;

import java.util.Arrays;

// 바탕화면 정리
public class PRO_161990 {

    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        System.out.println(Arrays.toString(solution(wallpaper)));
    }

    public static int[] solution(String[] wallpaper) {
        int h = wallpaper.length;
        int w = wallpaper[0].length();
        int fx = Integer.MAX_VALUE;
        int fy = Integer.MAX_VALUE;
        int lx = Integer.MIN_VALUE;
        int ly = Integer.MIN_VALUE;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    fy = Math.min(i, fy);
                    fx = Math.min(j, fx);
                    ly = Math.max(i+1, ly);
                    lx = Math.max(j+1, lx);
                }
            }
        }
        int[] answer = {fy, fx, ly, lx};

        return answer;
    }
}
