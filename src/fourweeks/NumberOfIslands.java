package fourweeks;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslands {
    private static final int[] DR = { 1, -1, 0, 0 };
    private static final int[] DC = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        char[][] grid = { { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' } };

        char[][] grid1 = { { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' } };
        System.out.println(numIslands(grid));
        System.out.println(numIslandsRecur(grid1));
    }

    private static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int rl = grid.length, cl = grid[0].length;
        int count = 0;

        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (grid[i][j] == '1') {
                    count++;

                    grid[i][j] = '0';
                    q.add(new int[] { i, j });

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int row = cur[0];
                        int col = cur[1];

                        for (int k = 0; k < 4; k++) {
                            int kl = DR[k] + row, kc = DC[k] + col;
                            if (kl >= 0 && kl < rl && kc >= 0 && kc < cl && grid[kl][kc] == '1') {
                                q.add(new int[] { kl, kc });
                                grid[kl][kc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static int numIslandsRecur(char[][] grid) {
        int R = grid.length, C = grid[0].length;
        int count = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '1') { // 새로운 섬 발견
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int r, int c) {
        // 1) 범위 체크
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
            return;

        // 2) 물(0)이거나 이미 방문한 경우 종료
        if (grid[r][c] == '0')
            return;

        // 3) 현재 칸 방문 처리 (육지를 물로 바꿔버림)
        grid[r][c] = '0';

        // 4) 상하좌우 탐색
        dfs(grid, r + 1, c); // 아래
        dfs(grid, r - 1, c); // 위
        dfs(grid, r, c + 1); // 오른쪽
        dfs(grid, r, c - 1); // 왼쪽
    }
}
