/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author reg05
 */
import java.io.*;
import java.util.ArrayList;//This allows to dynamically store and manage a list of objects

public class CustomerDiscountGenerator {// The name of the Program

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        String customerFile = "C:\\Users\\reg05\\CCT\\customers.txt";//The file path where the program reads from.
        String outputCustomerFile = "C:\\Users\\reg05\\CCT\\customersdiscount;" //The file path where the programs writ to.
                
        public static void main(String[] args) {
        ArrayList<Customer> customers = CustomerUtils.readCustomers(customerFile);
        CustomerUtils.writeDiscountedCustomers(customers, outputCustomerFile);
        
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