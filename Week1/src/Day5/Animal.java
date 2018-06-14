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
abstract class Animals {
    
    private boolean locomotion;
    private boolean property;
    private boolean food;
    
    //locomotion -> TRUE = By Land -> FALSE = Flying
    //property -> TRUE = Give Birth -> FALSE = LayEggs
    //food -> TRUE = By mouth -> FALSE = By beaks
    public Animals(boolean locomotion, boolean property, boolean food){
        this.locomotion = locomotion;
        this.property = property; 
        this.food = food;
    }
    
    abstract public void display();
    abstract public void sound();
      
}

interface Herbivore {
}

interface CanFly{
    
    
}

abstract class Mammal extends Animals{

    public Mammal(){
        super(true, true,true);
    }
    
    public Mammal(boolean value, boolean value1, boolean value2){
        super(value, value1, value2);
    }
    

}

abstract class Birds extends Animals{

    public Birds(){
        super(false, false, false);
    }
    
    public Birds(boolean value, boolean value1, boolean value2){
        super(value, value1, value2);
    }
    
}



class Dog extends Mammal{

    @Override
    public void sound() {
        System.out.print("Barking..\t");
    }
       
    @Override
    public void display(){
        System.out.println("Dog - Mammal \t");
        sound();
        
    }
    
}

class Cow extends Mammal implements Herbivore{

    @Override
    public void sound() {
        System.out.print("Make sound \t");
    }
    
    @Override
    public void display(){
        System.out.println("Cow - Mammal \t");
        sound();
        
    }
}

class Bat extends Mammal implements CanFly{
    
    public Bat(){
        super(false, false, false);
    }
    
    @Override
    public void sound() {
        System.out.print("Screeching.. \t");
    }

    @Override
    public void display(){
        System.out.println("Bat - Mammal \t");
        sound();
        
    }
}

class Ostrich extends Birds implements CanFly{

    @Override
    public void sound() {
        System.out.print("Low hum.. \t");
    }
    
    @Override
    public void display(){
        System.out.println("Ostrich - Bird \t");
        sound();
        
    }
}

class Parrot extends Birds implements Herbivore, CanFly {

    @Override
    public void sound() {
        System.out.print("Talking.. \t");
    }
    
    @Override
    public void display(){
        System.out.println("Parrot - Bird \t");
        sound();
        
    }
    
}

class Animal {
    
    public static void main(String[] args){
        List<Animals> animals = new ArrayList<>();
        
        boolean continu = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Create an Animal..");
        
        while(continu){
            System.out.println("1.Dog \t 2.Parrot \t 3.Ostrich \t 4.Cow \t"
                    + "5.Bat");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    animals.add(new Dog());
                    break;
                case 2:
                    animals.add(new Parrot());
                    break;
                case 3:
                    animals.add(new Ostrich());
                    break;
                case 4:
                    animals.add(new Cow());
                    break;
                case 5:
                    animals.add(new Bat());
                    break;    
                    
            }
            System.out.println("Want to create another animal? Y/N");
            continu = sc.next().equals("Y") ;
        }
        
        System.out.println("\n Animals created :");
        for(Animals animal : animals){
            animal.display();
            System.out.println("\n");        
        }
        
        System.out.println("\n\n Herbivores :");
        for(Animals animal : animals)
        {   
            if(animal instanceof Herbivore){
                animal.display();
                System.out.println("\n");
            }
        }
        System.out.println("\n\n Animals that can fly :");
        for(Animals animal : animals){
            if(animal instanceof CanFly){
                animal.display(); 
                System.out.println("\n");
            }
        }
        
    }
            
}