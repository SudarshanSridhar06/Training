/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author cb-sudarshan
 */

// Program to print the samllest and the largest element in an integer array

public class Ex4 {
    
    public static void main(String[] args){
        
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
