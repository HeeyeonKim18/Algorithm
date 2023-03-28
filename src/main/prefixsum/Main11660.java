package main.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());   // n * n 의 2차원 배열
        int m = Integer.parseInt(st.nextToken());   // 질의 수

        int[][] A = new int[n + 1][n + 1];  // 입력 값
        int[][] D = new int[n + 1][n + 1];  // 구간합을 구할 배열
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()); // 입력 값 받기
                D[i][j] = D[i - 1][j] + D[i][j - 1] - D[i - 1][j - 1] + A[i][j];    // 구간 합 구하기
            }
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]).append("\n");  // 해당 범위의 구간합 구하기
        }
        System.out.println(sb); // 출력하기
    }
}
