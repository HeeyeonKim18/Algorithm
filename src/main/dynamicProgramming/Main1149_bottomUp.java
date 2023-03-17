package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * bottomUp 방식
 * 반복문을 활용하여 문제를 푸는 방식
 */
public class Main1149_bottomUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3];   // 배열 생성

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");   // 배열 값 저장하기

            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {  // 각 위치에서 이전 값의 비교해 최소합 만들기
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]);

        }

        // 배열에서 최소합을 찾아 출력하기
        System.out.println(Math.min(cost[N - 1][0], Math.min(cost[N - 1][1], cost[N - 1][2])));

    }
}
