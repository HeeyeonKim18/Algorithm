package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());

        int[] arr = new int[A + 1]; // 입력 값을 저장할 배열
        int[] dp = new int[A + 1];  // 배열[A]까지의 부분 증가 수열의 개수를 저장할 배열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // 값 입력 받기
        }

        int max = Integer.MIN_VALUE;    // 최대 길이 값을 저장할 변수 max
        for (int i = 1; i <= A; i++) {
            dp[i] = 1;  // 배열의 값을 1로 초기화
            for (int j = 1; j < i; j++) {   // dp[1] ~ dp[N]까지 값을 탐색
                if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);    // 배열[i]의 값이 배열[j]의 값보다 크다면 최대값을 저장
            }
            if(dp[i] > max) max = dp[i];    // 최대값 저장하기
        }
        System.out.println(max);    // 출력하기
    }
}
