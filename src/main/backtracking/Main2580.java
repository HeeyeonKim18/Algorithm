package main.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2580 {
    static int[][] board = new int[9][9];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (sudoku()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }
    }

    private static boolean sudoku() {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int i = 1; i <= 9; i++) {
                        if (isPossible(row, col, i)) {
                            board[row][col] = i;
                            if (sudoku()) {
                                return true;
                            } else {
                                board[row][col] = 0;
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean isPossible(int row, int col, int val) {

        // col 검사
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val)
                return false;
        }

        // row 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val)
                return false;
        }

        int row_set = row - row % 3;
        int col_set = col - col % 3;

        for (int i = row_set; i < row_set + 3; i++) {
            for (int j = col_set; j < col_set + 3; j++) {
                if (board[i][j] == val)
                    return false;
            }
        }
        return true;
    }
}
