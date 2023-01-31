package main.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(f(N));
    }

    private static int f(int n) {
        if(n < 2)
            return n;
        else
            return f(n-1) + f(n-2);
    }
}
