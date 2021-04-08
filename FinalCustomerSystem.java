// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.Scanner;
// More packages may be imported in the space below
import java.io.BufferedReader;
import java.io.File; 
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.PrintWriter;

class DownloadedCustomerSystem {
    static String nameFirst;
    static String nameLast;
    static String city;
    static String address;
    static String numCred;

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
                // Only the line below may be edited based on the parameter list and how you design the method return
		        // Any necessary variables may be added to this if section, but nowhere else in the code
                enterCustomerInfo();
            }
            else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be edited based on the parameter list and how you design the method return
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
    * The method may not necessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void enterCustomerInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Your Information as below: ");
        System.out.println("First Name: ");
        nameFirst = scanner.nextLine();
        System.out.print("Last Name: ");
        nameLast = scanner.nextLine();
        System.out.print("City: ");
        city = scanner.nextLine();
        System.out.println("Address: ");
        address = scanner.nextLine();

        System.out.println("Credit Card Number: ");
        boolean isCreditValid = false;
        while (!isCreditValid) {
            numCred = scanner.nextLine();
            isCreditValid = validateCreditCard(numCred);
            if (isCreditValid) {
                break;
            } else {
                System.out.println("Please enter a valid credit card number!");
            }
        }
        scanner.close();
    }

    /*
    * This method may be edited to achieve the task however you like.
    * The method may not necessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validatePostalCode(){
        System.out.println("validatePostalCode");
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not necessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */

    public static boolean validateCreditCard(String numCred){
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
                // adding to total
                sumCred += d / 10;
                sumCred += d % 10;            
                evenDigit = !evenDigit; // returns value to an 'odd digit' every other number
            }
            // returns true or false based on if number is divisible by 10 or not
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
        System.out.println(nameFirst);
        // F I L E   C R E A T I O N 
        File file = new File("CustomerDataFile.csv");
        try {
            if(file.exists() == false) { // if this file already exists on the device, it will be edited 
                System.out.println("A new file named 'CustomerDataFile.csv' is created.");
                file.createNewFile(); // otherwise, it will create a new file 
            }

            int num;

            // I D   A S S I G N E D
            if (file.length() == 0) { // if file is empty,
                num = 1; // the id will begin at 1
            } else { //otherwise
                BufferedReader reader = new BufferedReader(new FileReader(file)); //this file will be read
                String sCurrentLine;
                String last = "";

                // the last line will be read
                while ((sCurrentLine = reader.readLine()) != null) {
                    last = sCurrentLine;
                }
                last = last.substring(0, 1); // the first letter (in this case, the id number) will be read        
                num = Integer.parseInt(last) + 1; // and one will be added to it 
                reader.close();
            }

            // I N F O R M A T I O N    S E N T    T O    F I L E
            String info = nameFirst + ", " + nameLast + ", " + city + ", " + address + ", " + numCred;
            PrintWriter writer = new PrintWriter(new FileWriter(file, true)); // the file will be read
            writer.append(num + ", " + info + "\n"); //inputted information will be uploaded to csv file
            writer.close(); // ^ sends information to .csv file
        }
        catch (Exception e) { // detects and prints errors
            System.out.println("Error:" + e);
        }
    }
}