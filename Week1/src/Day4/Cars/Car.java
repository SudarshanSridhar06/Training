/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day4.Cars;

/**
 *
 * @author cb-sudarshan
 */
public class Car {
    
    private int speed;
    private double price;
    private String color;
    
    public Car(){
        
    }
    public Car(int speed, double price, String color){
        this.speed = speed;
        this.price = price;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public double getSalePrice(){
        return this.price - 1000;
    }
    
    @Override
    public String toString(){
        return "Speed :" + this.speed + ", Price :" + this.price;
    }
    
}
