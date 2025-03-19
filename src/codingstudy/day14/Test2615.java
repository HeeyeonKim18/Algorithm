package codingstudy.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2615 {
    static int[][] board = new int[19][19];
    static int[] dr = { 0, 1, 1, -1 };
    static int[] dc = { 1, 0, 1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) {
                    if (isFive(i, j)) {
                        System.out.println(board[i][j]);
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean isFive(int x, int y) {
        int color = board[x][y];

        for (int i = 0; i < 4; i++) {
            int cnt = 1;
            int r = x + dr[i];
            int c = y + dc[i];

            while (isValid(r, c) && board[r][c] == color) {
                cnt++;
                r += dr[i];
                c += dc[i];
            }

            r = x - dr[i];
            c = y - dc[i];

            while (isValid(r, c) && board[r][c] == color) {
                cnt++;
                r -= dr[i];
                c -= dc[i];
            }

            if (cnt == 5) {
                if (!isValid(x - dr[i], y - dc[i]) || board[x - dr[i]][y - dc[i]] != color) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }
}
