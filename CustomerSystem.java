// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.Scanner;
// More packages may be imported in the space below

class CustomerSystem{
    public static void main(String[] args){
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // THINGS FOR CREDIT CARD VALIDATION (will probably be moved somewhere different once the other methods are ready)
        System.out.println("input your credit card number:"); // ask for credit card number
        String numCred = reader.nextLine();
        if (validateCreditCard(numCred)) {
            System.out.println("This credit card is valid.");
        }
        else {
            System.out.println("This credit card is invalid.");
        }

        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(enterCustomerOption)){
                // Only the line below may be editted based on the parameter list and how you design the method return
		        // Any necessary variables may be added to this if section, but nowhere else in the code
                enterCustomerInfo();
            }
            else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
                generateCustomerDataFile();
            }
            else{
                System.out.println("Please type in a valid option (A number from 1-9)");
            }

        } while (!userInput.equals(exitCondition));         // Exits once the user types 
        
        reader.close();
        System.out.println("Program Terminated");
    }
    public static void printMenu(){
        System.out.println("Customer and Sales System\n"
        .concat("1. Enter Customer Information\n")
        .concat("2. Generate Customer data file\n")
        .concat("3. Report on total Sales (Not done in this part)\n")
        .concat("4. Check for fraud in sales data (Not done in this part)\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void enterCustomerInfo() {
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validatePostalCode(){
    }

    /**
     * Determines whether credit card number is valid or not, using the Luhn check
     * 
     * @author - Ayeh Fartousi
     * @param numCred - the inputted credit card number
     * @return - true if sum ends with a zero (divisible by ten) and false if not
     */
    static boolean validateCreditCard(String numCred) {
        int lenCred = numCred.length(); // length of the credit card number is found
        if (lenCred >= 9) { // if credit card number length is sufficient, code will play
            int sumCred = 0; // sum is preset to zero
            boolean evenDigit = false; // the boolean of odd/even is set to false because it starts at an odd num
            
            for (int i = lenCred - 1; i >= 0; i--) { // goes through the inputted numbers *backwards*
        
                int d = Integer.parseInt(numCred.substring(i, i + 1)); // reverses order of digits
        
                if (evenDigit == true) { // if the number is even
                    d = d * 2;  // it is doubled and added together
                    // LENGTH OF DIGIT
                    int lenDigit = String.valueOf(d).length();
                    if (lenDigit > 1) { // if there are more than 1 digits in a number
                        d = d - 10 + 1; // subtracts 10 from 2 digit numbers to retrieve second digit, and adds 1, which is always going to be the first digit
                    }
                } 
                evenDigit = !evenDigit; // returns value to an 'odd digit' every other number
            }
            return (sumCred % 10 == 0);
        }

        else { // if credit card number is shorter than 9 digits,
            return false; //it is invalid
        }
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void generateCustomerDataFile(){
    }
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/
}