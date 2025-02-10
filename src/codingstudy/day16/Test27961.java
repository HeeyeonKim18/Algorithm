package codingstudy.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test27961 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long catCount = 1;
        long magic = 1;

        if (n == 0) {
            System.out.println(0);
            return;
        } else {
            while (true) {
                if (catCount >= n) {
                    System.out.println(magic);
                    return;
                }
                catCount *= 2;
                magic++;
            }
        }
    }
}
