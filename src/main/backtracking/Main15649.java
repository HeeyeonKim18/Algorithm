package main.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15649 {
    static int[] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());   // n 입력 받기(1부터 n까지의 자연수)
        int m = Integer.parseInt(st.nextToken());   // m 입력 받기(수열의 길이)

        arr = new int[m];   // m의 길이 만큼 배열 생성
        check = new boolean[n]; // 방문 여부를 판단하는 배열 생성

        dfs(n, m, 0);   // 메서드 실행

        System.out.println(sb); // 출력하기
    }

    /**
     * 베이스 케이스: 깊이와 출력하려는 수열의 길이가 같다면 출력하려는 문자를 저장하고 Return;
     *
     * 조건문을 실행하여 방문 하지 않은 노드라면, 배열에 해당 값 추가 & depth 값 증가해서 재귀 함수 호출
     */
    private static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[depth] = i + 1;
                dfs(n, m, depth + 1);
                check[i] = false;   // 방문 여부 다시 초기화
            }
        }
    }
}
