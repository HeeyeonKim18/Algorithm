package codingstudy2.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bonus {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];

            StringTokenizer st;
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(maxVal(stickers, n)).append("\n");
        }
        System.out.println(sb);
    }

    private static int maxVal(int[][] stickers, int n) {
        int[][] dp = new int[2][n];

        dp[0][0] = stickers[0][0];
        dp[1][0] = stickers[1][0];

        for (int i = 1; i < n; i++) {
            if (i == 1) {
                dp[0][i] = stickers[0][i] + dp[1][i - 1];
                dp[1][i] = stickers[1][i] + dp[0][i - 1];
            } else {
                dp[0][i] = stickers[0][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] = stickers[1][i] + Math.max(dp[0][i - 1], dp[0][i - 2]);
            }
        }
        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }
}
