/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author reg05
 */
import java.util.Calendar;

public class Customer {
    //Declare class fields as private to enforce encapsulation.
    private String firstName;//Customer's first name
    private String secondName;//Customer's second name
    private double purchaseValue;//Total Value of purchases made
    private int customerClass;//Classification of customer (1-3)
    private String lastPurchaseYear;//Year of the last purchase as a STRING
    
    //Constructor to initialise customer attributes
    public Customer(String fullName, double purchaseValue, int customerClass, String lastPurchaseYear) {
        String[] nameParts = fullName.split(" ", 2);//Split full name into first name and second name
        this.firstName = nameParts[0];//Assign first name
        this.secondName = nameParts.length > 1 ? nameParts[1] : "";//Assign second name
        this.purchaseValue = purchaseValue;//Set the purchase value
        this.customerClass = customerClass;//Set the customer class
        this.lastPurchaseYear = lastPurchaseYear;//Set the last purchase year
    }
    
    //setters are not used in this program; can be deleted
   private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    private void setPurchaseValue(double purchaseValue) {
        this.purchaseValue = purchaseValue;
    }
    

    private void setCustomerClass(int customerClass) {
        this.customerClass = customerClass;
    }

    private void setLastPurchaseYear(String lastPurchaseYear) {
        this.lastPurchaseYear = lastPurchaseYear;
    } //Setters are not used in the program
   
    
        
    //Getter methods allow access private attributes
    public String getFirstName() {
        return firstName;
    }
    
    public String getSecondName(){
        return secondName;
    }
    
    public double getPurchaseValue(){
        return purchaseValue;
    }
    
    public int getCustomerClass(){
        return customerClass;
    }
    
    public String getLastPurchaseYear(){
        return lastPurchaseYear;
    }

    @Override //Override toString for easier printing of customer details.
    public String toString() {
        return "Customer First Name='" + firstName + "', Second Name='" + secondName + 
               "', Purchase Value=" + purchaseValue + ", Class=" + customerClass + 
               ", Last Purchase Year='" + lastPurchaseYear + "']";
    }
    
}
