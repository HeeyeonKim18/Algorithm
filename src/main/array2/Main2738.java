package main.array2;

import java.io.IOException;
import java.util.Scanner;

public class Main2738 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr1 = new int[N][M];
        int[][] arr2 = new int[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr1[i][j] += arr2[i][j];
                sb.append(arr1[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
