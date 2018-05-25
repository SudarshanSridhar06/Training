/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1;

/**
 *
 * @author cb-sudarshan
 */
//Program to implement conditional statements
public class Ex3 {

    public static void main(String[] args) {
        // TODO code application logic here
        int age = 15;
        int temp1 = 10;
        int temp2 = 9;

        int max = temp1 > temp2 ? temp1 : temp2;

        System.out.println("Maximum Of temp1 & temp2 is : " + max);

        if (age < 18) {
            System.out.println("Not a valid age");
        } else {
            System.out.println("Accepted");
        }

        while (age < 18) {
            System.out.println("Hello");
            age++;
        }
    }

}
