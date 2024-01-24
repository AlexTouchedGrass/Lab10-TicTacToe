import java.util.Scanner;
public class Game {
    //Helper Methods
    public static void clearBoard(){

    }

    private static void displayBoard(){
        System.out.print();
    }

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
        String playerX = "X"; //Also player 1
        String playerO = "O"; //Also player 2
        int[] numColumn = new int [3];
        int[] numRow = new int [3];
        boolean done = false;

        do {
            int check = 0;
            System.out.println("\nPlayer 1 is X's and Player 2 is O's.");
            System.out.println("Please enter 1 or 2 to decide who goes first, 1 for X's and 2 for O's.");
            check = scan.nextInt();
            if (check == 1 ) {
                System.out.println("Player 1 (X's) will go first.");
            } else if (check == 2){
                System.out.println("Player 2 (O's) will go first.");
            } else {
                System.out.println("That is not a 1 or a 2, try again.");
            }




        } while(!done);


    }
}