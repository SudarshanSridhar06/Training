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
class Factorial{
    private int lowerlimit;
    private int upperlimit;
    private int factorials[];
    private FactorialIterator fi;
    
    class FactorialIterator implements Iterator {
        private int currentIndex = 0;
        
        @Override
            public boolean hasNext() {
                return currentIndex < upperlimit ;
            }

        @Override
            public Integer next() {
                return factorials[currentIndex++];
            }
            
        public void resetIndex(){
            this.currentIndex = 0;
        }    
        
//        @Override
//            public Iterator iterator(){
//            return new FactorialIterator();
//                
//            }
        
    }
    
    private Factorial setFactorials(){
        int temp = 1;
        for(int i = 1; i <= lowerlimit; i++){
            temp *= i;
        }
        int count = lowerlimit;
        for(int i = 0; i <= this.upperlimit - this.lowerlimit; i++){
            factorials[i] = temp;
            temp *= ++count;
        }
        return this;
    }

    public Factorial(int lowerlimit, int upperlimit) {
        this.lowerlimit = lowerlimit;
        this.upperlimit = upperlimit;
        this.factorials = new int[this.upperlimit - this.lowerlimit + 1];
        setFactorials();
    } 
    
    public Factorial setValues(int upper, int lower){
        this.lowerlimit = lower;
        this.upperlimit = upper;
        return this;
    }
    
    @Override
    public String toString(){
        String fact = "";
        for(int i = 0; i <= this.upperlimit - this.lowerlimit; i++ )
            fact += Integer.toString(factorials[i]) + "  ";
        return fact;
    }
    
    
    public static int getFactorial(int number){
        if(number <= 1)
            return 1;
        else{
            int temp = 2;
            for(int i = temp+1; i <= number; i++){
                temp *= i;
            }
            return temp;
        }
    }
    
//    @Override
//    public Iterator<Integer> iterator() {
//        Iterator<Integer> iter = new Iterator() {
//
//            private int currentIndex = 0;
//
//            @Override
//            public boolean hasNext() {
//                return currentIndex < upperlimit ;
//            }
//
//            @Override
//            public Integer next() {
//                return factorials[currentIndex++];
//            }
//
//        };
//        return iter;
//    }
    
    public Iterator iterator(){
//        if(fi == null){
//            fi = new FactorialIterator();
//            return fi;
//        }
//        else{
//            fi.resetIndex();
//            return fi;
//        }
          fi = new FactorialIterator();
          return fi;
    }
}

public class FactorialDemo {
    
    public static void main(String[] args){
        Factorial f = new Factorial(1, 10);
        Iterator iter = f.iterator();
//        while(iter.hasNext()){
//            System.out.print(iter.next() + "  ");
//        }
        System.out.println(f);
    }
    
}
            