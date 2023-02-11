package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1018 {
    static boolean[][] arr;
    static int allMin = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'B')
                    arr[i][j] = true;
            }
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                check(i, j);
            }
        }
        System.out.println(allMin);
    }

    private static void check(int a, int b) {
        int count = 0;
        boolean color = arr[a][b];
        for (int i = a; i < a + 8; i++) {
            for (int j = b; j < b + 8; j++) {
                if (arr[i][j] != color) {
                    count++;
                }
                color = !color;
            }
            color = !color;
        }
        count = Math.min(count, 64 - count);

        allMin = Math.min(allMin, count);
    }

}
