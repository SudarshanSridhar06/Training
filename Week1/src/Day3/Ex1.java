/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;
import java.util.*;

class Animal{
    private static int count;
    private final String type;
    private final String name;
    
    
    static{
        count = 0;
    }
    
    public Animal(String type, String name){
        this.type = type;
        this.name = name;
        count++;
    }
    
    public void eat(){
        System.out.println(name + " is eating!");
    }
    
    @Override
    public String toString(){
        return ("Animal Type: " + type + ", Name: " + name);
    }
    
    public static void displayCount(){
        System.out.println("No of animals created : " + count);
    }
    
}

/**
 *
 * @author cb-sudarshan
 */
public class Ex1 {

    /**
     * @param args the command line arguments
     */
    private static Animal getDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the category of the animal...");
        String type = sc.next();
        System.out.println("Enter the name of the animal...");
        String name = sc.next();
        return new Animal(type,name);
        
    }
    
    //Progrsm to implement an animal class and instantiate objects using user inputs
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Animal.displayCount();
        String flag;
        do{
            animals.add(Ex1.getDetails());
            Animal.displayCount();
            System.out.println("Do you want to create an animal ? Y / N");
            flag = sc.next();           
        }
        while(flag.compareTo("Y") == 0);  
        
        for(Animal animal : animals)
            System.out.println(animal);
    }
            
}
