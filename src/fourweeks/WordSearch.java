package fourweeks;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    private static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (findWord(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean findWord(char[][] board, String word, int i, int j, int idx, boolean[][] visited) {
        if (idx == word.length())
            return true; // 단어 끝까지 찾음

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (visited[i][j] || board[i][j] != word.charAt(idx))
            return false;

        visited[i][j] = true;
        boolean found = findWord(board, word, i + 1, j, idx + 1, visited)
                || findWord(board, word, i - 1, j, idx + 1, visited)
                || findWord(board, word, i, j + 1, idx + 1, visited)
                || findWord(board, word, i, j - 1, idx + 1, visited);
        visited[i][j] = false; // 백트래킹: 원복

        return found;
    }
}
