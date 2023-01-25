package main.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int cnt = 0;
            int front = 0;
            int back = 0;

            for (int j = 1; j <= W; j++) {
                for (int k = 1; k <= H; k++) {
                    cnt++;
                    front = k * 100;
                    back = j;
                    if (cnt == N) break;
                }
                if (cnt == N) break;
            }
            System.out.println(front + back);
        }
    }
}
