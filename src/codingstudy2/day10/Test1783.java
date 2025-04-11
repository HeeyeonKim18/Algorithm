package codingstudy2.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long n = Long.parseLong(input[0]);
        long m = Long.parseLong(input[1]);

        long result = 0;

        if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = Math.min(4, (m + 1) / 2);
        } else {
            if (m < 7) {
                result = Math.min(4, m);
            } else {
                result = m - 2;
            }
        }
        System.out.println(result);
    }
}
