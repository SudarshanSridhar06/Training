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
public class Ford extends Car{
    private int year;
    private int manufacturer_discount;

    public Ford(int year, int manufacturer_discount, int speed, double price, String color) {
        super(speed, price, color);
        this.year = year;
        this.manufacturer_discount = manufacturer_discount;
    }

    public int getYear() {
        return year;
    }

    public int getManufacturer_discount() {
        return manufacturer_discount;
    }

    public void setManufacturer_discount(int manufacturer_discount) {
        this.manufacturer_discount = manufacturer_discount;
    }

    @Override
    public double getSalePrice() {
        return super.getSalePrice() - this.manufacturer_discount;
    }

    @Override
    public String toString() {
        return "CarType: Ford, " + super.toString() + ", Year: " + this.year
                + ", Manufacturer Discount: " + this.manufacturer_discount;
    }
    
    
    
    
}
