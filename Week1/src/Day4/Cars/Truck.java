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
public class Truck extends Car {
    
    private int weight;

    public Truck(int weight, int speed, double price, String color) {
        super(speed, price, color);
        this.weight = weight;
    }

    @Override
    public double getSalePrice() {
        if(this.weight > 2000)//10% discount
            return super.getSalePrice() - (super.getSalePrice() / 10);
        else//20% discount
            return super.getSalePrice() - (super.getSalePrice() / 5); 
    }

    @Override
    public String toString() {
        return "CarType: Truck, " + super.toString() + ", Weight: " + this.weight;
    }
    
    
    
}
