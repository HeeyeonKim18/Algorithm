package main.math;

import java.util.Scanner;

public class Main1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();
        int crs_cnt = 1;

        while (true) {
            N -= crs_cnt;
            if (N <= 0) {
                N += crs_cnt;
                break;
            }
            crs_cnt++;
        }
        if (crs_cnt % 2 == 1) {
            System.out.println((crs_cnt - N + 1) + "/" + N);
        } else {
            System.out.println(N + "/" + (crs_cnt - N + 1));
        }


    }
}
