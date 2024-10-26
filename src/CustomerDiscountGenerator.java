/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author reg05
 */
import java.io.BufferedReader;//Imports BufferedReader class to read the file efficiently or faster
import java.io.FileReader;//Handles the basic charecter-reading on my txt file
import java.io.IOException;//This is to help error-handling in the program as many issues can arise from reading and writing to a file
import java.util.ArrayList;//This allows to dynamically store and manage a list of objects
import java.io.BufferedWriter;// Imports BufferedWrited for writing text to a character-output stream more efficiently; improves performance.
import java.io.File;//Used in File validation 
import java.io.FileWriter;//FileWriter is used to write character data to a file; opens the file for writing.

public class CustomerDiscountGenerator {// The name of the Program

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        String customerFile = "C:\\Users\\reg05\\CCT\\customers.txt";//The file path where the program reads from.
        
        String outputCustomerFile = "C:\\Users\\reg05\\CCT\\customersdiscount.txt";//The file path where the programs writ to.
        
        try (BufferedReader br = new BufferedReader(new FileReader(customerFile))) {//a new instance of BufferedReader is created and assigned to the variable br.
            
            String line;//Variable to hold each line read from txt file
            while ((line = br.readLine()) != null) {//While loop reads lines from the file until there are no more lines.
                line = line.trim();//trim white space
                if(line.isEmpty()){
                    continue;//Skip empty lines
                }
                try {// Nested try block for handling potential exceptions that may occur while processing a customer.
                   
                    // Read customer details from four lines
                    //.trim() is called to remove any leading or trailing whitespace from the each line
                    
                    String fullName = line.trim();// Read the first line, which is the full name of the customer.
                    System.out.println(fullName);
                    
                    line = br.readLine(); // Read the second line which is the purchase value
                    while (line !=null && line.trim().isEmpty()){//skip the empty lines
                        line = br.readLine();
                    }
                    double purchaseValue = Double.parseDouble(line.trim());//parses this line as a double       
                    System.out.println(purchaseValue);
                    
                    line = br.readLine(); // Read the third line which is the customer class
                    while (line != null && line.trim().isEmpty()){//skip the empty lines
                        line = br.readLine();
                    }
                    int customerClass = Integer.parseInt(line.trim());//parse this line as an integer
                    System.out.println(customerClass);


                    line = br.readLine(); // Read the 4th line which is the last purchase year
                    while (line != null && line.trim().isEmpty()){//skip the empty lines
                        line = br.readLine();
                    }
                    String lastPurchaseYear = line.trim();//lastPurchaseYear is stored as a string;
                    System.out.println(lastPurchaseYear);

                    // Splits full name into two parts: firstName and secondName.
                    String[] nameParts = fullName.split(" ", 2);// Split is done at the first space character.
                    String firstName = nameParts[0];//Assigns the first part to firstname
                    String secondName = nameParts.length > 1 ? nameParts[1] : "";////If there is a second part, assign it to secondName. 
                                                                                //Otherwise, set it to an empty string.

                    // Creates a new Customer object using the data
                    Customer customer = new Customer(firstName, secondName, purchaseValue, customerClass, lastPurchaseYear);
                    customers.add(customer); // Add valid customer to the list
                    System.out.println("Valid customer: " + customer);

                } catch (NumberFormatException e) {//Catch block to handle errors if the purchase value or customer class cannot be parsed.
                    System.out.println("Error: invalid number format in customer data: " + e.getMessage());
                } catch (IllegalArgumentException e) {// Catch block for any IllegalArgumentException, such as validation failures.
                    System.out.println("Error: invalid customer data " + e.getMessage());
                }catch (IOException e) {//Catch block that handles errors that are not caught by specific catch block
                    System.out.println("Unexpected error: " + e.getMessage());
                }
            }
        } catch (IOException e) {//Catch block for handling errors while reading the file,such as file not found or read errors.
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Write valid customers to the output file as customersdiscount.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputCustomerFile))) {
            //Opens the output file for writing. The Buffered writer warps around FileWriter for efficient writing and the file is
            //automaticall closed.
            for (Customer customer : customers) { //For loop is used for simplicity and readability. This iterates through the list of valid customers.
                
                //Calculate the FINAL VALUE using the Discount Calculator
                DiscountCalculator calculator = new DiscountCalculator(customer);
                double finalValue = calculator.calculateDiscountedValue();
                
                bw.write(customer.getFirstName() + " " + customer.getSecondName());/*Writes customer's full name to output file.*/
                bw.newLine(); // Move to the next line
                bw.write(String.valueOf(finalValue));//BufferedWriter only writes in text therefore a double needs to be converted into a string
                bw.newLine();//Space to separate each customer's data.
            }
            System.out.println("List of Customer Discounts written to " + outputCustomerFile);//Confirmation message indicating that the output file was successful.
        } catch (IOException e) {//Catch block for handling errors for writing a file, such as file permission issues.
            System.out.println("Error writing to file: " + e.getMessage());
        }
        
        // Validate that the file exists, is readable, or not found
        File outputFile = new File(outputCustomerFile);
        if (outputFile.exists()) {
            System.out.println("File exists: " + outputFile.getAbsolutePath());
            if (outputFile.canRead()) {
                System.out.println("File is readable.");
            } else {
                System.out.println("File is not readable.");
            }
        } else {
            System.out.println("File not found: " + outputFile.getAbsolutePath());
        }
    }
    
}