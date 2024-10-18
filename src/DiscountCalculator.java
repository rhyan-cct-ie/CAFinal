/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author reg05
 */
import java.util.Calendar;
public class DiscountCalculator {
    private Customer customer;
    
    public DiscountCalculator(Customer customer) {
        this.customer = customer;
    }
    
    public double calculateDiscountedValue() {
        double purchaseValue = customer.getPurchaseValue();
        int customerClass = customer.getCustomerClass();
        String lastPurchaseYearStr = customer.getLastPurchaseYear();
        int lastPurchaseYear = Integer.parseInt(lastPurchaseYearStr);
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    
}
