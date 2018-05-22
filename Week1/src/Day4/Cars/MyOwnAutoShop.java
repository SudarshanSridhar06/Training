/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day4.Cars;
import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
public class MyOwnAutoShop {
    
    public static void main(String[] args){
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Sedan(25,100,500000,"Orange"));
        cars.add(new Sedan(19,100,500000,"Red"));
        cars.add(new Ford(2018,10000,120,400000,"Orange"));
        cars.add(new Ford(2015,8000,120,400000,"Orange"));
        cars.add(new Truck(2400,90,30000,"Red"));
        cars.add(new Car(120,200000,"White"));
        
        for(Car car : cars){
            System.out.println(car);
            System.out.println("Sale Price: " + car.getSalePrice());
        }
    }
    
}
