public class TicTacToeGame {
    private gameBoard gameBoard;
    private player humanPlayer;
    private player computerPlayer;
    private player currentPlayer;

    public TicTacToeGame(char symbolPlayer1, char symbolPlayer2, int gameMode) {
        gameBoard = new gameBoard();
        humanPlayer = new player(symbolPlayer1);
        if(gameMode == 1) {
            computerPlayer = new player(symbolPlayer2);
        } else {
            symbolPlayer2 = (symbolPlayer1 == 'X') ? 'O' : 'X';
        }
        currentPlayer = humanPlayer;
    }
    public void initializeGame() {
        gameBoard.initializeBoard();
    }

    public void playGame() {
        boolean gameEnded = false;
        while (!gameEnded) {
            gameBoard.displayBoard();
            currentPlayer.makeMove(gameBoard);
            if (gameBoard.checkForCShape()) {
                System.out.println("Meow! 🐱");
                break; // End the game
            }
            if(gameBoard.checkForWin()) {
                gameEnded = true;
                displayResults(currentPlayer);
            } else if (gameBoard.isBoardFull()) {
                gameEnded = true;
                displayResults(null);
            } else {
                switchPlayer();
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == humanPlayer) ? computerPlayer : humanPlayer;
    }

    private void displayResults(player winner) {
        gameBoard.displayBoard();
        if(winner == null) {
            System.out.println("The game is a draw.");
        } else {
            System.out.println("Player: " + winner.getSymbol() + " wins!");
        }
    }
}
