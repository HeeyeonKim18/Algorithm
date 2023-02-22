package main.number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (i != 0) {
                int result = gcd(arr[0], arr[i]);
                sb.append(arr[0] / result).append("/").append(arr[i] / result).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int gcd(int i, int j) {
        if (j == 0) return i;
        else return gcd(j, i % j);
    }
}
