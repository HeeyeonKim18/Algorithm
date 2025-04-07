package codingstudy2.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 섬의 개수 세는 프로그램(여러 개의 테스트 코드)
 * 섬: 1, 바다: 0
 */
public class Test4963 {
    static int[] dr = { 1, -1, 0, 0, -1, -1, 1, 1 };
    static int[] dc = { 0, 0, 1, -1, -1, 1, -1, 1 };

    static int w;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean[][] visited = new boolean[h][w];
            sb.append(countLands(map, visited)).append("\n");
        }
        System.out.println(sb);
    }

    private static int countLands(int[][] map, boolean[][] visited) {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count += bfs(i, j, map, visited);
                }
            }
        }
        return count;
    }

    private static int bfs(int x, int y, int[][] map, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { x, y });
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] target = q.poll();

            for (int i = 0; i < 8; i++) {
                int r = target[0] + dr[i];
                int c = target[1] + dc[i];
                if (r >= 0 && r < h && c >= 0 && c < w && map[r][c] == 1 && !visited[r][c]) {
                    q.offer(new int[] { r, c });
                    visited[r][c] = true;
                }
            }
        }
        return 1;
    }
}
