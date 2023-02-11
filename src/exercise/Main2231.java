package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            int sum = 0;
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                sum += s.charAt(j)-48;
            }
            if (sum + i == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
