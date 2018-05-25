/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day4.ServiceStation;

/**
 *
 * @author cb-sudarshan
 */
abstract class Vehicle {
    private String type;
    private String color;
    private final String service = "WaterWash";
    int service_charge;
    int employee_charge;

    public Vehicle(String type, String color) {
        this.type = type;
        this.color = color;
    } 

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getService() {
        return service;
    }

    public int getService_charge() {
        return service_charge;
    }

    public int getEmployee_charge() {
        return employee_charge;
    }
   
    public Vehicle setEmployee_charge(int employee_charge) {
        this.employee_charge = employee_charge;
        return this;
    }  

    public Vehicle setType(String type){
        this.type = type;
        return this;
    }

    public Vehicle setColor(String color){
        this.color = color;
        return this;
    }

    public Vehicle setService_charge(int service_charge){
        this.service_charge = service_charge;
        return this;
    }   
}

class Bike extends Vehicle{

    public Bike(String type, String color) {
            super("Bike - " + type, color);
            if(type.compareTo("Yamaha") == 0){
                this.setService_charge(1000);
                this.setEmployee_charge(200);
            }
            else if(type.compareTo("Suzuki") == 0){
                this.setService_charge(900);
                this.setEmployee_charge(200);
            }
            else{
                this.setService_charge(800);
                this.setEmployee_charge(100);
            }
            
    }

    @Override
    public Vehicle setType(String type) {
        return super.setType("Bike  - " + type);
    }
    
}

class Car extends Vehicle{

    public Car(String type, String color) { 
        super("Car - "+type, color);
            if(type.compareTo("Volkaswagen") == 0){
                this.setService_charge(2000);
                this.setEmployee_charge(500);
            }
            else if(type.compareTo("Volvo") == 0){
                this.setService_charge(2500);
                this.setEmployee_charge(700);
            }
            else{
                this.setService_charge(2200);
                this.setEmployee_charge(600);
            }
    }

    @Override
    public Vehicle setType(String type) {
        return super.setType("Car  - " + type);
    }

}

class Bus extends Vehicle{

    public Bus(String type, String color) {
        super("Bus - "+type, color);
            if(type.compareTo("Mercedes") == 0){
                this.setService_charge(5000);
                this.setEmployee_charge(1000);
            }
            else if(type.compareTo("BMW") == 0){
                this.setService_charge(7000);
                this.setEmployee_charge(1500);
            }
            else{
                this.setService_charge(5700);
                this.setEmployee_charge(2000);
            }
    }

    @Override
    public Vehicle setType(String type) {
        return super.setType("Bus  - " + type);
    }


}