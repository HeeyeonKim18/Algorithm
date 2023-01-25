package main.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10757 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String str1 = st.nextToken();   // 숫자 1
        String str2 = st.nextToken();   // 숫자 2

        int max_length = Math.max(str1.length(), str2.length()); // 숫자1,2 중 길이가 더 긴 것 변수에 저장

        int[] A = new int[max_length + 1]; // 마지막 자리수에 올림이 있을 수 있으니 가장 긴 길이보다 하나 더 크게
        int[] B = new int[max_length + 1];

        // A 초기화, 숫자 거꾸로 배치하기
        for (int i = str1.length() - 1, j = 0; i >= 0; i--, j++) {
            A[j] = str1.charAt(i) - '0';
        }

        // B 초기화, 숫자 거꾸로 배치하기
        for (int i = str2.length()- 1, j = 0; i >= 0; i--, j++) {
            B[j] = str2.charAt(i) - '0';
        }

        // A와 B를 더하고 나머지 값은 자리수에 넣어주고, 더한 값이 10을 넘는다면 다음 자릿수에 1 더해주기
        for (int i = 0; i < max_length; i++) {
            int value = A[i] + B[i];
            A[i] = value % 10;
            A[i + 1] += (value / 10);
        }

        StringBuilder sb = new StringBuilder();
        // 가장 큰 자릿수가 0일수도 있으니 아니면 출력하도록 조건문 설정
        if (A[max_length] != 0) sb.append(A[max_length]);

        // 역순으로 반복하여 sb에 더하기
        for (int i = max_length - 1; i >= 0; i--) {
            sb.append(A[i]);
        }

        // 출력
        System.out.println(sb);
    }
}
