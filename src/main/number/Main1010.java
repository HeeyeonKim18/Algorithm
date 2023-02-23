package main.number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1010 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int east = Integer.parseInt(st.nextToken());
            int west = Integer.parseInt(st.nextToken());

            sb.append(func(west, east)).append("\n");
        }
        System.out.println(sb);
    }

    private static int func(int west, int east) {
        dp = new int[west + 1][east + 1];

        for (int i = 0; i <= west; i++) {
            for (int j = 0; j <= Math.min(i, east); j++) {

                if (j == 0 || j == i) dp[i][j] = 1;

                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]);
            }
        }
        return dp[west][east];
    }
}
