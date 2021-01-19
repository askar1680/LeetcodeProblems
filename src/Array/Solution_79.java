package Array;

public class Solution_79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean found = dfs(
                            word,
                            0,
                            board,
                            i, j
                    );
                    if (found) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(
            String word,
            int position,
            char[][] board,
            int row, int col
    ) {
        if (position == word.length()) return true;
        char ch = word.charAt(position);

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || ch != board[row][col])
            return false;

        char boardValue = board[row][col];
        board[row][col] = ' ';
        boolean found = dfs(word, position + 1, board, row + 1, col)
                || dfs(word, position + 1, board, row - 1, col)
                || dfs(word, position + 1, board, row, col + 1)
                || dfs(word, position + 1, board, row, col - 1);

        board[row][col] = boardValue;
        return found;
    }
}
