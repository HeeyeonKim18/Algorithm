package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9184 {
    /**
     * 3차원 배열 생성, 입력 값은 -50 ~ 50 이지만
     * 20까지만 사용되기 때문에 배열 길이를 21로 설정
     */
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine(), " "); // 값 입력 받기
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;   // 세 값이 -1이라면 while문 빠져나가기
            else {
                int result = w(a, b, c);    // 메서드 실행
                sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(result).append("\n");
            }
        }
        System.out.println(sb); // 전체 값 출력
    }

    private static int w(int a, int b, int c) {
        // 0 보다 작다면 1을 출력
        if (a <= 0 || b <= 0 || c <= 0) return 1;

        // 20 이상의 값이라도 w(20,20,20)을 호출하기 때문에 dp[20][20][20]에 값을 저장
        if (a > 20 || b > 20 || c > 20) return dp[20][20][20] = w(20, 20, 20);

        // 조건 값이 저장되어 있다면 해당 값 바로 반환, 아니라면 해당 배열에 재귀 값 저장
        if (a < b && b < c) {
            if (dp[a][b][c] != 0) return dp[a][b][c];
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        // 조건 값이 저장되어 있다면 해당 값 바로 반환, 아니라면 해당 배열에 재귀 값 저장
        if (dp[a][b][c] != 0) return dp[a][b][c];
        else return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}
