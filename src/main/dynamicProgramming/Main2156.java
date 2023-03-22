package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // N 수
        int[] arr = new int[N + 1]; // N을 저장할 배열
        int[] dp = new int[N + 1];  // 최대값을 저장할 배열

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());   // 입력 값을 배열에 저장
        }

        dp[1] = arr[1]; // dp[1]에는 arr[1]의 값으로 초기화

        if(N >= 2) {
            dp[2] = arr[1] + arr[2]; // N이 2보다 크다면, dp[2]의 값도 초기화
            for (int i = 3; i <= N; i++) {  // 반복문을 돌며, 최대 값을 비교
                dp[i] =Math.max(dp[i-1],Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i]);
            }
        }
        System.out.println(dp[N]);  // 출력
    }
}
