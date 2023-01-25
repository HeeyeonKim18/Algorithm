package main.array2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2563 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 색종이 수 입력 받기

        boolean[][] board = new boolean[101][101];  // 도화지 크기의 2차원 배열 생성
        int cnt = 0;    // 도화지에 차지하는 부분을 count 해주는 변수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int hor = Integer.parseInt(st.nextToken());     // 가로 시작점
            int var = Integer.parseInt(st.nextToken());     // 세로 시작점

            for (int i = hor; i < hor + 10; i++) {
                for (int j = var; j < var + 10; j++) {
                    board[i][j] = true;     // 색종이가 위치하는 부분은 true값으로 변경
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]) cnt++;     // 해당 배열이 true 값이면 cnt 값 증가
            }
        }
        System.out.println(cnt);    // cnt 출력
    }
}
