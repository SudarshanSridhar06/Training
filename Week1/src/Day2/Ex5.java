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

//Program to print numbers in pyramid pattern

public class Ex5 {
    
    public static void main(String[] args){
        
        int rows;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows..");
        rows = sc.nextInt();
        
        
        for(int i = 1; i <= rows; i++){
            System.out.println("");
            for(int j = 1; j <= rows-i ; j++)
                System.out.print("  ");
            int j = 1;
            int no = 1;
            int flag = 0;
            while(j++ <= (i * 2) - 1){
                System.out.print(no + " ");
                if(no == i)
                    flag = 1;
                if(flag == 1)
                    no--;
                else
                    no++;              
            }
        }
    }
    
}
