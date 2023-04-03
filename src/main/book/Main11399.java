package main.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // N 데이터 삽입

        int[] arr = new int[N];   // 배열 선언
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // 입력 값 저장
        }

        for (int i = 1; i < N; i++) {   // 삽입 정렬
            int val = arr[i];
            int j = i - 1;

            // j값이 0보다 작거나 arr[j] 값이 현재 arr[i] 값보다 작거나 같다면 반복문 종료
            while (j >= 0 && arr[j] > val) {
                // 반복해서 데이터 변경
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = val;
        }

        int sum = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {   // 총합 구하기
            sum += arr[i];
            result += sum;
        }
        System.out.println(result);
    }
}
