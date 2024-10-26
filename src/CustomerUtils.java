
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author reg05
 */
public class CustomerUtils {
    public static ArrayList<Customer> readCustomers(String customerFile) {
        ArrayList<Customer> customers = new ArrayList<>();//Create a list to hold customer objects
        try (BufferedReader br = new BufferedReader(new FileReader(customerFile))) {//open the file
            String fullName;// variable to store customer full name
            while ((fullName = br.readLine()) != null) {//Read each line until the end of the file
                fullName = fullName.trim();//remove leading and trailing whitspaces
                if (fullName.isEmpty()) continue;//skip empty lines
                try {
                    //read and parse
                    double purchaseValue = parseNextValue(br);
                    int customerClass = (int) parseNextValue(br);
                    String lastPurchaseYear = br.readLine().trim();
                    
                    //Validate customer details
                    validateCustomer(fullName, purchaseValue, customerClass, lastPurchaseYear);
                    
                    //Create customer objectusing parsed data
                    Customer customer = new Customer(fullName, purchaseValue, customerClass, lastPurchaseYear);
                    customers.add(customer);//add customer to the list
                    System.out.println("Valid customer:" + customer);//prints valid costumer
                } catch (Exception e) {//Catch exceptions during processing of customer
                    System.out.println("Invalid customer:" + fullName + " - Error:" + e.getMessage());//prints message for invalid customer
                }
            }
        } catch (IOException e) {//Handle file reading errors
            System.out.println("Error reading file:" + e.getMessage());
        }
        return customers;//Return the list of cutomers
    }
        //parseNextLine method
        private static double parseNextValue(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null && line.trim().isEmpty());
        if (line == null) throw new IOException("Unexpected end of file");
        return Double.parseDouble(line.trim());
    }
        //Validation of customer data
        private static void validateCustomer(String fullName, double purchaseValue, int customerClass, String lastPurchaseYear) {
        String[] nameParts = fullName.split(" ", 2);
        if (!nameParts[0].matches("[a-zA-Z]+")) throw new IllegalArgumentException("Invalid first name: " + nameParts[0]);
        if (nameParts.length > 1 && !nameParts[1].matches("[a-zA-Z0-9]+")) throw new IllegalArgumentException("Invalid second name: " + nameParts[1]);
        if (purchaseValue < 0) throw new IllegalArgumentException("Invalid purchase value: " + purchaseValue);
        if (customerClass < 1 || customerClass > 3) throw new IllegalArgumentException("Invalid customer class: " + customerClass);
        if (!lastPurchaseYear.matches("\\d{4}")) throw new IllegalArgumentException("Invalid last purchase year format: " + lastPurchaseYear);
        int year = Integer.parseInt(lastPurchaseYear);
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        if (year < 1900 || year > currentYear) throw new IllegalArgumentException("Invalid last purchase year: " + lastPurchaseYear);
    }
    }