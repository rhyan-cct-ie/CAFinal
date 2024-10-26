
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
    
}
