package main.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1929 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // BufferedReader로 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");   // 입력 받은 수 공백으로 나누기
        StringBuilder sb = new StringBuilder(); // 소수 출력 때 쓰이는 클래스

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean isPrime;    // 소수인지 판단하는 변수

        while(M <= N) {
            isPrime = false;    // 초기값 false 설정
            if(M == 1 || M == 0) isPrime = true;   // 0이나 1은 소수가 아니기에 true로 설정
            for (int j = 2; j * j <= M; j++) {
                if (M % j == 0) {   // 소수가 아니라면
                    isPrime = true; // isPrime을 true로 설정
                    break;
                }
            }
            if (isPrime == false) sb.append(M + "\n");  // isPrime이 false(소수)이면 sb.append하기
            M++;    // M 증가
        }
        System.out.println(sb); // 출력
    }
}