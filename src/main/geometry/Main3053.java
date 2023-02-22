package main.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double U = N * N * Math.PI;
        double T = N * N * 2;

        System.out.printf("%.6f%n", U);
        System.out.printf("%.6f", T);
    }
}
