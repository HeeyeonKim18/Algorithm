package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1463_topDown {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 정수 값 입력 받기
        dp = new Integer[N + 1];    // 연산의 최소 횟수를 메모이제이션할 배열 생성
        dp[0] = dp[1] = 0;  // 배열 값 초기화

        System.out.println(recursion(N));   // 출력
    }

    private static int recursion(int n) {
        if (dp[n] == null) {    // 각 케이스를 조건문으로 나누어 재귀 호출이 이루어짐
            if (n % 6 == 0) {
                dp[n] = Math.min(recursion(n / 3), Math.min(recursion(n / 2), recursion(n - 1))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(recursion(n / 3), recursion(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(recursion(n / 2), recursion(n - 1)) + 1;
            } else {
                dp[n] = recursion(n - 1) + 1;
            }
        }
        return dp[n];
    }
}
