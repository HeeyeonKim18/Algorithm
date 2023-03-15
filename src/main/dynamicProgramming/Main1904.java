package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1904 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 값 입력

        dp = new int[N + 1];    // 배열 생성

        System.out.println(tile()); // 출력
    }

    private static int tile() {
        // 배열 초기화하기, 인덱스 2를 초기화하면 런타임 에러 발생함
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;    // 나머지 계산은 배열에 값을 저장할 때 같이 하기
        }

        return dp[N];
    }
}
