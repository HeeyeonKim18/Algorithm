package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작은 값에서 큰 값 구하기
 */
public class Main1463_bottomUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];  // 각 배열에 최소 연산 횟수를 저장
        dp[0] = dp[1] = 0;  // 0과 1은 0으로 초기화하기

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;  // 1을 빼는 연산
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 3으로 나누는 연산
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 2로 나누는 연산
        }

        System.out.println(dp[N]);  // 출력하기
    }
}
