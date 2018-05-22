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

//Program to print N fibonacci numbers

public class Day3 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N !");
        int N = sc.nextInt();
        int temp = 0;
        int temp1 = 1;
        
        System.out.print(temp + "  " + temp1 + "  ");
        for(int i = 3; i <= N; i++){
            int temp2 = temp + temp1;
            System.out.print(temp2 + "  ");
            temp = temp1;
            temp1 = temp2;
        }
    }
    
}
