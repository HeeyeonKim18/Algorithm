package codingstudy.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1051 {
    static int n;
    static int m;
    static int[][] rectangle;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);

        rectangle = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                rectangle[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                checkSquare(i, j);
                if (max == n * m) {
                    System.out.println(max);
                    return;
                }
            }
        }

        System.out.println(max);
    }

    static void checkSquare(int x, int y) {
        for (int i = 1; x + i < n && y + i < m; i++) {
            if (rectangle[x][y] == rectangle[x + i][y]
                    && rectangle[x][y] == rectangle[x][y + i]
                    && rectangle[x][y] == rectangle[x + i][y + i]) {
                max = Math.max(max, (i + 1) * (i + 1));
            }
        }
    }
}
