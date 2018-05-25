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
public class Sedan extends Car{
    private int length;

    public Sedan(int length, int speed, double price, String color) {
        super(speed, price, color);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public Car setLength(int length) {
        this.length = length;
        return this;
    }
    
    @Override
    public double getSalePrice() {
        if(this.length > 20)//5% discount
            return super.getSalePrice() - (super.getSalePrice() / 20);
        else//10% discount
            return super.getSalePrice() - (super.getSalePrice() / 10); 
    }

    @Override
    public String toString() {
        return "CarType: Sedan, " + super.toString() + ", Length: " + this.length;
    }
    
    
}
