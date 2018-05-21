/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1;

import java.util.Scanner;

/**
 *
 * @author cb-sudarshan
 */

//Program to find the smallest power of x greater than y

public class Ex4 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the value of x & y");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int power = 0;
        
        while(Math.pow(x,power) <= y)
            power++;
        
        System.out.println("The smallest power of "+ x + " greater than " + y + " is : " + power);
    }
    
}
