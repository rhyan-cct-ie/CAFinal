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
import java.io.BufferedWriter;
import java.io.FileWriter;

public class CustomerDiscountGenerator {// The name of the Program

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        String customerFile = "C:\\Users\\reg05\\CCT\\customers.txt"; /*This is the location of the file that needs to be read. Ensure that the file patch is correct
        before running the program*/
        String outputCustomerFile = "C:\\Users\\reg05\\CCT\\customersdiscount.txt";//this is the path where the output will be written by the program
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
                    System.out.println("Valid customer: " + customer);

                } catch (NumberFormatException e) {
                    System.out.println("Error: invalid nu,ber format in customer data: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Write valid customers to the output file as customersdiscount.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputCustomerFile))) {
            for (Customer customer : customers) {
                
                //Calculate the FINAL VALUE using the Discount Calculator
                DiscountCalculator calculator = new DiscountCalculator(customer);
                double finalValue = calculator.calculateDiscountedValue();
                
                bw.write(customer.getFirstName() + " " + customer.getSecondName());
                bw.newLine(); // Move to the next line
                bw.write(String.valueOf(customer.getPurchaseValue())); // Writes the purchase value
                bw.newLine(); // Move to the next line
                bw.write(String.valueOf(finalValue));//BufferedWriter only writes in text therefore a double needs to be converted into a string
                bw.newLine();//Space to separate each customer's data
            }
            System.out.println("Customer Discounted Value written to " + outputCustomerFile);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}