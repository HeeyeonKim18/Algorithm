package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 전기줄을 수

        int[][] arr = new int[N][2];    // A와 B 입력 값
        int[] dp = new int[N];  // 각각의 최대 부분 수열 길이 구하기

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());   // 입력 값 저장
            }
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));   // A 전기줄 즉, 인덱스 0을 기준으로 오름차순 정렬

        for (int i = 0; i < N; i++) {
            dp[i] = 1;  // 값 초기화
            for (int j = 0; j < i; j++) {   // B 전기줄 즉, 인덱스 1을 값의 최대 부분 수열을 구함
                if (arr[i][1] > arr[j][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {   // 부분 수열 중 최대값을 구하기
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);    // 출력
    }
}
