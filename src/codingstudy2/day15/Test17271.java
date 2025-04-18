package codingstudy2.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test17271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        final int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i >= m) {
                dp[i] = (dp[i] + dp[i - m]) % MOD;
            }
        }

        System.out.println(dp[n]);
    }
}
