/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day5;
import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
class Factorial implements Iterable{
    private int lowerlimit;
    private int upperlimit;
    private int factorials[];
    
    private void setFactorials(){
        int temp = 1;
        for(int i = 1; i <= lowerlimit; i++){
            temp *= i;
        }
        int count = lowerlimit;
        for(int i = 0; i <= this.upperlimit - this.lowerlimit; i++){
            factorials[i] = temp;
            temp *= ++count;
        }
    }

    public Factorial(int lowerlimit, int upperlimit) {
        this.lowerlimit = lowerlimit;
        this.upperlimit = upperlimit;
        this.factorials = new int[this.upperlimit - this.lowerlimit + 1];
        setFactorials();
    } 
    
    public boolean setValues(int upper, int lower){
        this.lowerlimit = lower;
        this.upperlimit = upper;
        return true;
    }
    
    @Override
    public String toString(){
        String fact = "";
        for(int i = 0; i <= this.upperlimit - this.lowerlimit; i++ )
            fact += Integer.toString(factorials[i]) + "  ";
        return fact;
    }
    
    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> iter = new Iterator() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < upperlimit ;
            }

            @Override
            public Integer next() {
                return factorials[currentIndex++];
            }

        };
        return iter;
    }
}

public class FactorialDemo {
    
    public static void main(String[] args){
        Factorial f = new Factorial(1, 10);
        Iterator iter = f.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + "  ");
        }
    }
    
}
