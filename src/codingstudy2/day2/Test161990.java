
/**
 * 프로그래머스 바탕화면 정리
 */
public class Test161990 {
    public static void main(String[] args) {
        // String[] wallpaper = { "..........", ".....#....", "......##..",
        // "...##.....", "....#....." };
        String[] wallpaper = { ".#...", "..#..", "...#." };
        int[] answer = solution(wallpaper);

        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static int[] solution(String[] wallpaper) {
        int[] answer = { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };

        for (int i = 0; i < wallpaper.length; i++) {
            char[] paper = wallpaper[i].toCharArray();
            for (int j = 0; j < paper.length; j++) {
                char c = paper[j];
                if (c == '#') {
                    answer[0] = Integer.min(answer[0], i);
                    answer[1] = Integer.min(answer[1], j);
                    answer[2] = Integer.max(answer[2], i + 1);
                    answer[3] = Integer.max(answer[3], j + 1);
                }
            }
        }
        return answer;
    }
}
