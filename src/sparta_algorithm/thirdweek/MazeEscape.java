package sparta_algorithm.thirdweek;

import java.util.LinkedList;
import java.util.Queue;

// N x M 크기의 미로: BFS로 탐색하라
// 미로는 0과 1로 구성되어 있으며, 0은 이동할 수 없는 벽을 나타내고, 1은 이동할 수 있는 경로를 나타냅니다.
// 시작 위치는 (0, 0)이며, 미로의 출구는 (N-1, M-1)에 위치해 있습니다.
// 최단 경로로 미로를 탈출하는 방법을 찾는 프로그램을 작성하세요. 이동은 상하좌우로만 가능합니다.
public class MazeEscape {
    private static Queue<int[]> queue;
    public static void main(String[] args) {
        int[][] maze1 = {{1,1,1,0,1},{1,0,1,0,1},{1,0,1,0,1},{1,1,1,1,1}};
        int[][] maze2 = {{1,1,1,1,1},{0,0,0,0,1},{1,1,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};

        System.out.println(escapeCnt(maze1));
        System.out.println(escapeCnt(maze2));
    }

    private static int escapeCnt(int[][] maze){
        int rows = maze.length;
        int cols = maze[0].length;

        queue = new LinkedList<>();

        // 상하좌우 
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        queue.offer(new int[]{0, 0});
        maze[0][0] = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            
            // exit 도달 시 반환 
            if (curRow == rows - 1 && curCol == cols - 1) {
                return maze[curRow][curCol];
            }

            // 상하좌우 탐색 
            for(int k = 0; k < 4; k++){
                int x = curRow + dr[k];
                int y = curCol + dc[k];

                // 범위 내에 있는지, 해당 데이터가 '1'인지
                if(x >= 0 && x < rows && y >= 0 && y < cols && maze[x][y] == 1){
                    queue.offer(new int[]{x,y});
                    maze[x][y] = maze[curRow][curCol] + 1;
                }
            }
        }
        return -1;
    }
}
