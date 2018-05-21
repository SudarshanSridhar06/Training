/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1ex4;

import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
public class Day1Ex4 {

    /**
     * @param args the command line arguments
     */
    
    //Program to find the smallest power of x greater than y
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the value of x & y");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int power = 0;
        
        while(Math.pow(x,power) < y)
            power++;
        
        System.out.println("The smallest power of "+ x + " greater than " + y + " is : " + power);
    }
    
}
