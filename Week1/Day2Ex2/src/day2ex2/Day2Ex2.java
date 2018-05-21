/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day2ex2;
import java.util.*;

/**
 *
 * @author cb-sudarshan
 */

//Program to calculate the simple and compound interest

public class Day2Ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Principal ?");
        int principal = sc.nextInt();
        System.out.println("No of years ?");
        int years = sc.nextInt();
        System.out.println("Rate of interest?");
        float rate = sc.nextFloat();
        
        System.out.println("Simple Interest Payable after " + years + " is : "
                + (principal * rate * years) /100);
        
        System.out.println("Compound Interest Payable after " + years + " is : "
                + (principal * (Math.pow((1 + rate/100),years) - 1)));
        
    }
    
}
