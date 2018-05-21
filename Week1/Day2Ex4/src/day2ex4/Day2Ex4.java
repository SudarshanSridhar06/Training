/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day2ex4;
import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
 

public class Day2Ex4 {

    /**
     * @param args the command line arguments
     */
    
    // Program to print the samllest and the largest element in an integer array
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 10 integers");
        int[] array = new int[10];
        
        for(int i = 0; i < 10; i++)
            array[i] = sc.nextInt();
        
        Arrays.sort(array);
        
        System.out.println("Minimum = " + array[0]);
        System.out.println("Maximum = " + array[9]);
        

        
    }
    
}
