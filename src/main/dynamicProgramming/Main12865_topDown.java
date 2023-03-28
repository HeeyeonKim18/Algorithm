package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// top-down 방식
public class Main12865_topDown {
    static Integer dp[][];  // 최대 가치 값을 담을 2차원 배열
    static int arr[][]; // 입력 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   // N개의 물품
        int K = Integer.parseInt(st.nextToken());   // 최대 K무게

        arr = new int[N][2];
        dp = new Integer[N][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());   // 입력 값 저장
            }
        }

        System.out.println(knapsack(N - 1, K)); // 출력
    }

    private static int knapsack(int n, int w) {
        if (n < 0) return 0;    // n이 0보다 작다면 0을 리턴

        if (dp[n][w] == null) { // 해당 배열 값이 널이라면?

            if (arr[n][0] > w) {   // 배열의 값이 최대 무게보다 많이 나간다면?
                dp[n][w] = knapsack(n - 1, w);  // 추가로 물건을 담지 못하고 이전 노드 탐색
            }
            else {
                // 두 배열 중 가치가 큰 값을 저장
                dp[n][w] = Math.max(knapsack(n - 1, w - arr[n][0]) + arr[n][1], knapsack(n - 1, w));
            }
        }
        return dp[n][w];
    }
}
