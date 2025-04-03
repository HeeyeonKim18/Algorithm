package codingstudy2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2468 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] height = new int[n][n];
        int max = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int nums = Integer.parseInt(st.nextToken());
                height[i][j] = nums;
                max = Math.max(max, nums);
            }
        }

        int maxHeight = 0;

        for (int i = 0; i <= max; i++) {
            maxHeight = Math.max(maxHeight, countSafeSpace(height, n, i));
        }

        System.out.println(maxHeight);
    }

    private static int countSafeSpace(int[][] height, int n, int h) {
        boolean[][] visited = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (height[i][j] > h && !visited[i][j]) {
                    count += bfs(visited, height, i, j, n, h);
                }
            }
        }

        return count;
    }

    private static int bfs(boolean[][] visited, int[][] height, int x, int y, int n, int h) {
        int[] dr = { 1, -1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { x, y });

        while (!q.isEmpty()) {
            int[] val = q.poll();
            for (int i = 0; i < 4; i++) {
                int r = val[0] + dr[i];
                int c = val[1] + dc[i];

                if (r >= 0 && r < n && c >= 0 && c < n && !visited[r][c] && height[r][c] > h) {
                    q.offer(new int[] { r, c });
                    visited[r][c] = true;
                }
            }
        }

        return 1;
    }
}
