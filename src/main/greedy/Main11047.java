package main.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 동전 종류 수
        int K = Integer.parseInt(st.nextToken());   // 전체 금액
        int[] list = new int[N];
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(br.readLine());  // 동전 종류 리스트에 담기
        }

        int cnt = 0;    // 동전 수를 카운트할 변수
        for(int i = N-1; i >= 0; i--){
            cnt += K / list[i]; // 전체 금액 / 동전 (큰 값부터)
            K %= list[i];   // 동전 값을 뺀 전체 금액으로
        }
        System.out.println(cnt);    // 출력
    }
}
