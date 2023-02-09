package main.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // N명의 수
        int[][] arr = new int[N][2];    // 2차원 배열 생성

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());   // 몸무게
            arr[i][1] = Integer.parseInt(st.nextToken());   // 키
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;   // 순위 매기기
            for (int j = 0; j < N; j++) {
                if (arr[i][0] == arr[j][0]) continue;   // 몸무게가 같다면, for문 continue

                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) // 다른 사람보다 몸무게가 많고 키가 크다면?
                    rank++; // rank 증가
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb); // 출력하기
    }
}
