/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tempconversion;
import java.util.Scanner;
/**
 *
 * @author hannah.goett
 */
public class TempConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Double celsius;
        Double fahrenheit;
        System.out.println("Enter the temperture in celsius.");
        celsius = input.nextDouble();
        fahrenheit = celsius * (9.0/5.0) + 32.0;
        System.out.println(celsius+ " degress celsius is " +fahrenheit+ " degrees fahrenheit");
        
    }
    
}
