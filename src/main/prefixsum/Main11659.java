package main.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());   // 숫자의 개수
        int m = Integer.parseInt(st.nextToken());   // 누적합 할 범위 개수

        int[] arr = new int[n + 1]; // 배열 생성

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {  // 1부터 입력 받도록 반복문 설정
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());   // 이전 값과 입력 값이 더해져 해당 인덱스에 저장되도록 함
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());    // 누적합 시작 지점
            int to = Integer.parseInt(st.nextToken());      // 누적합 마지막 지점

            // 누적합 마지막 지점 인덱스의 값은 인덱스 1 ~ to 까지의 누적합으로 시작 지점 이전 누적합을 빼주면 된다!
            sb.append(arr[to] - arr[from - 1]).append("\n");
        }
        System.out.println(sb); // 출력
    }
}
