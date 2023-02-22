package main.number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5086_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());

            if (first == 0 && last == 0) break;

            if (last % first == 0)
                sb.append("factor").append("\n");
            else if (first % last == 0)
                sb.append("multiple").append("\n");
            else
                sb.append("neither").append("\n");
        }
        System.out.println(sb);
    }
}
