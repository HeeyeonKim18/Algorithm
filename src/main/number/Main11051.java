package main.number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11051 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(func(N, K));
    }

    private static int func(int n, int k) {
        dp = new int[n + 1][k + 1]; // 2차원 배열 생성, 작은 해의 값을 저장하고 사용

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) { // i와 k 중 작은 값을 구해 불필요한 계산을 줄임

                if (j == 0 || j == i) dp[i][j] = 1; // 재귀함수의 베이스 케이스와 동일

                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;  // 저장된 값을 불러와 사용하기 때문에, 반복을 피할 수 있음
            }
        }
        return dp[n][k];
    }
}
