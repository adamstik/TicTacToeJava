public class gameBoard {
    private char[][] board;

    public gameBoard() {
        board = new char[3][3];
        initializeBoard();
    }
    public void initializeBoard() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < 2) {
                    System.out.print("|"); // Print vertical divider
                }
            }
            System.out.println(); // Move to the next line after each row
            if (i < 2) {
                System.out.println("---+---+---"); // Print horizontal divider
            }
        }
    }

    public boolean checkForWin() {
        // Check all rows for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
        }
        // Check all columns for a win
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
                return true; // Winning condition for a column
            }
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true; // Winning condition for one diagonal
        }

        // Check diagonal (top-right to bottom-left)
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true; // Winning condition for the other diagonal
        }

        // No win condition was met
        return false;
    }
    public void makeMove(int row, int column, char symbol) {
        board[row][column] = symbol;
    }

    public boolean isCellEmpty(int row, int column) {
        if(board[row][column] == ' ') {
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        boolean answer = false;
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return answer = true;
    }

    public boolean checkForCShape() {
        return board[0][0] != ' ' && board[1][0] != ' ' && board[2][0] != ' ' &&
                board[0][1] != ' ' && board[0][2] != ' ' &&
                board[2][1] != ' ' && board[2][2] != ' ';
    }
}
