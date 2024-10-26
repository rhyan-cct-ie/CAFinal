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
    
    //File paths for reading and writing the file
    private static String inputCustomerFile = "C:\\Users\\reg05\\CCT\\customers.txt";
    private static String outputCustomerFile = "C:\\Users\\reg05\\CCT\\customersdiscount.txt";
                
        public static void main(String[] args) {
        ArrayList<Customer> customers = CustomerUtils.readCustomers(inputCustomerFile);
        CustomerUtils.writeDiscountedCustomers(customers, outputCustomerFile);
        
        //Validate that the input file exists#
        File inputFile = new File (inputCustomerFile);
        if (inputFile.exists()){
            System.out.println("Input File exists" + inputFile.getAbsolutePath());
        }else {
            System.out.println("Input File is NOT Found");
        }
        if (inputFile.canRead()){
            System.out.println("Input File is readable");
        }else{
            System.out.println("Input File is NOT Readable");
        }
        // Validate that the outout file exists, is readable, or not found
        File outputFile = new File(outputCustomerFile);
        if (outputFile.exists()) {
            System.out.println("Output File exists: " + outputFile.getAbsolutePath());
            if (outputFile.canRead()) {
                System.out.println("Output File is readable.");
            } else {
                System.out.println("Output File is NOT readable.");
            }
        } else {
            System.out.println("Output File NOT found: " + outputFile.getAbsolutePath());
        }
    }
    
}