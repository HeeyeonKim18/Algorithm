package main.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// top_down 방식
public class Main9251_topDown {
    static Integer[][] dp;  // 부분 배열 연속 횟수를 저장할 2차원 배열
    static char[] arr1, arr2;   // 입력 값을 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 메소드로 문자열을 char 값으로 변환 후 배열에 저장
        arr1 = br.readLine().toCharArray();
        arr2 = br.readLine().toCharArray();

        dp = new Integer[arr1.length][arr2.length];

        System.out.println(compare(arr1.length - 1, arr2.length - 1));  // 메소드 실행 및 출력

    }

    private static int compare(int i, int j) {

        if (i == -1 || j == -1) return 0;   // i, j가 -1일 경우 0을 리턴

        if(dp[i][j] == null){   // 해당 값이 널이 아닐 경우
            dp[i][j] = 0;

            // 해당 캐릭터 값이 동일하다면?
            if (arr1[i] == arr2[j]) dp[i][j] = compare(i - 1, j - 1) + 1;   // 대각선 배열의 값에 +1

            // 다르다면?
            else dp[i][j] = Math.max(compare(i - 1, j), compare(i, j - 1)); // 해당 배열의 값 중에 최대값
        }
        return dp[i][j];
    }
}
