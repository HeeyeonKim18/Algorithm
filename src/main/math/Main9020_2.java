package main.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9020_2 {
    static boolean[] isPrime = new boolean[10001];

    private void prime() {
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i * i <= isPrime.length; i++) {
            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Main9020_2 main = new Main9020_2();
        int T = Integer.parseInt(br.readLine());
        main.prime();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int first = N / 2;
            int last = N / 2;

            while (true) {
                if (!isPrime[first] && !isPrime[last]) {
                    sb.append(first).append(" ").append(last).append("\n");
                    break;
                }
                first--;
                last++;
            }
        }
        System.out.println(sb);
    }
}
