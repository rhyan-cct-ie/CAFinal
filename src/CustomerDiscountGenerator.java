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

public class CustomerDiscountGenerator {// The name of the Program

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String customerFile = "C:\\Users\\reg05\\CCT\\customers.txt"; /*This is the location of the file that needs to be read. Ensure that the file patch is correct
        before running the program*/
        
        try (BufferedReader br = new BufferedReader(new FileReader(customerFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String fullName = line.trim(); // Conatines the first name and the second name
                String purchaseValueLine = br.readLine(); //Containes Total Purchase Value
                String customerClassLine = br.readLine(); //Contains the Class
                String lastPurchaseYearLine = br.readLine(); //Containes Last Purchase Year

                // Check if we got all required lines
                if (purchaseValueLine == null || customerClassLine == null || lastPurchaseYearLine == null) {
                    System.out.println("Incomplete Data, cannot be processed.");
                    continue;
                }
                
                //Validate first line (Full Name)
                if(fullName.isEmpty()){
                    System.out.println("Invalid Full Name: cannot be empty.");
                    continue;//The program will skip this customer
                }
                
                String[] nameParts = fullName.split(" ");
                if (nameParts.length < 2){
                    System.out.println("Invalid Full Name for customer: must contain at least a first and a second name");
                    continue;//The program will skip this customer
                }
                

                // Print the data (or process it further as needed)
                System.out.println(fullName);
                System.out.println(purchaseValueLine.trim());
                System.out.println(customerClassLine.trim());
                System.out.println(lastPurchaseYearLine.trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}