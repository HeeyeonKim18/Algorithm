package main.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 재료의 수
        int M = Integer.parseInt(br.readLine());    // 합계

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // 배열에 값 저장
        }
        Arrays.sort(arr);   // 오름차순 정렬

        int s_idx = 0, e_idx = N - 1;
        int cnt = 0;
        int sum;

        while (s_idx < e_idx) {
            sum = arr[s_idx] + arr[e_idx];
            if (sum == M) { // 합계가 M과 같다면 ?
                cnt++;
                s_idx++;
                e_idx--;
            } else if (sum > M) {   // 합이 M보다 크다면?
                e_idx--;
            } else {    // 합이 M보다 작다면?
                s_idx++;
            }
        }
        System.out.println(cnt);    // 출력
    }
}
