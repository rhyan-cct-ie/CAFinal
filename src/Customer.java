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
    private String firstName;//final is used to declare the variable constant
    private String secondName;
    private double purchaseValue;
    private int customerClass;
    private String lastPurchaseYear;
    
    public Customer (String firstName, String secondName, double purchaseValue, int customerClass, String lastPurchaseYear){
        
        // Constructor that uses setters for validation
        setFirstName(firstName); // Use setter for validation
        setSecondName(secondName); // Use setter for validation
        setPurchaseValue(purchaseValue); // Use setter for validation
        setCustomerClass(customerClass); // Use setter for validation
        setLastPurchaseYear(lastPurchaseYear); // Use setter for validation
}
    //validating the data
    public void setFirstName(String firstName) {
        if (!firstName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Invalid first name: " + firstName);
        }
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        if (!secondName.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Invalid second name: " + secondName);
        }
        this.secondName = secondName;
    }

    public void setPurchaseValue(double purchaseValue) {
        if (purchaseValue < 0) {
            throw new IllegalArgumentException("Invalid purchase value: " + purchaseValue);
        }
        this.purchaseValue = purchaseValue;
    }

    public void setCustomerClass(int customerClass) {
        if (customerClass < 1 || customerClass > 3) {
            throw new IllegalArgumentException("Invalid customer class: " + customerClass);
        }
        this.customerClass = customerClass;
    }

    public void setLastPurchaseYear(String lastPurchaseYear) {
        if (!lastPurchaseYear.matches("\\d{4}")) {
            throw new IllegalArgumentException("Invalid last purchase year format: " + lastPurchaseYear);
        }
        int year = Integer.parseInt(lastPurchaseYear);
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        if (year < 1900 || year > currentYear) {
            throw new IllegalArgumentException("Invalid last purchase year: " + lastPurchaseYear);
        }
        this.lastPurchaseYear = lastPurchaseYear;
    }
    
        
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

    @Override
    public String toString() {
        return "Customer[firstName='" + firstName + "', secondName='" + secondName + 
               "', purchaseValue=" + purchaseValue + ", customerClass=" + customerClass + 
               ", lastPurchaseYear='" + lastPurchaseYear + "']";
    }
    
}
