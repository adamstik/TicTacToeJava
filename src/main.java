import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        boolean playAgain;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Welcome to Tic Tac Toe!");
            System.out.println("Choose game mode: \n1. Player vs Player\n2. Player vs Computer");
            int choice = scanner.nextInt();

            char symbolPlayer1 = chooseSymbol(scanner, "Player 1", '\0');
            char symbolPlayer2 = (choice == 1) ? chooseSymbol(scanner, "Player 2", symbolPlayer1) : 'O';


            TicTacToeGame game = new TicTacToeGame(symbolPlayer1, symbolPlayer2, choice);
            game.initializeGame();
            game.playGame();

            System.out.println("Do you want to play again? (yes/no)");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);

    }
    private static char chooseSymbol(Scanner scanner, String playerName, char otherPlayerSymbol) {
        char symbol;
        do {
            System.out.println(playerName + ", choose your symbol (X/O):");
            symbol = scanner.next().toUpperCase().charAt(0);

            if (symbol == otherPlayerSymbol) {
                System.out.println("This symbol is already taken by the other player. Please choose a different symbol.");
            }
        } while (symbol != 'X' && symbol != 'O'|| symbol == otherPlayerSymbol);
        return symbol;
    }
}
