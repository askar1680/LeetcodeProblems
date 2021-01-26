package DFS;

public class Solution_130 {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;

        int rows = board.length;
        int columns = board[0].length;

        for (int i = 0; i < rows; i++)  {
            if (board[i][0] == 'O') dfsBoundary(board, i, 0);
            if (board[i][columns - 1] == 'O') dfsBoundary(board, i, columns - 1);
        }

        for (int j = 0; j < columns;  j++) {
            if (board[0][j] == 'O') dfsBoundary(board, 0, j);
            if (board[rows - 1][j] == 'O') dfsBoundary(board, rows - 1, j);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    private void dfsBoundary(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length - 1) return;

        board[i][j] = '*';
        if (i > 0 && board[i - 1][j] == 'O')
            dfsBoundary(board, i - 1, j);

        if (i < board.length - 1 && board[i + 1][j] == 'O')
            dfsBoundary(board, i + 1, j);

        if (j > 0 && board[i][j - 1] == 'O')
            dfsBoundary(board, i, j - 1);

        if (j < board[i].length - 1 && board[i][j + 1] == 'O')
            dfsBoundary(board, i, j + 1);
    }
}
