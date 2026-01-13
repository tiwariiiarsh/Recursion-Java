package arsh.java.recursion;

public class sudokusolver {

    public static void main(String[] args) {

        // 0 represents empty cells in Sudoku
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        // Try solving the Sudoku
        if (solve(board)) {
            // If solved, print the board
            display(board);
        } else {
            // If not solvable
            System.out.println("Cannot solve");
        }
    }

    // Recursive function to solve Sudoku using backtracking
    static boolean solve(int[][] board) {

        int n = board.length;

        // Variables to store row and column of an empty cell
        int row = -1;
        int col = -1;

        // Flag to check if any empty cell is left
        boolean emptyLeft = false;

        // STEP 1: Find the first empty cell (value 0)
        for (int i = 0; i < n; i++) {           // loop through rows
            for (int j = 0; j < n; j++) {       // loop through columns
                if (board[i][j] == 0) {         // empty cell found
                    row = i;                    // store row index
                    col = j;                    // store column index
                    emptyLeft = true;           // mark empty found
                    break;                      // break inner loop
                }
            }
            // If empty cell found, break outer loop too
            if (emptyLeft) {
                break;
            }
        }

        // STEP 2: If no empty cell is left, Sudoku is solved
        if (!emptyLeft) {
            return true;
        }

        // STEP 3: Try numbers 1 to 9 in the empty cell
        for (int number = 1; number <= 9; number++) {

            // Check if placing this number is safe
            if (isSafe(board, row, col, number)) {

                // Place the number in the empty cell
                board[row][col] = number;

                // STEP 4: Recursively solve the remaining board
                if (solve(board)) {
                    // If recursive call returns true, solution is found
                    return true;
                } else {
                    // STEP 5: Backtrack (undo the change)
                    board[row][col] = 0;
                }
            }
        }

        // If no number fits, return false (dead end)
        return false;
    }

    // Function to print the Sudoku board
    private static void display(int[][] board) {
        for (int[] row : board) {           // loop through rows
            for (int num : row) {           // loop through columns
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Function to check whether placing a number is safe
    static boolean isSafe(int[][] board, int row, int col, int num) {

        // Check if number already exists in the same row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check if number already exists in the same column
        for (int[] nums : board) {
            if (nums[col] == num) {
                return false;
            }
        }

        // Check in the 3x3 subgrid
        int sqrt = (int) Math.sqrt(board.length); // sqrt(9) = 3
        int rowStart = row - row % sqrt;          // top-left row of subgrid
        int colStart = col - col % sqrt;          // top-left column of subgrid

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        // Safe to place number
        return true;
    }
}
