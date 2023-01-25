package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5]; // 길이가 5인 배열 생성
        float sum = 0; // 평균 구하기 위해서 숫자들의 합계 계산

        for(int i = 0; i < 5; i++) {
            arr[i] += Integer.parseInt(br.readLine());  // 입력 받기
            sum += arr[i];  // 입력 받은 수 더하기
        }

        Arrays.sort(arr);   // 오름차순으로 정렬

        System.out.println((int)sum / 5);   // 평균 출력
        System.out.println(arr[2]);     // 중앙값 출력
    }
}
