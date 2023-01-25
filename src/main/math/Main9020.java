package main.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9020 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            boolean[] arr = new boolean[N + 1];
            arr[0] = true;
            arr[1] = true;
            for (int i = 2; i * i <= N; i++) {
                for (int j = i * i; j < arr.length; j += i) {
                    arr[j] = true;
                }
            }

            int first = N / 2;
            int last = N / 2;

            while (true) {
                if (arr[first] == false && arr[last] == false) {
                    System.out.println(first + " " + last);
                    break;
                }
                first--;
                last++;
            }

        }
    }
}
