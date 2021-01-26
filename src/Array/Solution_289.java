package Array;

public class Solution_289 {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    int countNeighbors = countLiveNeighbors(board, i, j);
                    if (countNeighbors == 3) {
                        board[i][j] = 2;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    int countNeighbors = countLiveNeighbors(board, i, j);
                    if (countNeighbors < 2) {
                        board[i][j] = -1;
                    } else if (countNeighbors == 3 || countNeighbors == 2) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int i, int j) {
        int counter = cellValue(board, i - 1, j - 1)
                + cellValue(board, i - 1, j)
                + cellValue(board, i - 1, j + 1)
                + cellValue(board, i, j + 1)
                + + cellValue(board, i + 1, j + 1)
                + cellValue(board, i + 1, j)
                + cellValue(board, i + 1, j - 1)
                + cellValue(board, i, j - 1);
        return counter;
    }

    private int cellValue(int[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) return 0;
        if (board[i][j] > 1) return 0;
        if (board[i][j] == -1) return 1;
        return board[i][j];
    }
}
