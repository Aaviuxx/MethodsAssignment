
// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
// More packages may be imported in the space below

class PostCodeMethod{
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
    * @return: The information that was entered by the customer
    */
    public static String enterCustomerInfo() {
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
        return (Firstname + ", " + Lastname + ", " + city + ", " + address + ", " + Cred + "\n");
        
    }
    
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    
    /* This method checks if the postcode is a real one or not
    * @author: Tony Cheng
    * @param: String address, line - string vars used for storing the postcode and information thats is on the line of the .txt file
    * @return: true if the first three letter of the postcode matches up with any of them in the .txt file
    */
    public static boolean validatePostCode(String line, String address) throws FileNotFoundException{

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
