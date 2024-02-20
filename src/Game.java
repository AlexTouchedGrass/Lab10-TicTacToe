import java.util.Scanner;

public class Game {

    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static final String[][] gameBoard = new String[ROWS][COLS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main game loop
        while (true) {
            initializeGame();

            // Players choose symbols (X or O) and the cleared board is displayed
            String firstPlayerSymbol = getPlayerSymbol(scanner, 1);
            String secondPlayerSymbol = getPlayerSymbol(scanner, 2);

            // Main game loop
            while (true) {
                makeMove(scanner, firstPlayerSymbol);
                if (isGameFinished(firstPlayerSymbol)) {
                    displayResult(firstPlayerSymbol);
                    break;
                }

                makeMove(scanner, secondPlayerSymbol);
                if (isGameFinished(secondPlayerSymbol)) {
                    displayResult(secondPlayerSymbol);
                    break;
                }
            }

            if (!playAgain(scanner)) {
                break;
            }
        }
    }

    private static void initializeGame() {
        clearGameBoard();
        displayGameBoard();
    }

    private static void clearGameBoard() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[0].length; col++) {
                gameBoard[row][col] = "-";
            }
        }
    }

    private static void displayGameBoard() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[0].length; col++) {
                System.out.print(gameBoard[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static String getPlayerSymbol(Scanner scanner, int playerNumber) {
        while (true) {
            String userInput = InputHelper.getNonZeroLenString(scanner, "Player " + playerNumber + ", choose X or O");
            if (userInput.equalsIgnoreCase("X") || userInput.equalsIgnoreCase("O")) {
                return userInput.toUpperCase();
            } else {
                System.out.println("Invalid input. Please choose X or O.");
            }
        }
    }

    private static void makeMove(Scanner scanner, String playerSymbol) {
        int moveRow, moveCol;
        boolean isValidMove;

        do {
            moveRow = InputHelper.getRangedInt(scanner, "Pick a row for your move", 1, ROWS);
            moveCol = InputHelper.getRangedInt(scanner, "Pick a column for your move", 1, COLS);
            isValidMove = isValidGameMove(moveRow - 1, moveCol - 1);

            if (!isValidMove) {
                System.out.println("That move is already taken");
            }
        } while (!isValidMove);

        gameBoard[moveRow - 1][moveCol - 1] = playerSymbol;
        displayGameBoard();
    }

    private static boolean isValidGameMove(int row, int col) {
        return gameBoard[row][col].equals("-");
    }

    private static boolean isGameFinished(String playerSymbol) {
        return isColWin(playerSymbol) || isRowWin(playerSymbol) || isDiagonalWin(playerSymbol) || isGameTie();
    }

    private static boolean isColWin(String playerSymbol) {
        for (int col = 0; col < COLS; col++) {
            int counter = 0;
            for (int row = 0; row < ROWS; row++) {
                if (gameBoard[row][col].equals(playerSymbol)) {
                    counter++;
                }
                if (counter == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isRowWin(String playerSymbol) {
        for (int row = 0; row < ROWS; row++) {
            int counter = 0;
            for (int col = 0; col < COLS; col++) {
                if (gameBoard[row][col].equals(playerSymbol)) {
                    counter++;
                }
                if (counter == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String playerSymbol) {
        return (gameBoard[0][0].equals(playerSymbol) && gameBoard[2][2].equals(playerSymbol) && gameBoard[1][1].equals(playerSymbol))
                || (gameBoard[2][0].equals(playerSymbol) && gameBoard[0][2].equals(playerSymbol) && gameBoard[1][1].equals(playerSymbol));
    }

    private static boolean isGameTie() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (gameBoard[row][col].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void displayResult(String playerSymbol) {
        if (isGameTie()) {
            System.out.println("It's a Tie!");
        } else {
            System.out.println("Player with symbol " + playerSymbol + " Wins!");
        }
    }

    private static boolean playAgain(Scanner scanner) {
        return InputHelper.getYNConfirm(scanner, "Would you like to play again? (Y/N)");
    }
}
