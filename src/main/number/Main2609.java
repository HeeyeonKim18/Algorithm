package main.number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = gcd(a, b);
        System.out.println(gcd);    // 최대공약수
        System.out.println(a * b / gcd);    // 최소공배수 = 두 자연수의 곱 / 최대\공약수
    }

    /**
     * 유클리드 호제법 알고리즘
     */

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}
