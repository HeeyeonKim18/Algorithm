package main.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int change = 1000 - N;  // 거스름돈

        int[] money = {500, 100, 50, 10, 5, 1}; // 동전 종류
        int count = 0;  // 거슬러 줄 동전 개수

        for(int i = 0; i < money.length; i++){
            count += change / money[i]; // 동전 개수 더하기
            change %= money[i]; // 개수만큼 잔돈에서 빼주기
        }

        System.out.println(count);  // 출력
    }
}

