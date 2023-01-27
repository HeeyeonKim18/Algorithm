package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main10814_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][2];  // 2차원 배열 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = st.nextToken(); // 나이값 입력 받기
            arr[i][1] = st.nextToken(); // 이름 입력 받기
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> Integer.parseInt(a[0]))); // 나이값으로 정렬하기

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");    // 모든 문자 더하기
        }
        System.out.println(sb); // 출력하기

    }
}
