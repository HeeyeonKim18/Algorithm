package fourweeks;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] sudoku = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(isValidSudoku(sudoku));
        System.out.println(bitMaskVer(sudoku));
    }

    private static boolean isValidSudoku(char[][] sudoku) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = sudoku[i][j];
                if (val == '.')
                    continue;

                String rowKey = val + " in row " + i;
                String colKey = val + " in column " + j;
                String boxKey = val + " in block " + (i / 3) + "-" + (j / 3);

                if (!set.add(rowKey) || !set.add(colKey) || !set.add(boxKey))
                    return false;
            }
        }
        return true;
    }

    private static boolean bitMaskVer(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.')
                    continue;

                int d = ch - '1'; // 인덱스 범위는 0 ~ 8
                int mask = 1 << d;
                int b = (r / 3) * 3 + (c / 3);

                if ((rows[r] & mask) != 0)
                    return false;
                if ((cols[c] & mask) != 0)
                    return false;
                if ((boxes[b] & mask) != 0)
                    return false;

                rows[r] |= mask;
                cols[c] |= mask;
                boxes[b] |= mask;
            }
        }
        return true;
    }
}
