import java.util.Scanner;

public class InputHelper {
    public static void main(String[] args) {
        //Test Methods
        Scanner scan = new Scanner(System.in);

        //Size Checker
        int iSize = getInt(scan, "Please enter your size (round to nearest whole number)."); //Results are confidential.
        System.out.println("Your size is " + iSize + ".");

        //Double Size Checker
        double dSize = getDouble(scan, "Please enter your size."); //Results are confidential.
        System.out.println("Your size is " + dSize + ".");

        //Range Checker
        int iRange = getRangedInt(scan, "Please enter an int between 1 and 10.", 1, 10);
        System.out.println("Your number is " + iRange + ".");

        //Double Range Checker
        double dRange = getRangedDouble(scan, "Please enter a double between 1 and 10", 1.0, 10.0);
        System.out.println("Your number is " + dRange + ".");

        //Social Security Check
        String ssn = getRegExString(scan, "Please enter your SSN [xxx-xx-xxxx]", "\\d{3}-\\d{2}-\\d{4}");
        System.out.println("Your SSN: " + ssn + ".");

        //Date Of Birth Check
        String dob = getRegExString(scan, "Enter your date of birth [mm.dd.yyyy]", "\\d{2}.\\d{2}.\\d{4}");
        System.out.println("Your date of birth is " + dob + ".");

        //getNonZeroLenString
        String non0Str = getNonZeroLenString(scan, "Enter a string. (Blank space will not work)");
        System.out.println("Your string is " + non0Str + ".");

        //getNonZeroInt
        int non0Int = getNonZeroInt(scan, "Enter an int. (Negatives and 0 are not allowed.)");
        System.out.println("Your string is " + non0Int + ".");

        //Y or N Confirm
        boolean yesOrNo = getYNConfirm(scan, "Would you like to stop? Yes to stop, no to continue. ( Y or N also works)");
        System.exit(0);

    }

    //GetInt
    //This method loops until a valid integer input is received. Returns int value.
    public static int getInt(Scanner in, String prompt) {
        boolean done = false;
        int x = 0;

        System.out.println(prompt);
        do {
            if (in.hasNextInt()) {
                x = in.nextInt();
                done = true;
            }
            in.nextLine(); //buffer
        } while (!done);
        return x;
    }

    //GetDouble
    //This method loops until a valid double input is received. Returns double value.
    public static double getDouble(Scanner in, String prompt) {
        boolean done = false;
        double dGetX = 0;

        System.out.println(prompt);
        do {
            if (in.hasNextDouble()) {
                dGetX = in.nextDouble();
                done = true;
            }
            in.nextLine(); //buffer
        } while (!done);
        return dGetX;
    }

    //Int Ranged
    public static int getRangedInt(Scanner in, String prompt, int min, int max) {
        boolean done = false;
        int x = 0;

        System.out.println(prompt);
        do {
            if (in.hasNextInt()) {
                x = in.nextInt();
                //Check to see if number is in range
                if (x <= max && x >= min) {
                    done = true;
                }
            }
            in.nextLine(); //buffer
        } while (!done);
        return x;
    }

    //RegExString
    public static String getRegExString(Scanner in, String prompt, String regEx) {
        boolean done = false;
        String input;

        System.out.println(prompt);
        do {
            input = in.nextLine();
            if (input.matches(regEx)) {
                done = true;
            } else {
                System.out.println("Invalid Input.");
            }
        } while (!done);
        return input;
    }

    //Double Ranged
    public static double getRangedDouble(Scanner in, String prompt, double min, double max) {
        boolean done = false;
        double dx = 0;

        System.out.println(prompt);
        do {
            if (in.hasNextDouble()) {
                dx = in.nextDouble();
                //Check to see if number is in range
                if (dx <= max && dx >= min) {
                    done = true;
                } else {
                    System.out.println("Invalid Input.");
                }
            }
            in.nextLine();
        } while (!done);
        return dx;
    }

    public static String getNonZeroLenString(Scanner in, String prompt) {
        boolean done = false;
        String input;

        System.out.println(prompt);
        do {
            input = in.nextLine();
            if (input.length() > 0) {
                done = true;
            } else {
                System.out.println("Error. Blank Space Detected.");
            }
            //in.nextLine(); // (NOT NECESSARY ALWAYS, CASE TO CASE BASIS)
        } while (!done);
        return input;
    }

    //Checks that the entered Int is greater than 0 (Only for positive numbers)
    public static int getNonZeroInt(Scanner in, String prompt) {
        boolean done = false;
        int input;

        System.out.println(prompt);
        do {
            input = in.nextInt();
            if (input > 0) {
                done = true;
            } else {
                System.out.println("Error. Either a negative integer or 0 has been entered.");
            }
            in.nextLine();
        } while (!done);
        return input;
    }

    public static boolean getYNConfirm(Scanner in, String prompt) {
        boolean done = false;
        String input;

        //This is the return
        boolean check = false;

        System.out.println(prompt);
        do {
            input = in.nextLine();
            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
                System.out.println("You will continue.");
                done = true;
                check = true;
            } else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
                System.out.println("You will stop.");
                done = true;
            }
            // in.nextLine(); NOT NEEDED 
        } while (!done);
        return check;
    }

    //Pretty Header
    public static void getPrettyHeader(String msg) {
        int leftSpaces = ((54-msg.length())/2);
        int rightSpaces = (54-leftSpaces-msg.length());

        printCharacter("*", 60, true);

        printCharacter("*",3, false);
        printCharacter(" ", leftSpaces, false);
        System.out.print(msg);
        printCharacter(" ", rightSpaces, false);
        printCharacter("*", 3, true);

        printCharacter("*", 60, false);
    }

    //FOR PRETTY HEADER
    public static void printCharacter(String character, int amount, boolean newLine) {
        for (int i = 0; i < amount; i++) {
            System.out.print(character);
        }

        if (newLine) {
            System.out.println();
        }
    }

    //Bold Text
    public static void boldChar(String character, int amount){

    }
}
