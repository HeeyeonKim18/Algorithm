package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579_bottomUp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 계단의 개수
        int[] arr = new int[N + 1]; // 입력 값 배열
        int[] dp = new int[N + 1];  // 메모이제이션할 배열

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());   // 값 입력 받기
        }

        dp[1] = arr[1]; // 배열 1의 값을 입력 값 1로 초기화

        if (N >= 2) {   // 계단의 개수가 2와 같거나 크다면 2의 값은 배열 1과 2를 더한 값으로 저장
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= N; i++) {
            // 인덱스 3부터 N까지 i-2와 i-3+arr[i-1) 값에서 최대값을 찾아 해당 인덱스의 입력 값과 더해 값을 저장
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }

        System.out.println(dp[N]);  // 출력
    }

}
