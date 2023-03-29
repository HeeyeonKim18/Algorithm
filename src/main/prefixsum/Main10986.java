package main.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   // 입력 받을 N개의 수
        int M = Integer.parseInt(st.nextToken());   // 나누어 떨어져야 하는 수
        long[] s = new long[N + 1]; // 합 배열
        long[] c = new long[M]; // 나머지
        long answer = 0;    // 구간의 개수 저장

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            s[i] = s[i - 1] + Integer.parseInt(st.nextToken()); // 합 배열로 저장
        }

        for (int i = 1; i <= N; i++) {
            int mod = (int) (s[i] % M); // 합 배열을 M으로 나눈 나머지 저장
            if (mod == 0) answer++; // 나머지가 0이라면 출력 값 변수 1증가
            c[mod]++;   // 나머지 개수 저장할 배열도 1 증가
        }

        for (int i = 0; i < M; i++) {
            if (c[i] > 1) {
                answer = answer + (c[i] * (c[i] - 1) / 2);  // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 모두 더하기
            }
        }
        System.out.println(answer); // 출력
    }
}
