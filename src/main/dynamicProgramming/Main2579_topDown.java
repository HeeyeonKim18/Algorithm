package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579_topDown {
    static int[] arr;   // 입력 값 받을 배열
    static Integer[] dp;    // 메모이제이션을 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 계단의 개수
        arr = new int[N + 1];
        dp = new Integer[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());   // 값 입력 받기
        }

        dp[0] = arr[0]; // 0번째 계단은 초기값으로 0
        dp[1] = arr[1]; // 1번째 계단 값은 입력값 1의 값으로 저장

        if (N >= 2) {   // 계단의 개수가 2와 같거나 크다면 2의 값은 배열 1과 2를 더한 값으로 저장
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(stair(N));
    }

    private static int stair(int dep) {
        if (dp[dep] == null) {  // 값이 null이라면?
            // 3번 연속된 값을 출력하지 않기 위해서 N-2, N-3의 값으로 재귀 함수를 호출하고 최대 값을 찾음
            dp[dep] = Math.max(stair(dep - 2), stair(dep - 3) + arr[dep - 1]) + arr[dep];
        }
        return dp[dep];
    }
}
