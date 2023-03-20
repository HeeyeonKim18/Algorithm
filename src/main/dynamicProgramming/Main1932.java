package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1932 {
    static int N;
    static int[][] arr; // 값 입력 배열
    static Integer[][] dp;  // 메모이제이션 실행할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 삼각형의 크기
        arr = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());   // 입력 받기
            }
        }

        dp = new Integer[N][N];
        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];   // 재귀호출시 베이스케이스 수 미리 입력하기
        }

        System.out.println(triangle(0, 0)); // 최대값 출력
    }

    private static int triangle(int dep, int idx) {
        if (dep == N - 1) return dp[dep][idx];  // dep이 최하위층일 때, 입력했던 베이스케이스 값 리턴

        if (dp[dep][idx] == null) {     // 해당 배열에 값이 없다면, 대각선 왼쪽과 오른쪽 값 중 큰 값과 해당 입력 값을 더해 배열에 저장
            dp[dep][idx] = Math.max(triangle(dep + 1, idx), triangle(dep + 1, idx + 1)) + arr[dep][idx];
        }
        return dp[dep][idx];
    }
}
