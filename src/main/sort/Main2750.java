package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 삽입 정렬
 */
public class Main2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 입력 받는 수의 개수

        int[] arr = new int[N]; // 배열 생성

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());   // 배열에 수를 입력하기
        }

        for(int i = 1; i < arr.length; i++){
            int val = arr[i];
            int j = i -1;

            while(j >= 0 && arr[j] > val){
                arr[j+1] = arr[j];
                j = j -1;
            }
            arr[j+1] = val;
        }
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]); // 출력하기
    }
}
