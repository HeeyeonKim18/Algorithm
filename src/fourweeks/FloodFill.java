package fourweeks;

import java.util.ArrayDeque;
import java.util.Deque;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1;
        int color = 2;
        floodFill(image, sr, sc, color);
        floodFillRecur(image, sr, sc, color);
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rl = image.length;
        int cl = image[0].length;

        int original = image[sr][sc];

        if (original == color)
            return image;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] { sr, sc });

        int[] dr = { 1, -1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };

        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr >= 0 && nr < rl && nc >= 0 && nc < cl && image[nr][nc] == original) {
                    image[nr][nc] = color;
                    q.add(new int[] { nr, nc });
                }
            }
        }
        return image;
    }

    private static int[][] floodFillRecur(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;

        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private static void fill(int[][] image, int sr, int sc, int color, int cur) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length)
            return;
        if (cur != image[sr][sc])
            return;

        image[sr][sc] = color;
        fill(image, sr - 1, sc, color, cur);
        fill(image, sr + 1, sc, color, cur);
        fill(image, sr, sc + 1, color, cur);
        fill(image, sr, sc - 1, color, cur);
    }
}
