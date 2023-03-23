package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N]; // 입력 값 저장
        int[] dp = new int[N];  // 증가하는 부분 수열 구하기
        int[] r_dp = new int[N];    // 감소하는 부분 수열 구하기(역순으로 증가하는 부분 수열을 찾을 것임)

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());  // 입력 값 저장
        }

        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1); // 증가하는 부분 수열 비교 후 저장
            }
        }

        for(int i = N-1; i >= 0; i--){
            r_dp[i] = 1;
            for(int k = N-1; k >= i; k--){
                if(arr[i] > arr[k]) r_dp[i] = Math.max(r_dp[i], r_dp[k] + 1);   // 역순으로 증가하는 부분 수열 비교 후 저장
            }
        }

        int max = dp[0];    // 증가 + 감소 수열 중 가장 큰 값을 저장할 변수
        for(int i = 0; i < N; i++){
            dp[i] += r_dp[i]-1; // 해당 인덱스의 값을 더하기 (i값이 중복되기 때문에 -1을 해야함)
            max = Math.max(max, dp[i]); // 값 비교해서 최대값 저장
        }
        System.out.println(max);    // 출력
    }
}
