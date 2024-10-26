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