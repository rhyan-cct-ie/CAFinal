/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafinal;

/**
 *
 * @author reg05
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CAFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //The file path is written below
        String myFile = "C:\\Users\\reg05\\CCT\\customers.txt";//This tells the program where the txt file is located 
        
        try (BufferedReader br = new BufferedReader(new FileReader(myFile))){
            String line;
            while ((line = br.readLine()) != null) {
                //validation proces needs to be done here
                System.out.println(line);
                
            }
        } catch (IOException e){
                e.printStackTrace();
        }
    }
    
}
