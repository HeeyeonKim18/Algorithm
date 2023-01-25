package main.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());    // M 입력
        int N = Integer.parseInt(br.readLine());    // N 입력받기

        boolean[] prime = new boolean[N + 1];   // 숫자 N까지 배열 생성하기

        /*
            0과 1은 소수가 아님
            소수면 -> false
            소수가 아니라면 -> true
         */
        prime[0] = true;
        prime[1] = true;

        /*
            에라토스테네스의 체
            2 부터 √N 이하까지 반복하여 자연수들 중 i를 제외한 i의 배수들은 소수가 아님
         */
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        int sum = 0;    // 소수를 더해줌
        int min = Integer.MAX_VALUE;    // 최소값을 설정

        for (int i = M; i <= N; i++) {
            if (prime[i] == false) {    // 소수라면(false) sum에 더하기
                sum += i;
                if (min == Integer.MAX_VALUE) min = i;  // min값은 첫 번째 소수값이 되도록 설정
            }
        }

        /*
            sum이 0이라면 소수가 없다는 뜻으로 -1 출력
            그 외의 경우에는 sum과 min를 출력하기
         */
        if (sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }

    }
}
