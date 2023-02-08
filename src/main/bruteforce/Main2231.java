package main.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strN = br.readLine();

        int N_len = strN.length();

        int N = Integer.parseInt(strN);
        int result = 0;

        for (int i = N - (N_len * 9); i < N; i++) {
            int number = i;
            int sum = 0;

            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if (i + sum == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
