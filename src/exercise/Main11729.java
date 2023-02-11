package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println((int)Math.pow(2, N) -1);
        hanoi(N, 1, 2, 3);

    }

    private static void hanoi(int n, int start, int mid, int end) {
        if(n == 1){
            System.out.println(start + " " + end);

            return;
        }

        hanoi(n-1, start, end, mid);

        System.out.println(start + " " +end);

        hanoi(n - 1, mid, start, end);


    }
}
