package codingstudy.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2573 {
    static int n, m;
    static int[][] ice;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        ice = new int[n][m];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;

        while (true) {
            int count = countIcebergs();

            if (count >= 2) {
                System.out.println(year);
                break;
            } else if (count == 0) {
                System.out.println(0);
                break;
            }

            meltIce();
            year++;

        }
    }

    private static int countIcebergs() {
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ice[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(int i, int j, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { i, j });
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int f = 0; f < 4; f++) {
                int r = cur[0] + dr[f];
                int c = cur[1] + dc[f];

                if (r >= 0 && r < n && c >= 0 && c < m && !visited[r][c] && ice[r][c] > 0) {
                    q.offer(new int[] { r, c });
                    visited[r][c] = true;
                }
            }

        }
    }

    private static void meltIce() {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ice[i][j] > 0) {
                    int waterCount = 0;

                    for (int f = 0; f < 4; f++) {
                        int r = i + dr[f];
                        int c = j + dc[f];

                        if (r >= 0 && r < n && c >= 0 && c < m && ice[r][c] == 0) {
                            waterCount++;
                        }
                    }
                    temp[i][j] = Math.max(0, ice[i][j] - waterCount);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(temp[i], 0, ice[i], 0, m);
        }
    }
}
