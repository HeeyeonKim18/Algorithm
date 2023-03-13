package main.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888 {
    static int N;   // 입력 받을 숫자 개수
    static int[] number;
    static int[] operator = new int[4]; // 연산자 배열 생성
    static int max = Integer.MIN_VALUE; // 최고값
    static int min = Integer.MAX_VALUE; // 최소값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 숫자 개수

        number = new int[N];    // 배열 생성 및 초기화
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(st.nextToken());   // 연산할 숫자 입력
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken()); // 연산자 개수 입력
        }

        // 메서드 실행
        dfs(number[0], 1);

        // 최대, 최소 값 출력
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int dep) {
        if (dep == N) { // 최대 깊이와 총 수의 개수와 동일하다면?
            max = Math.max(max, num);   // 최대값 구하기
            min = Math.min(min, num);   // 최소값 구하기
            return;
        }

        for (int i = 0; i < 4; i++) {   // 네 개의 연산자 반복문 돌리기
            if (operator[i] > 0) {  // 연산자 배열의 값이 0보다 크다면?
                operator[i]--; // 배열 값 감소

                switch (i) {
                    case 0:     // 덧셈
                        dfs(num + number[dep], dep + 1);
                        break;
                    case 1:     // 뺄셈
                        dfs(num - number[dep], dep + 1);
                        break;
                    case 2:     // 곱셈
                        dfs(num * number[dep], dep + 1);
                        break;
                    case 3:     // 나눗셈
                        dfs(num / number[dep], dep + 1);
                        break;
                }
                operator[i]++;  // 재귀 호출 후에 연산자 값 복구시키기
            }
        }
    }
}
