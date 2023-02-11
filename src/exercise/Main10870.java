package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(fibo(N));

    }

    private static int fibo(int n) {
        if(n <= 2) return 1;
        return fibo(n-1) + fibo(n-2);
    }
}
