/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cafinal;//what to name the package??????

/**
 *
 * @author reg05
 */

public class DataValidator {
    //Validate the full name has a single space separating the first name and the second name
    public boolean validateFullname(String fullName){
        String[] nameParts = fullName.split(" ");
        //Fullnames should be composed of two parts: first name and second name
        return nameParts.length == 2 && validateFirstName (nameParts[0]) && validateSecondName (nameParts [1]);
       
    }
    
    //Validate that the first name contains letters only
    public boolean validateFirstName(String firstName){
        return firstName.matches("[a-zA-Z]+");
    }
    
    //Validate that the second name contains letters and/or numbers
    public boolean validateSecondName(String secondName){
        return secondName.matches("[a-zA-Z0-9]+");
    }
    
    //Validate that the purchase of value is a double
    public boolean validatePurchaseValue(String purchaseValue){
        try{ 
            Double.parseDouble(purchaseValue);
            return true;
        } catch (NumberFormatException e){
        return false;
    } 
    }
    //Validate that the class is an integer between 1 and 3
    public boolean validateClass(String classNumber){
      
        try{
            int classInt = Integer.parseInt(classNumber);
            return classInt >= 1 && classInt <= 3;
        }catch (NumberFormatException e){
            return false;
        }
   }
}

