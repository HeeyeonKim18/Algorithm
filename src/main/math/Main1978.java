package main.math;

import java.util.Scanner;

public class Main1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int prime_num = 0;

        for (int c = 0; c < T; c++) {
            int N = sc.nextInt();

            int[] arr = new int[N];

            for (int i = 0, j = 1; j <= N; i++, j++) {
                if (N % j == 0) {
                    arr[i] = j;
                }
            }
            int count = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    count++;
                }
            }
            if (count == 2) prime_num++;
        }
        System.out.println(prime_num);
    }
}
