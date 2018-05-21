/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;

import java.util.Scanner;

/**
 *
 * @author cb-sudarshan
 */

//program to find the summation of indices of the characters in given input is odd or even.

public class Ex1 {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the character sequence");
        String sequence = sc.next();
        int value = 0;
        
        for(char ch : sequence.toCharArray())
            value += ch-96;
            
        System.out.println("Summation of sequence of characters : " + value );
        
        if(value % 2 == 0)
            System.out.println("Even");
        else
            System.out.println("Odd");
        
        
    }
    
}
