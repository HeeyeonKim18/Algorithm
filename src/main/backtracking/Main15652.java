package main.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15652 {
    static int N, M;    // 전역 변수로 N, M 생성
    static int[] arr;   // 배열 생성
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 입력 값
        M = Integer.parseInt(st.nextToken());   // 입력 값

        arr = new int[M];   // 배열 초기화

        dfs(1, 0);

        System.out.println(sb); // 출력하기

    }

    private static void dfs(int at, int dep) {  // at: 시작 값, dep: 깊이
        if (dep == M) {   // 깊이 값과 찾고자 하는 수의 길이가 같다면, 출력하기
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {   // 1 ~ N 까지 반복문
            arr[dep] = i;   // 배열에 i 값 저장하기

            dfs(i, dep + 1); // 시작 값으로 i를 그대로 넘겨줘서 비내림차순 되게끔하기
        }
    }
}
