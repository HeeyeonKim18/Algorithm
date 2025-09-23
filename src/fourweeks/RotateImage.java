package fourweeks;

public class RotateImage {
    public static void main(String[] args) {
        int[][] ex1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(ex1);
    }

    private static void rotate(int[][] matrix) {
        // row -> col 으로 전치
        int len = matrix[0].length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 테이블을 뒤집기(좌우 반전)
        int s = 0;
        int e = len - 1;
        while (s < e) {
            for (int i = 0; i < len; i++) {
                int temp = matrix[i][s];
                matrix[i][s] = matrix[i][e];
                matrix[i][e] = temp;
            }

            s++;
            e--;
        }
    }
}
