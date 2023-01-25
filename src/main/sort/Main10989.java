package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];         // 입력 받은 수 배열에 저장
        int[] cntArr = new int[10001];  // 입력 받은 수 카운트 할 배열
        int[] result = new int[N];      // 출력할 배열

        int max = Integer.MIN_VALUE;    // 입력 같은 수 중 가장 큰 수를 담는 변수

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());  // 숫자 입력 받기
            arr[i] = num;   // 배열 arr에 입력 받은 수 넣기
            cntArr[num]++;  // 배열 cntArr은 입력 받은 수를 인덱스로 지정
            max = Math.max(max, num); // 최대값 찾기
        }

        for (int i = 1; i <= max; i++) {
            cntArr[i] += cntArr[i - 1]; // 배열 cntArr 값 거듭해서 제곱해주기
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            cntArr[val]--;
            result[cntArr[val]] = val;  // 배열 result 값에 값 저장하기
        }

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i] + "\n");    // 출력 값 append하기
        }
        System.out.println(sb); // 출력하기
    }
}
