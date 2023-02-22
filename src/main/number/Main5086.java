package main.number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5086 {
    static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            result = "neither";
            if (first == 0 && last == 0) break;

            if (first < last)
                factor(first, last);
            else
                multiple(first, last);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void factor(int first, int last) {

        for (int i = 1; i <= last; i++) {
            int f = first * i;
            if (f == last) {
                result = "factor";
                break;
            }
        }
    }

    private static void multiple(int first, int last) {
        for (int i = 1; i <= first; i++) {
            float f = (float) first / i;
            if (f == last) {
                result = "multiple";
                break;
            }
        }
    }
}
