/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat2ex5;

/**
 *
 * @author cb-sudarshan
 */
public class Dat2Ex5 {

    /**
     * @param args the command line arguments
     */
    
    //Program to print numbers in pyramid pattern
    
    public static void main(String[] args) {
        // TODO code application logic here
        int rows = 5;
        
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
