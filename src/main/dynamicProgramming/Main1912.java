package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 입력될 숫자의 개수

        int[] arr = new int[N]; // 입력될 숫자 배열
        int[] dp = new int[N];  // 값을 저장할 배열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0]; // dp[0]에는 배열의 1번째 값 넣어주기
        int max = dp[0];    // max 값에도 배열 첫번째 값 넣어주기

        for (int i = 1; i < N; i++) {   // 배열 첫번째 값을 제외한 반복문 생성
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);   // 값을 저장하는 배열에 값을 비교해서 최대 값을 저장
            max = Math.max(max, dp[i]); // max 변수에도 최대값을 저장
        }
        System.out.println(max);    // 출력
    }
}
