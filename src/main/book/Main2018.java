package main.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int s_idx = 1, e_idx = 1;   // 시작 인덱스와 마지막 인덱스
        int cnt = 1;    // 카운트 (카운트를 1로 초기화하는 이유: 숫자 N만 선택하는 경우 미리 저장)
        int sum = 1;    // 값을 더할 변수

        while (s_idx != N) {
            if (sum > N) {  // 연속합 합계가 N보다 크다면 ?
                sum -= s_idx;
                s_idx++;
            } else {
                if (sum == N) { // 연속합 합계가 N과 동일하다면 ?
                    cnt++;
                }
                e_idx++;    //연속합 합계가 N보다 작다면 ?
                sum += e_idx;
            }
        }
        System.out.println(cnt);    // 출력
    }
}