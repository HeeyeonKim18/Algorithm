package codingstudy2.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test17484 {
    public static void main(String[] args) throws IOException {
        // 입력 및 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] space = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n][m][3]; // 3차원 DP 배열
        final int MAX = 1000 * 100 + 1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                Arrays.fill(dp[i][j], MAX);

        // 첫 번째 행 초기화
        for (int j = 0; j < m; j++) {
            dp[0][j][0] = dp[0][j][1] = dp[0][j][2] = space[0][j];
        }

        // DP
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 3; d++) {
                    int prevJ = j + (d - 1);
                    if (prevJ < 0 || prevJ >= m)
                        continue;

                    for (int prevD = 0; prevD < 3; prevD++) {
                        if (d == prevD)
                            continue;
                        dp[i][j][d] = Math.min(dp[i][j][d], dp[i - 1][prevJ][prevD] + space[i][j]);
                    }
                }
            }
        }
        int answer = MAX;
        for (int j = 0; j < m; j++) {
            for (int d = 0; d < 3; d++) {
                answer = Math.min(answer, dp[n - 1][j][d]);
            }
        }
        System.out.println(answer);
    }
}
