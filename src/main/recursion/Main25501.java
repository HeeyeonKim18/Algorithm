package main.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main25501 {
    static int cnt; // 재귀 호출한 횟수를 카운트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 입력 받기

        String s;
        for (int i = 0; i < T; i++) {
            s = br.readLine();  // 문자열 입력 받기
            sb.append(isP(s)).append(" ").append(cnt).append("\n"); // 해당 문자열 함수 호출 및 카운트 출력 값 append 하기
        }

        System.out.println(sb); // 출력하기
    }

    private static int isP(String s) {
        cnt = 1;    // 카운트 값 초기화하기
        return recursion(s, 0, s.length() - 1); // 메서드 호출
    }

    private static int recursion(String s, int l, int r) {
        if (l >= r) return 1;   // 앞에서 읽는 값이 뒤에서 읽은 값을 또 읽을 경우 1을 반환
        else if (s.charAt(l) != s.charAt(r)) return 0;  // 앞에서 읽은 인덱스 값과 뒤에서 읽은 인덱스 값이 다르다면 0을 반환
        else {
            cnt++;  // 카운트 값 증가
            return recursion(s, l + 1, r - 1);  // 재귀 호출
        }
    }
}
