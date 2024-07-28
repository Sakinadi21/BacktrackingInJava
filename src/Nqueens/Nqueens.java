package Nqueens;

public class Nqueens {
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];

        // Initialize the board with 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        // Start solving the N-Queens problem
        nqueen(board, 0);
    }

    // Function to solve N-Queens using backtracking
    private static void nqueen(char[][] board, int row) {
        int n = board.length;

        // If all rows are filled, print the board
        if (row == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        // Try placing the queen in each column of the current row
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';  // Place the queen
                nqueen(board, row + 1);  // Recur to place the queen in the next row
                board[row][j] = 'X';  // Backtrack and remove the queen
            }
        }
    }

    // Function to check if placing a queen at board[row][col] is safe
    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check the current column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check the upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the upper right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
