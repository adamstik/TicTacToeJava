import java.util.Scanner;

public class player {
    private char symbol;
    private Scanner scanner;


    public player(char symbol) {
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    public char getSymbol() {
        return symbol;
    }

    public void makeMove(gameBoard board) {
        int row, col;
        do {
            System.out.println("Player " + symbol + ", enter row (0, 1, 2) for your move: ");
            row = scanner.nextInt();
            System.out.println("Player " + symbol + ", enter column (0, 1, 2) for your move: ");
            col = scanner.nextInt();

            // Check if the chosen cell is within the board and empty
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board.isCellEmpty(row, col)) {
                board.makeMove(row, col, symbol);
                break;
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        } while (true);

    }
}
