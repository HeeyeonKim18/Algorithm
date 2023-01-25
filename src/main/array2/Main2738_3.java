package main.array2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 메모리나 시간 측면에서 가장 좋았던 코드
 *
 * 문자를 하나씩 입력 받기 보단 한 줄씩 입력받고 출력하는 것이
 * 성능면에서 유리했다.
 */

public class Main2738_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        int k = 0;
        while (k++ < 2) {
            for (int i = 0; i < N; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    arr[i][j] += Integer.parseInt(st1.nextToken());
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
