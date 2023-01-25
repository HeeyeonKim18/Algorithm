package main.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            int n = Integer.parseInt(br.readLine());    // 입력받기
            int sum = 0;    // 소수 개수 더하기

            if(n == 0) break;   // n이 0이면 while문 빠져나가기

            boolean[] prime = new boolean[(n*2)+1]; // 2n까지 소수를 구할 수 있도록 배열 설정

            /*
                0, 1은 소수가 아니기에
                초기값 0으로 설정
             */
            prime[0] = true;
            prime[1] = true;

            // 에라토스테네스의 체 알고리즘으로 소수 구별하기
            for(int i = 2; i * i <= n * 2; i++){
                for(int j = i * i; j < prime.length; j+=i){
                    prime[j] = true;
                }
            }

            // 배열 값이 false(소수)라면 sum 변수 증가
            for(int i = n+1; i < prime.length; i++){
                if(!prime[i]) sum++;
            }

            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }
}
