// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray

import java.util.Scanner;
// More packages may be imported in the space below
import java.io.BufferedReader;
import java.io.File; 
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.PrintWriter;
import java.io.FileNotFoundException;

class CustomerSystem {
    static String nameFirst;
    static String nameLast;
    static String city;
    static String address;
    static String numCred;
    static String line;

    public static void main(String[] args) throws FileNotFoundException {
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
   
    /**
     * Asks user for information and asks for reinput if input is invalid
     * 
     * @author Tony Cheng
     * @throws FileNotFoundException
     */
    public static void enterCustomerInfo() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Your Information as below: ");
        System.out.print("First Name: ");
        nameFirst = scanner.nextLine();
        System.out.print("Last Name: ");
        nameLast = scanner.nextLine();
        System.out.print("City: ");
        city = scanner.nextLine();
        System.out.print("Address: ");
        boolean isAddressValid = false;
        while (!isAddressValid) {
            address = scanner.nextLine();
            isAddressValid = validatePostCode(address, line);
            if (isAddressValid) {
                break;
            } 
            else {
                System.out.println("Please enter a valid address!");
            }
        }
        System.out.println("Credit Card Number: ");
        boolean isCreditValid = false;
        while (!isCreditValid) {
            numCred = scanner.nextLine();
            isCreditValid = validateCreditCard(numCred);
            if (isCreditValid) {
                break;
            } 
            else {
                System.out.println("Please enter a valid credit card number!");
            }
        }
        scanner.close();
    }

    /**
     * THis method checks if the postal code is valid or not
     * 
     * @author Tony Cheng
     * @param address String address, line - string vars used for storing the postcode and information thats is on the line of the .txt file
     * @param line true if the first three letter of the postcode matches up with any of them in the .txt file
     * @return true if postal code is valid, false if it is not
     */
    public static boolean validatePostCode(String address, String line) throws FileNotFoundException{
        //reading though the postcode and checking how long the string is 
        int lenPost = address.length();

        //finding the space of the postcode and splicing the string there so that the code can check the first 3 characters to see if they are real or not
        String addresplice = (address);
        String postsplice = addresplice.substring(0,4);

        //Stating the scanner and telling the scanner which file to read
        var fileName = "Post_Code.txt";            //The file is .txt because I changed it on my end since .cvs was not working for me
        File text = new File (fileName);
        Scanner scnr = new Scanner(text);
        scnr.close();

        //setting the starting line number for the file reader
        int lineNumber = 1;

        // if the length is over or equal 3 characters then run the checking processe
        if (lenPost >= 3){

            //look though the .txt file
            while(scnr.hasNextLine()){
            line = scnr.nextLine();
            lineNumber++;
            }

        }
        //a boolean comparison to see if any of the lines contain the information the user entered in
        while(line != null){
            if (line.contains(postsplice)){
                return true;
            }
        }
        // if not then return
        return false;
    }
    
    /**
     * Validates Credit Card number 
     * 
     * @author Ayeh
     * @param numCred credit card number inputted in enterCustomerInfo
     * @return true if credit card number is valid, false if it is not
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

    /**
     * Generates a new file to store customer information and assigns a unique ID number starting from 1
     * 
     * @Ayeh
     */
    public static void generateCustomerDataFile(){
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