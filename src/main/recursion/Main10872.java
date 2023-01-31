package main.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(recursion(N));
    }

    private static int recursion(int n) {
        if (n == 0)
            return 1;
        else
            return n * recursion(n - 1);
    }
}
