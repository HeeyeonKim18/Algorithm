package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9461 {
    static long[] dp = new long[101];   // 입력 값은 1 ~ 100

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());    // n 값 입력
            sb.append(p(N)).append("\n");
        }
        System.out.println(sb); // 출력
    }

    private static long p(int n) {
        // 배열 초기화
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        // n = 3 이상일 때 초기화된 값을 이용해서 값을 구함
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }
}
