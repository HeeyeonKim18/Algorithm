package codingstudy.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1018 {
    static char[][] board;
    static int n, m;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                checkBoard(i, j);
            }
        }

        System.out.println(min);
    }

    private static void checkBoard(int x, int y) {
        int repaintW = 0;
        int repaintB = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[x + i][y + j] != 'W')
                        repaintW++;
                    if (board[x + i][y + j] != 'B')
                        repaintB++;
                } else {
                    if (board[x + i][y + j] != 'B')
                        repaintW++;
                    if (board[x + i][y + j] != 'W')
                        repaintB++;
                }
            }
        }
        min = Math.min(min, Math.min(repaintW, repaintB));
    }
}
