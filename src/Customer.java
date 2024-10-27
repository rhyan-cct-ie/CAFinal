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
    private String firstName;
    private String secondName;
    private double purchaseValue;
    private int customerClass;
    private String lastPurchaseYear;
    
    //Constructors
    public Customer(String fullName, double purchaseValue, int customerClass, String lastPurchaseYear) {
        String[] nameParts = fullName.split(" ", 2);
        this.firstName = nameParts[0];
        this.secondName = nameParts.length > 1 ? nameParts[1] : "";
        this.purchaseValue = purchaseValue;
        this.customerClass = customerClass;
        this.lastPurchaseYear = lastPurchaseYear;
    }
    
    //setters
   /* private void setFirstName(String firstName) {
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
    }Setters are not used in the 
    */
    
        
    // The getter methods allow access to the current values of the fields.
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

    @Override //This method overrides the default toString() from Object class
    public String toString() {
        return "Customer[firstName='" + firstName + "', secondName='" + secondName + 
               "', purchaseValue=" + purchaseValue + ", customerClass=" + customerClass + 
               ", lastPurchaseYear='" + lastPurchaseYear + "']";
    }
    
}
