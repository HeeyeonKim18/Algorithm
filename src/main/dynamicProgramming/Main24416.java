package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 동적 계획법과 재귀함수 비교
 */
public class Main24416 {
    static int recursion_cnt = 0;   // 재귀함수 호출 횟수
    static int dp_cnt = 0;  // 동적계획법 호출 횟수
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 입력 값

        recursion(N);   // 재귀함수 메서드

        dp = new int[N + 1];    // 메모이제이션을 수행할 배열 생성
        fibo(N);    // 동적계획법 메서드

        /*
        출력
         */
        System.out.println(recursion_cnt);
        System.out.println(dp_cnt);
    }

    private static int fibo(int n) {

        dp[1] = dp[2] = 1;  // 가장 하위에 존재하는 값 1과 2에 1이라는 값을 저장

        for (int i = 3; i <= n; i++) {
            dp_cnt++;   // 호출 횟수 카운트
            dp[i] = dp[i - 1] + dp[i - 2];  // 해당 배열의 값에 배열에 저장된 i-1 과 i-2 를 더해 저장
        }

        return dp[n];   // n의 값을 리턴(이 문제에서는 이 값을 사용하지 않는다. 호출 횟수를 출력하는 문제이기 때문)
    }

    private static int recursion(int n) {   // 재귀 함수

        if (n == 1 || n == 2) { // 베이스 케이스 설정, 1이나 2일 때 호출 값을 카운트하고 1을 리턴
            recursion_cnt++;
            return 1;
        } else  // 이 외의 값에는 재귀 호출
            return recursion(n - 1) + recursion(n - 2);
    }
}
