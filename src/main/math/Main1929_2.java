package main.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1929_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // BufferedReader로 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");   // 입력 받은 수 공백으로 나누기
        StringBuilder sb = new StringBuilder(); // 소수 출력 때 쓰이는 클래스

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[N+1];   // boolean 배열

        /*
            0과 1은 소수가 아니기에 초기값을 true로 설정해준다.
         */
        isPrime[0] = true;
        isPrime[1] = true;

        for(int i = 2; i*i <= N; i++){
            for(int j = i*i; j < isPrime.length; j+=i){ // i를 제외하고 i의 배수는 모두 소수가 아니기에 true로 설정
                isPrime[j] = true;
            }
        }
        for(int i = M; i < isPrime.length; i++){    // 배열 값이 false(소수)인 인덱스만 출력
            if(!isPrime[i]) sb.append(i + "\n");
        }
        System.out.println(sb);
    }
}
