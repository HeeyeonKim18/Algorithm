package main.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 입력 값 개수

        long[] a = new long[N]; // long 타입 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(st.nextToken());  // 배열에 입력 값 저장
        }

        Arrays.sort(a); // 정렬

        int cnt = 0;    // 카운트
        for (int i = 0; i < N; i++) {
            long present = a[i];    // 판별 대상이 되는 수
            int s_idx = 0;  // 시작 인덱스
            int e_idx = N - 1;    // 끝 인덱스

            while (s_idx < e_idx) {   // s와 i 인덱스가 겹치지 않을 때
                if (a[s_idx] + a[e_idx] == present) { // 합계가 대상이 되는 수와 같다면?
                    if (s_idx != i && e_idx != i) {   // 인덱스의 값이 대상이 되는 수의 인덱스와 같지 않다면(합계가 자신의 값을 포함하면 안됨)
                        cnt++;
                        break;
                    } else if (s_idx == i) {
                        s_idx++;
                    } else if (e_idx == i) {
                        e_idx--;
                    }
                } else if (a[s_idx] + a[e_idx] < present) { // 합계가 대상 수보다 작을 때
                    s_idx++;
                } else   // 합계가 대상 수보다 클 때
                    e_idx--;
            }
        }
        System.out.println(cnt);    // 출력
    }
}
