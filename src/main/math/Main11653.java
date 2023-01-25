package main.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 숫자 입력 받기

        for(int i = 2; i * i <= N; i++){
            while(N % i == 0){
                System.out.println(i);
                N/=i;
            }
        }

        if(N != 1){
            System.out.println(N);
        }
    }
}

//    /*
//                소수 구분하기
//                소수라면 false
//                소수가 아니라면 true
//             */
//    boolean[] arr = new boolean[N + 1];
//
//// 0과 1은 소수가 아니므로 초기값 설정
//        arr[0] = true;
//                arr[1] = true;
//
//                // 에라토스테네스의 체 방식으로 소수 알아내기
//                for (int i = 2; i * i < N; i++) {
//        for (int j = i * i; j < N; j += i) {
//        arr[j] = true;
//        }
//        }
//
//        for (int i = 2; i < arr.length; i++) {
//        if (arr[i] != true) {   // 소수라면 ?
//        while (N % i == 0) {    // 소수이면서 입력 값 N으로 나눴을 때 나머지가 0이라면 ?
//        System.out.println(i);  // 출력하기
//        N /= i;     // N은 i값으로 나눠주기
//        }
//        }
//        }
