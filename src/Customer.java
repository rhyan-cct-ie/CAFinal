/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author reg05
 */
public class Customer {
    private String firstName;
    private String secondName;
    private double purchaseValue;
    private int customerClass;
    private String lastPurchaseYear;
    
    public Customer (String firstName, String secondName, double purchaseValue, int customerClass, String lastPurchaseYear){
        this.firstName = firstName;
        this.secondName = secondName;
        this.purchaseValue = purchaseValue;
        this.customerClass = customerClass;
        this.lastPurchaseYear = lastPurchaseYear;
        
    } 
        //Validation methods as follows
    public boolean validateFirstName(){
        return firstName.matches("[a-zA-Z]+");
    }
    
    public boolean validateSecondName(){
        return secondName.matches("[a-zA-Z0-9]+");
    }
    
    public boolean validateFullName(){
        return validateFirstName() && validateSecondName();
    }
    
    public boolean validatePurchaseValue(){
        return purchaseValue >= 0;
    }
    public boolean validateClass(){
        return customerClass <=1 && customerClass >=3;
    }
    
    public boolean validateLastPurchaseYear(){
        return lastPurchaseYear.matches("\\d{4}");
    }
    
    public boolean validCustomerData(){
        return validateFullName() && validatePurchaseValue() && validateClass() && validateLastPurchaseYear();
    }
}
