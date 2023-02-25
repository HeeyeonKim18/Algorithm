package main.number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long n = Integer.parseInt(st.nextToken());   // n 값 입력 받기
        long m = Integer.parseInt(st.nextToken());   // m 값 입력 받기

        int twoCount = two(n) - two(n-m) - two(m);  // 2의 승수 구하기
        int fiveCount = five(n) - five(n - m) - five(m);    // 5의 승수 구하기

        int min = Math.min(twoCount, fiveCount);    // 2와 5의 승수 중 최소값 구하기

        System.out.println(min);    // 출력하기

    }

    private static int five(long i) {
        int count = 0;

        while(i >= 5){
            count += (i / 5);
            i /= 5;
        }
        return count;
    }

    private static int two(long i) {
        int count = 0;

        while(i >= 2){
            count += (i / 2);
            i /= 2;
        }
        return count;
    }
}
