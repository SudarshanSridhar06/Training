/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day2ex1;

import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
public class Day2Ex1 {

    /**
     * @param args the command line arguments
     */
    
    //program to find the summation of indices of the characters in given input is odd or even.
            
    public static void main(String[] args) {
        // TODO code application logic here
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
