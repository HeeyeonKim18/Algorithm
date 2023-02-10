package main.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 체스판 다시 칠하기
public class Main1018 {
    static boolean[][] arr; // 2차원 배열 생성, X와 Y값 입력받고 저장할 배열
    static int min = 64; // 최소값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   // X값
        int M = Integer.parseInt(st.nextToken());   // Y값

        arr = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'B')  // 입력값이 블랙이라면?
                    arr[i][j] = true;   // true값을
                else arr[i][j] = false; // 화이트라면 false값 설정
            }
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                find(i, j); // 메서드 실행
            }
        }
        System.out.println(min);
    }

    private static void find(int a, int b) {
        int x = a + 8;
        int y = b + 8;
        int count = 0;  // 최소값을 찾을 변수

        boolean color = arr[a][b];  // 시작 값이 true인지, false인지 알기 위한 변수
        for (int i = a; i < x; i++) {
            for (int j = b; j < y; j++) {
                if (arr[i][j] != color)
                    count++;

                color = !color;
            }
            color = !color;
        }
        count = Math.min(count, 64 - count);

        min = Math.min(min, count);
    }
}
