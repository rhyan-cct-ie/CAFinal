/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author reg05
 */
import java.io.BufferedReader;//Imports a BufferedReader class to read the file efficiently or faster
import java.io.FileReader;//handle the basic charecter-reading on my txt file
import java.io.IOException;//This is to help error-handling in the program as many issues can arise from reading and writing to a file
import java.util.ArrayList;

public class CustomerDiscountGenerator {// The name of the Program

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        String customerFile = "C:\\Users\\reg05\\CCT\\customers.txt"; /*This is the location of the file that needs to be read. Ensure that the file patch is correct
        before running the program*/

        try (BufferedReader br = new BufferedReader(new FileReader(customerFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    // Read customer details from four lines
                    String fullName = line.trim();

                    line = br.readLine(); // Read the purchase value
                    double purchaseValue = Double.parseDouble(line.trim());

                    line = br.readLine(); // Read the customer class
                    int customerClass = Integer.parseInt(line.trim());

                    line = br.readLine(); // Read the last purchase year
                    String lastPurchaseYear = line.trim();

                    // Split full name into firstName and secondName
                    String[] nameParts = fullName.split(" ", 2);
                    String firstName = nameParts[0];
                    String secondName = nameParts.length > 1 ? nameParts[1] : "";

                    // Create a new Customer object using the data
                    Customer customer = new Customer(firstName, secondName, purchaseValue, customerClass, lastPurchaseYear);
                    customers.add(customer); // Add valid customer to the list
                    System.out.println("Valid customer added: " + customer);

                } catch (Exception e) {
                    System.out.println("Error creating customer: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Display all valid customers
        System.out.println("\nList of valid customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}