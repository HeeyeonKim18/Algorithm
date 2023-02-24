package main.number;

import java.io.*;
import java.util.*;

public class Main9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int c = Integer.parseInt(br.readLine());
            Map<String, Integer> cnt = new HashMap<>();
            while (c-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken();
                String category = st.nextToken();
                cnt.put(category, cnt.getOrDefault(category, 0) + 1);
            }

            int ans = 1;

            for (int i : cnt.values()) {
                ans *= i + 1;
            }
            sb.append(ans - 1).append("\n");
        }
        System.out.println(sb);
    }
}

