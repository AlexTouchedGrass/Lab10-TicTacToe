import java.util.Scanner;

public class Game {

    //Helper Methods
    public static void clearBoard(){
        InputHelper.clearBoard();
    }
    private static void displayBoard(){InputHelper.printBoard();}
    private static boolean isValidMove(int row, int col){
        boolean tof = false;



        return tof;
    }
    private static boolean isWin(String player){
        boolean tof = false;

        return tof;
    }
    private static boolean isColWin(String player){
        boolean tof = false;

        return tof;
    }
    private static boolean isRowWin(String player){
        boolean tof = false;

        return tof;
    }
    private static boolean isDiagonalWin(String player){
        boolean tof = false;

        return tof;
    }
    private static boolean isTie(){
        boolean tof = false;

        return tof;
    }

    //MAIN
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //Scanner

        //Input Helper
        InputHelper.getPrettyHeader();
        //Variables
        String player1 = "";
        String player2 = "";
        boolean allDone = false;


        //This will hold the entire loop of the game itself.
        do {
            boolean doneStart = false;
            boolean donePlay = false;

            //THIS DO WHILE DECIDES WHO IS X's and O's
            do {
                String check = "";
                System.out.println("\nPlayer 1 is X's and Player 2 is O's.");
                System.out.println("Please enter 1 or 2 to decide who goes first, 1 for X's and 2 for O's.");
                check = scan.nextLine();
                if (check.equalsIgnoreCase("X") ) {
                    System.out.println("Player 1 will be X's.\nPlayer 2 will be O's");
                    doneStart = true;
                    player1 = "X";
                    player2 = "O";
                } else if (check.equalsIgnoreCase("O")){
                    System.out.println("Player 1 will be O's.\nPlayer 2 will be X's.");
                    doneStart = true;
                    player1 = "O";
                    player2 = "X";
                } else {
                    System.out.println("That is not an X or an O, try again.");
                }
            } while(!doneStart);

            //Start of a game.
            displayBoard();

        } while (!allDone);

    }
}
