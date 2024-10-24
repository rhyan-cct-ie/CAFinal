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
    private final Customer customer;// Holds the Customer object for which the discount will be calculated
    
    
    //This is the constructor for the class DiscountCalculator
    public DiscountCalculator(Customer customer) {
        this.customer = customer;
    }
    
    //This method calculates the discounted value of the purchase based on customer details.
    public double calculateDiscountedValue() {
        double purchaseValue = customer.getPurchaseValue();//get the original purchase value
        int customerClass = customer.getCustomerClass();//get the customer class
        String lastPurchaseYearStr = customer.getLastPurchaseYear();//get the last purchase as a string
        int lastPurchaseYear = Integer.parseInt(lastPurchaseYearStr);//convert last purchase year as an integer
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);//get the current year
        
    double discountPercentage = 0;//This initializes the discountPercentage variable to 0, indicating no discount by default.
    
        switch (customerClass) {
            case 1 -> {
                if (lastPurchaseYear == currentYear) {
                    discountPercentage = 0.30;//30% discount if last purchase is in the current year (2024)
                } else if (lastPurchaseYear < currentYear) {
                    discountPercentage = 0.20;// 20% discount if last purchase is before the current year
                } else if (lastPurchaseYear <= currentYear - 5) {
                    discountPercentage = 0.10;// 10% discount if last purchase was more than 5 years ago
                }
            }
            case 2 -> {
                if (lastPurchaseYear == currentYear) {
                    discountPercentage = 0.15;// 15% discount if last purchase is in the current year
                } else if (lastPurchaseYear < currentYear) {
                    discountPercentage = 0.13;// 13% discount if last purchase is before the current year
                } else if (lastPurchaseYear <= currentYear - 5) {
                    discountPercentage = 0.05;// 5% discount if last purchase was more than 5 years ago
                }
            }
            case 3 -> {
                if (lastPurchaseYear == currentYear) {
                    discountPercentage = 0.03;// 3% discount if last purchase is in the current year
                }
                // No discount for Class 3 if the last purchase was before the current year
            }
            default -> {
            }
        }

        double discountAmount = purchaseValue * discountPercentage;// Calculates the discount amount
        double finalValue = purchaseValue - discountAmount;// Calculates the final discounted value or the FINAL VALUE

        return finalValue;//The FINAL VALUE after applying the calculated discount.
    }
}
