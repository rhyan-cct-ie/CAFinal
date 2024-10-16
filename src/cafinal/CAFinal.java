/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cafinal;

/**
 *
 * @author reg05
 */
import java.io.BufferedReader;//Imports a BufferedReader class to read the file efficiently or faster
import java.io.FileReader;//handle the basic charecter-reading on my txt file
import java.io.IOException;//This is to help error-handling in the program as many issues can arise from reading and writing to a file

public class CAFinal {//

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*The line below declares a String variable named myFile and assigns it the name 
        of the file to be read, customers.txt. This file should be in the same directory as the program or provide a full path.*/
        String myFile = "C:\\Users\\reg05\\CCT\\customers.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(myFile))){
            String line;//This line declares a String variable named line, which holds each line of text read from the txt file.
            while ((line = br.readLine()) != null) {//The while loop here reads each line until it reaches the end of the file and causes it to exit
                //validation proces needs to be done here
                System.out.println(line);
                
            }
        } catch (IOException e){//This line starts the catch block to handle any IOException that might occur during the operation.
                e.printStackTrace();
        }
    }
    
}
