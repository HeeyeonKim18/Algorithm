package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());   // 입력 받을 N개의 수

        /**
         * 배열 생성 음수 인덱스는 존재하지 않음
         * -4000 ~ 4000까지 범위를 다 포함하기 위해
         * 8001 길이의 배열 생성
         */
        int[] arr = new int[8001];

        int sum = 0;    // 평균 값 더할 변수
        int min = Integer.MAX_VALUE;    // 최소값
        int max = Integer.MIN_VALUE;    // 최대값

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());  // 수 입력 받기
            sum += val;     // 입력 받은 수 더하기
            arr[val+4000]++;    // +4000하여 해당 인덱스 값 증가시킴

            if (min > val)
                min = val;  // 최소값 구하기
            if (max < val)
                max = val;  // 최대값 구하기
        }

        int median = Integer.MAX_VALUE;     // 중앙값 담을 변수
        int mode = Integer.MAX_VALUE;       // 최빈값 담을 변수

        boolean check = false;  // 최빈값을 확인하기 위한 boolean 변수

        int count = 0;      // 중앙값을 알아낼 때 출력할 변수
        int mode_max = 0;   // 최빈값 max 값

        for (int i = min + 4000; i <= max + 4000; i++) {
            if(arr[i]>0){

                if(count < (N + 1) / 2){    // 입력 받은 수를 반으로 나눴을 때 위치하는 인덱스가 중앙값
                    count += arr[i];
                    median = i - 4000;
                }
            }

            if (mode_max < arr[i]) {       // 최빈값 최대를 구하기 위한 조건문
                mode_max = arr[i];
                mode = i - 4000;
                check = true;
            } else if (mode_max == arr[i] && check == true) {
                mode = i - 4000;
                check = false;
            }
        }

        // 출력하기
        System.out.println((int) Math.round((double)sum / N));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(max - min);
    }
}
