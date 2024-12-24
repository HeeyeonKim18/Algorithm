package sparta_algorithm.thirdweek;

import java.util.Stack;

public class DfsIsland {

    private static int[][] grid1 = new int[][]{{1,1,1,1,0}, {1,1,0,1,0}, {1,1,0,0,0}, {0,0,0,0,0}};
    private static int[][] grid2 = new int[][]{{1,1,0,0,0}, {1,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,1}};
    public static void main(String[] args) {
        System.out.println("recrusive = " + recursive(grid1.clone()));
        // System.out.println("grid1 with stack = " + stack(grid1));

        // System.out.println("recrusive = " + recursive(grid2));
        System.out.println("grid2 with stack = " + stack(grid2));
    }

    private static int recursive(int[][] grid){
        if (grid == null || grid.length == 0) return 0;

        int numIslands = 0;

        // 모든 좌표를 순회
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // 현재 좌표가 땅(1)이면 DFS 실행
                if (grid[row][col] == 1) {
                    numIslands++; // 새로운 섬 발견
                    dfs(grid, row, col); // 연결된 모든 땅을 방문 처리
                }
            }
        }

        return numIslands;
    }

    private static void dfs(int[][] grid, int row, int col){
        // 방향 배열 정의 (상, 하, 좌, 우)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int rows = grid.length;
        int cols = grid[0].length;

        // 범위를 벗어나거나 물(0)이거나 이미 방문한 땅이면 종료
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return;
        }

        // 현재 땅을 물(0)로 변경해 방문 처리
        grid[row][col] = 0;

        // 4개의 방향(상, 하, 좌, 우)을 탐색
        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];
            dfs(grid, newRow, newCol);
        }
    }

    private static int stack(int[][] grid){
        if (grid == null || grid.length == 0) return 0;

        int numIslands = 0;

        // 모든 좌표를 순회
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // 현재 좌표가 땅(1)이면 DFS 실행
                if (grid[row][col] == 1) {
                    numIslands++; // 새로운 섬 발견
                    stackDfs(grid, row, col); // 스택을 사용한 DFS로 방문 처리
                }
            }
        }

        return numIslands;
    }

    private static void stackDfs(int[][] grid, int row, int col) {
        // 방향 배열 정의 (상, 하, 좌, 우)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int rows = grid.length;
        int cols = grid[0].length;

        // 스택 생성 및 초기값 추가
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});

        // DFS 시작
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int curRow = current[0];
            int curCol = current[1];

            // 현재 땅을 방문 처리 (0으로 변경)
            grid[curRow][curCol] = 0;

            // 4개의 방향 탐색
            for (int i = 0; i < 4; i++) {
                int newRow = curRow + dr[i];
                int newCol = curCol + dc[i];

                // 유효한 좌표인지 확인
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                    stack.push(new int[]{newRow, newCol});
                }
            }
        }
    }
}
