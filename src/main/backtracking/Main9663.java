package main.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9663 {
    static int N;
    static int count = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);

        System.out.println(count);

    }

    private static void dfs(int col) {
        if (col == N) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[col] = i;
            if (isPossible(col)) {
                dfs(col + 1);
            }
        }
    }

    private static boolean isPossible(int col) {

        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
