
// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
// More packages may be imported in the space below

class Method{
    public static void main(String[] args){
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // More variables for the main may be declared in the space below


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
    /* This method stores all the info used for the later methods
    * @author: Tony Cheng
    * @param: String address,name,Cred,city - string vars usssed to store the information
    *
    */
    public static void enterCustomerInfo() {
        String address,Firstname,Cred,city,Lastname;
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please enter your First name: ");
        Firstname = scnr.nextLine();
        System.out.print("Please enter your lastname: ");
        Lastname = scnr.nextLine();
        System.out.print("Please enter your city name: ");
        city = scnr.nextLine();
        System.out.print("Please enter your postcode: ");
        address = scnr.nextLine();
        System.out.print("Please enter your creditcard information: ");
        Cred = scnr.nextLine();
        scnr.close();

    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */

    //Checks for a space in the postcode so it can be broken down
       // @author: Tony Cheng
       // @param: lenPost - the input from the user stating their postcode
       // @return: i - where the space is located 
    public static int validatePostalCode(String address){
        int lenPost = address.length();
        for(int i = 0; i < lenPost; i++){
            if(address.charAt(i) == ' '){
                return i;
            }
        }
        return 0;
    }
    /*Convert the string in to a number that I can use
    *@author: Tony Cheng
    *@param: address - a string containing a letter at the start followed by a number endding on a letter
    *@return: num - the index of the blank space
    */
    public static int readPostNum(String address, int loc){
        String post = address.substring(0,loc);
        int num = Interger.parseInt(post);
        return num;
    }

    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validateCreditCard(){
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void generateCustomerDataFile(){
    
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/
}

}
