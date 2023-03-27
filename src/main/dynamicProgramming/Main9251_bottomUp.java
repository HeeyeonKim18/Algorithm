package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// bottom_up 방식
public class Main9251_bottomUp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 값 char로 변환해 배열에 저장
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int length_A = A.length;
        int length_B = B.length;

        int[][] dp = new int[length_A + 1][length_B + 1]; // 인덱스 0은 0의 값으 가지고 있음

        for (int i = 1; i <= length_A; i++) {
            for (int j = 1; j <= length_B; j++) {
                // 이전 A, B의 문자가 같다면?
                if (A[i - 1] == B[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;  // 대각선 배열의 값에서 +1

                // 다르다면?
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);   // 해당 값 중에서 최대값을 가져옴
            }
        }
        System.out.println(dp[length_A][length_B]); // 출력하기
    }
}

