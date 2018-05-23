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
interface Animals {
    
    public void locomotion();
    public void property();
    public void food();
    public boolean isHerbivore();
    public boolean canFly();
    public void display();
    
}

interface Herbivore {
    public void food();
}

interface cannotFly{
    public void locomotion();
    
}

abstract class Mammal implements Animals{
    
    @Override
    public void property(){
        System.out.print("Can give birth!, Can secrete milk \t");
    }

    @Override
    public void locomotion() {
        System.out.print("By four legs on ground \t");
    }

    @Override
    public void food() {
        System.out.print("Eat anything through mouth \t");
    }
    
    abstract public void sound();
    
    
}

abstract class Birds implements Animals{

    @Override
    public void locomotion() {
        System.out.print("Through air using wings \t");
    }

    @Override
    public void property() {
        System.out.print("Lay eggs \t");
    }
    
    @Override
    public void food() {
        System.out.print("Eat anything through beaks \t");
    }
    
    abstract public void sound();
    
}


class Dog extends Mammal{

    @Override
    public void sound() {
        System.out.print("Barking..\t");
    }

    @Override
    public boolean isHerbivore() {
        return false;
    }

    @Override
    public boolean canFly() {
        return false;
    }
       
    @Override
    public void display(){
        System.out.println("Dog - Mammal \t");
        sound();locomotion();food();property();
        
    }
    
}

class Cow extends Mammal implements Herbivore{

    @Override
    public void sound() {
        System.out.print("Make sound \t");
    }
    
    @Override
    public void food(){
        System.out.print("Herbivore - Eats only greens through mouth \t");
    }

    @Override
    public boolean isHerbivore() {
        return true;
    }

    @Override
    public boolean canFly() {
        return false;
    }
    
    @Override
    public void display(){
        System.out.println("Cow - Mammal \t");
        sound();locomotion();food();property();
        
    }
}

class Bat extends Mammal{
    
    @Override
    public void sound() {
        System.out.print("Screeching.. \t");
    }
    
    @Override
    public void locomotion() {
        System.out.print("Through air using wings \t");
    }

    @Override
    public boolean isHerbivore() {
        return false;
    }

    @Override
    public boolean canFly() {
        return false;
    }
    
    @Override
    public void display(){
        System.out.println("Bat - Mammal \t");
        sound();locomotion();food();property();
        
    }
}

class Ostrich extends Birds implements cannotFly{

    @Override
    public void sound() {
        System.out.print("Low hum.. \t");
    }
    
    @Override
    public void locomotion() {
        System.out.print("Can't fly - By four legs on ground \t");
    }

    @Override
    public boolean isHerbivore() {
        return false;
    }

    @Override
    public boolean canFly() {
        return false;
    }
    
    @Override
    public void display(){
        System.out.println("Ostrich - Bird \t");
        sound();locomotion();food();property();
        
    }
}

class Parrot extends Birds implements Herbivore {

    @Override
    public void sound() {
        System.out.print("Talking.. \t");
    }

    @Override
    public boolean isHerbivore() {
        return true;
    }

    @Override
    public boolean canFly() {
        return true;
    }
    
    @Override
    public void display(){
        System.out.println("Parrot - Bird \t");
        sound();locomotion();food();property();
        
    }
}

class Animal {
    
    public static void main(String[] args){
        List<Animals> animals = new ArrayList<>();
        List<Animals> herbivores = new ArrayList<>();
        List<Animals> flyingAnimals= new ArrayList<>();
        
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
            continu = sc.next().compareTo("Y") == 0 ;
        }
        
        System.out.println("\n Animals created :");
        for(Animals animal : animals){
            animal.display();
            System.out.println("\n");
            if(animal.canFly())
                flyingAnimals.add(animal);
            if(animal.isHerbivore())
                herbivores.add(animal);
            
        }
        
        System.out.println("\n\n Herbivores :");
        for(Animals animal : herbivores)
        {   
            animal.display();
            System.out.println("\n");
        }
        System.out.println("\n\n Animals that can fly :");
        for(Animals animal : flyingAnimals){
            animal.display(); 
            System.out.println("\n");
        }
        
    }
            
}