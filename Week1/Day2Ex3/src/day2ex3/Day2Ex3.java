/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day2ex3;
import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
public class Day2Ex3 {

    /**
     * @param args the command line arguments
     */
    
    //Program to print N fibonacci numbers
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
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
