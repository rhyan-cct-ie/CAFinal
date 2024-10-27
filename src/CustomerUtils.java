
import java.io.BufferedReader;//For reading text from input streams
import java.io.BufferedWriter;//For writing text to output streams
import java.io.FileReader;//For reading files
import java.io.FileWriter;//For writing files
import java.io.IOException;//For Handling input-output exceptions
import java.util.ArrayList;//For using dynamic arrays
import java.util.Calendar;//For getting the current date and time

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author reg05
 */
public class CustomerUtils {
    //Method to read customers from a specified file
    public static ArrayList<Customer> readCustomers(String customerFile) {
        ArrayList<Customer> customers = new ArrayList<>();//Create a list to hold customer objects
        
        //File reader
        //Try-with-resources for automatic resource management
        try (BufferedReader br = new BufferedReader(new FileReader(customerFile))) {
            String fullName;// variable to store customer full name
            while ((fullName = br.readLine()) != null) {//Read each line until the end of the file
                fullName = fullName.trim();//remove leading and trailing whitspaces
                if (fullName.isEmpty()) 
                    continue;//skip empty lines
                try {
                
                //Read purchase value: this line parses a double from the next non-empty line
                double purchaseValue = Double.parseDouble(readNextNonEmptyLine(br));

                // Read customer class: this line parses an integer from the next non-empty line
                int customerClass = Integer.parseInt(readNextNonEmptyLine(br));

                
                // Read last purchase year: this reads the non-empty line as a string
                String lastPurchaseYear = readNextNonEmptyLine(br);
                    
                    //Validate customer details
                    validateCustomer(fullName, purchaseValue, customerClass, lastPurchaseYear);
                    
                    //Create customer objectusing parsed data
                    Customer customer = new Customer(fullName, purchaseValue, customerClass, lastPurchaseYear);
                    customers.add(customer);//add customer to the list
                    System.out.println("Valid customer:" + customer);//prints valid costumer
                } catch (Exception e) {//Catch exceptions during processing of customer
                    System.out.println("Invalid customer:" + fullName + " - Error:" + e.getMessage());//Print message
                }
            }
        } catch (IOException e) {//Handle file reading errors
            System.out.println("Error reading file:" + e.getMessage());
        }
        return customers;//Return the list of cutomers
    }
        private static String readNextNonEmptyLine(BufferedReader br) throws IOException {//new method to iterates through each line, skips empty line
            String line;
            while ((line = br.readLine()) != null) { // Read each line from the file
                line = line.trim();                  // Remove any leading/trailing whitespace
            if (!line.isEmpty()) return line;    // Return the line if it's non-empty
            }
            throw new IOException("Unexpected end of file"); // Throw an error if the end of the file is reached
        }
        
        //parseNextValue method
        private static double parseNextValue(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null && line.trim().isEmpty());
        if (line == null) throw new IOException("Unexpected end of file");
        return Double.parseDouble(line.trim());
    }
        //Validation of customer data. In the validation logic, I use regex patterns as it is concise, flexible, and straighforward.
        //Regex also optimises engine performance and reduce human errors.
        private static void validateCustomer(String fullName, double purchaseValue, int customerClass, String lastPurchaseYear) {
        String[] nameParts = fullName.split(" ", 2);//First name and second name are separated by a single space
        
        //Validate first name: first name must consist ONLY of letters (a-z, A-Z),otherwise an error is thrown.
        if (!nameParts[0].matches("[a-zA-Z]+")) 
            throw new IllegalArgumentException("Invalid first name: " + nameParts[0]+ "'Only letters are allowed.");
        
        //Validate second name if exists: consists of either letters and/or numbers,otherwise, an error is thrown.
        if (nameParts.length > 1 && !nameParts[1].matches("[a-zA-Z0-9]+")) 
            throw new IllegalArgumentException("Invalid second name: " + nameParts[1]+ "'Only letters and numbers are allowed.");
        
        //Validate purchase value: it must be a double,if does not match, an error is thrown.
        if (purchaseValue < 0) 
           throw new IllegalArgumentException("Invalid purchase value: " + purchaseValue);
        
        //Validate customer class: it must be an integer between 1 and 3, if outside range, an error is thrown. No discount is applied.
        if (customerClass < 1 || customerClass > 3) 
            throw new IllegalArgumentException("Invalid customer class: " + customerClass + "No Discount");
        
        //Validate last purchase year format: year must be a four-digit number and within realistic range.
        //It cannot be less than 1900 or greater than the current year.
        if (!lastPurchaseYear.matches("\\d{4}")) 
            throw new IllegalArgumentException("Invalid last purchase year format: " + lastPurchaseYear);
        int year = Integer.parseInt(lastPurchaseYear);//Convert last purchase year to INTEGER
        int currentYear;//Assigsn currentYear variable as integer
        currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);//getting current year
       
        //This conditional checks if the parsed year is less htan 1900 or greater than current year
        //If this is true, the data in invalid for processing
        if (year < 1900 || year > currentYear) throw new IllegalArgumentException("Invalid last purchase year: " + lastPurchaseYear);
    }
        //File writer method to write discounted customer data to a specified output file
        public static void writeDiscountedCustomers(ArrayList<Customer> customers, String outputCustomerFile) {
            
        // Try-with-resources to ensure proper resource management
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputCustomerFile))) {
            //Iterate through each customer in the list
            for (Customer customer : customers) {
                try{//try-catch to handle errors during calculation
                DiscountCalculator calculator = new DiscountCalculator(customer);//Create a DiscountCalculator Object
                double finalValue = calculator.calculateDiscountedValue();//Calculate the discounted value (finalValue) using the calculator
                bw.write(customer.getFirstName() + " " + customer.getSecondName());//Write customer's full name to output file
                bw.newLine();//Move to next line
                bw.write(String.valueOf(finalValue));// Write the final discounted value to the output file
                bw.newLine();//move to next line
                } catch (Exception e) {
                    System.out.println("Error calculating discount for customer: " + customer.getFirstName() + " - " + e.getMessage());
                }
            }
            System.out.println("List of Customer Discounts written to " + outputCustomerFile);// Print a success message indicating that the data has been written to the file.
        } catch (IOException e) {// Handle any IO exceptions that occur during file writing
            System.out.println("Error writing to file: " + e.getMessage());//Error message if file writer unsuccessful
            }
        }
            
    }