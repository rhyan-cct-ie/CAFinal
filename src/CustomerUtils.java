
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
                if (fullName.isEmpty()) continue;//skip empty lines
                try {
                    //Read and parse customer details
                    double purchaseValue = parseNextValue(br);//parse to double
                    int customerClass = (int) parseNextValue(br);//parse to integer
                    String lastPurchaseYear = br.readLine().trim();//read the last purchase year
                    
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
        //parseNextValue method
        private static double parseNextValue(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null && line.trim().isEmpty());
        if (line == null) throw new IOException("Unexpected end of file");
        return Double.parseDouble(line.trim());
    }
        //Validation of customer data
        private static void validateCustomer(String fullName, double purchaseValue, int customerClass, String lastPurchaseYear) {
        String[] nameParts = fullName.split(" ", 2);
        
        //Validate first name
        if (!nameParts[0].matches("[a-zA-Z]+")) 
            throw new IllegalArgumentException("Invalid first name: " + nameParts[0]+ "'Only letters are allowed.");
        
        //Validate second name if exists
        if (nameParts.length > 1 && !nameParts[1].matches("[a-zA-Z0-9]+")) 
            throw new IllegalArgumentException("Invalid second name: " + nameParts[1]+ "'Only letters and numbers are allowed.");
        
        //Validate purchase value
        //Any double is accepted
        //if (purchaseValue < 0) 
           // throw new IllegalArgumentException("Invalid purchase value: " + purchaseValue);
        
        //Validate customer class
        if (customerClass < 1 || customerClass > 3) 
            throw new IllegalArgumentException("Invalid customer class: " + customerClass);
        
        //Validate last purchase year format
        if (!lastPurchaseYear.matches("\\d{4}")) 
            throw new IllegalArgumentException("Invalid last purchase year format: " + lastPurchaseYear);
       
        int year = Integer.parseInt(lastPurchaseYear);//Convert last purchase year to INTEGER
        int currentYear;//Assigsn currentYear variable as integer
        currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);//getting current year
        
        //This conditional checks if the parsed year is less htan 1900 or greated than curren year
        //If this is true, the data in invalid for processing
        if (year < 1900 || year > currentYear) throw new IllegalArgumentException("Invalid last purchase year: " + lastPurchaseYear);
    }
        //File writer
        public static void writeDiscountedCustomers(ArrayList<Customer> customers, String outputCustomerFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputCustomerFile))) {
            for (Customer customer : customers) {
                DiscountCalculator calculator = new DiscountCalculator(customer);
                double finalValue = calculator.calculateDiscountedValue();
                bw.write(customer.getFirstName() + " " + customer.getSecondName());
                bw.newLine();
                bw.write(String.valueOf(finalValue));
                bw.newLine();
            }
            System.out.println("List of Customer Discounts written to " + outputCustomerFile);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            }
        }
            
    }