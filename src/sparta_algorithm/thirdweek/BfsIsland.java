package sparta_algorithm.thirdweek;

import java.util.LinkedList;
import java.util.Queue;

public class BfsIsland {
    private static int[][] grid1 = new int[][]{{1,1,1,1,0}, {1,1,0,1,0}, {1,1,0,0,0}, {0,0,0,0,0}};
    private static int[][] grid2 = new int[][]{{1,1,0,0,0}, {1,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,1}};
    
    public static void main(String[] args) {
        System.out.println(bfs(grid1));
        System.out.println(bfs(grid2));
    }

    private static int bfs(int[][] grid){
        Queue<int[]> q = new LinkedList<>();
        if (grid == null || grid.length == 0) return 0;

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // 방향 배열 정의 (상, 하, 좌, 우)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    numIslands++;
                    
                    q.offer(new int[]{i, j});

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int row = cur[0];
                        int col = cur[1];

                        // 1. 방문 처리
                        grid[row][col] = 0;

                        // 2. 인접한 노드 방문 예약
                        for(int k = 0; k < 4; k++){
                            int nr = row + dr[k];
                            int nc = col + dc[k];

                            if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1)
                                q.offer(new int[]{nr,nc});
                        }
                    }
                }
            }
        }
        return numIslands;
    }
}
