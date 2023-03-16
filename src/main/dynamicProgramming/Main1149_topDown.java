package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * topDown 방식
 * 재귀함수 구현
 */
public class Main1149_topDown {

    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;

    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");

            cost[i][RED] = Integer.parseInt(st.nextToken());
            cost[i][GREEN] = Integer.parseInt(st.nextToken());
            cost[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        dp[0][RED] = cost[0][RED];
        dp[0][GREEN] = cost[0][GREEN];
        dp[0][BLUE] = cost[0][BLUE];

        System.out.println(Math.min(paint_cost(N-1, RED), Math.min(paint_cost(N-1,GREEN),paint_cost(N-1, BLUE))));

    }

    static int paint_cost(int N, int color){
        if(dp[N][color] == 0){
            switch (color){
                case RED:
                    dp[N][RED] = Math.min(paint_cost(N - 1, GREEN), paint_cost(N - 1, BLUE)) + cost[N][RED];
                    break;
                case GREEN:
                    dp[N][GREEN] = Math.min(paint_cost(N - 1, RED), paint_cost(N - 1, BLUE)) + cost[N][GREEN];
                    break;
                case BLUE:
                    dp[N][BLUE] = Math.min(paint_cost(N - 1, RED), paint_cost(N - 1, GREEN)) + cost[N][BLUE];
                    break;
            }
        }
        return dp[N][color];
    }
}
