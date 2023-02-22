package main.number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int gcd = arr[1] - arr[0];

        for (int i = 2; i < size; i++) {
            int dist1 = arr[i] - arr[i - 1];

            gcd = getGCD(gcd, dist1);
        }

        for(int i = 2; i <= gcd / 2 ; i++){
            if(gcd % i == 0)
                sb.append(i).append(" ");
        }
        sb.append(gcd);
        System.out.println(sb);
    }

    public static int getGCD(int a, int b) {
        if(b == 0) return a;
        else return getGCD(b, a % b);
    }

}