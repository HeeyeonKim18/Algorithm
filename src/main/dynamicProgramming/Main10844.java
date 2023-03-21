package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// bottom-up method
public class Main10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 입력 값 받기

        long[][] dp = new long[N + 1][10];  // 메모이제이션을 구현할 배열 생성

        long val = 1000000000; // 마지막에 나눠 줄 값

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;   // 배열 [1][1] ~ [1][9] 까지 초기화
        }

        // 마지막 수가 0이나 9라면 인접한 수의 개수는 하나 밖에 존재하지 않음
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {

                if (j == 0) dp[i][0] = dp[i - 1][1] % val;  // 인접한 수 인덱스 1만 가져오기
                else if (j == 9) dp[i][9] = dp[i - 1][8] % val; // 인접한 수 인덱스 8만 가져오기
                else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1] % val;  // 이 외의 수는 인접한 수(-1, +1)를 가져오기
            }
        }

        long total = 0; // 총 계단 수
        for (int i = 0; i < 10; i++) {
            total += dp[N][i];  // 해당 N의 값의 총 계단 수 더하기
        }
        System.out.println(total % val);    // 출력하기
    }
}
