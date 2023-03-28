package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// bottom-up 방식
public class Main12865_bottomUp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   // N개의 물품
        int K = Integer.parseInt(st.nextToken());   // 최대 K무게

        int[] weight = new int[N + 1];  // 무게 값을 저장할 배열
        int[] value = new int[N + 1];   // 가치를 저장할 배열
        int[][] dp = new int[N + 1][K + 1];   // 메모이제이션

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weight[i] = Integer.parseInt(st.nextToken());   // 입력 값 저장
            value[i] = Integer.parseInt(st.nextToken());    // 입력 값 저장
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (weight[i] > j) {    // 무게가 j보다 작을 때
                    dp[i][j] = dp[i - 1][j];    // 해당 i번째 물건을 담을 수 없다는 뜻으로 이전 값을 가져와 저장
                } else {    // i번째 물건을 담을 수 있을 경우로 이전 값과 j에서 i무게 뺀 값 + 가치 중 큰 값을 저장
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[N][K]);   // 출력
    }
}
