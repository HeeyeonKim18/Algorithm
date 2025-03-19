package codingstudy.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test9251 {
    static int[][] dp;
    static String str1;
    static String str2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();

        dp = new int[str1.length() + 1][str2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(lcs(str1.length() - 1, str2.length() - 1));

    }

    static int lcs(int i, int j) {
        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j] = lcs(i - 1, j - 1) + 1;
        } else {
            return dp[i][j] = Math.max(lcs(i - 1, j), lcs(i, j - 1));
        }
    }
}
