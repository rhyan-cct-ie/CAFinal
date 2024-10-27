/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

//GITHUB LINK HERE: https://github.com/rhyan-cct-ie/CAFinal.git

/**
 *
 * @author reg05
 */
import java.io.*;//Used in creating File object
import java.util.ArrayList;//This allows to dynamically store and manage a list of objects

public class CustomerDiscountGenerator {// The name of the Program
    
    //File paths for reading and writing the file
    private static String inputCustomerFile = "C:\\Users\\reg05\\Downloads\\TESTcustomerfile.txt";//File path where customer txt is located.
    private static String outputCustomerFile = "C:\\Users\\reg05\\CCT\\customersdiscount.txt";//File Path where customersdiscount is written to.
         
    
    //Main method-entry point of the program
        public static void main(String[] args) {
            
        //Validate that the input file exists, is readable or not found.
        File inputFile = new File (inputCustomerFile);//Create a File object for the inputFile. File is from java.io library
        
        /*File Validation prior to reading the file ensures that it can safely attempt to 
        read from the specified file before performing any operations*/
        //Check if file exists or readable
        if (inputFile.exists()){
            System.out.println("Input File exists " + inputFile.getAbsolutePath());
        }else {
            System.out.println("Input File is NOT Found");
        }
        //Check if the input file is readable.
        if (inputFile.canRead()){
            System.out.println("Input File is readable");
        }else{
            System.out.println("Input File is NOT Readable");
        }
        
        //Proceed with reading and writing txt files
        ArrayList<Customer> customers = CustomerUtils.readCustomers(inputCustomerFile);
        CustomerUtils.writeDiscountedCustomers(customers, outputCustomerFile);
        
        // Validate that the outout file exists, is readable, or not found.
        File outputFile = new File(outputCustomerFile);
        
        //Check if the output file exists
        if (outputFile.exists()) {
            System.out.println("Output File exists: " + outputFile.getAbsolutePath());//Confirm the existence of the file
        } else {
        
            System.out.println("Output File NOT found: " + outputFile.getAbsolutePath());//Notify that the output file
        }
        //Check if the output file is readable
        if (outputFile.canRead()){
            System.out.println("Output File is readable");//Confirm that the file can be read
        }else{
            System.out.println("Output File is NOT readable");//Notify that the file cannot be read.
        
        }
    }
    
}