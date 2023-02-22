package main.number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main2981_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int gcd = arr[1] - arr[0];

        for (int i = 2; i < N; i++) {
            gcd = getGcd(gcd, arr[i] - arr[i - 1]);
        }

        divide(gcd);

    }

    private static void divide(int result) {
        List<Integer> list = new ArrayList<>();

        list.add(result);

        for (int i = 2; i <= Math.sqrt(result); i++) {
            if (i * i == result)
                list.add(i);
            else if (result % i == 0) {
                list.add(i);
                list.add(result / i);
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static int getGcd(int a, int b) {
        if (b == 0) return a;
        else return getGcd(b, a % b);
    }
}
