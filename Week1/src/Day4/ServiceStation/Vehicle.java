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
class Vehicle {
    public enum Service{
        WATERWASH(200), FULLCHECK(500), DAMAGE(1000);
        
        private int service_charge;
        
        Service(int charge){
            this.service_charge = charge;
        }
        
        public int getServiceCharge(){
            return this.service_charge;
        }
        
    }
    
    public enum VehicleType{
        BIKE(1,200), CAR(2,300), BUS(3,600);
        
        private int factor;
        private int employee_charge;
        
        VehicleType(int factor, int employee_charge){
            this.factor = factor;
            this.employee_charge = employee_charge;                  
        }
        
        public int getFactor(){
            return this.factor;
        }
        
        public int getEmployeeCharge(){
            return this.employee_charge;
        }
                
    }
    
    private final VehicleType type;
    private String color;
    private final Service service;
    private final int service_charge;
    private final int employee_charge;

    public Vehicle(String type, String color, String service) {
        if(type.toUpperCase().equals("BIKE"))
            this.type = VehicleType.BIKE;
        else if(type.toUpperCase().equals("BUS"))
            this.type = VehicleType.BUS;
        else
            this.type = VehicleType.CAR;
        
        this.color = color;
        
        if(service.toUpperCase().equals("WATERWASH"))
            this.service = Service.WATERWASH;
        else if(service.toUpperCase().equals("FULLCHECK"))
            this.service = Service.FULLCHECK;
        else
            this.service = Service.DAMAGE;
        
        this.service_charge = this.type.getFactor() * this.service.getServiceCharge();
        this.employee_charge = this.type.getEmployeeCharge();
    } 

    public String getType() {
        return type.toString();
    }

    public String getColor() {
        return color;
    }

    public String getService() {
        return service.toString();
    }

    public int getService_charge() {
        return service_charge;
    }

    public int getEmployee_charge() {
        return employee_charge;
    }

    public Vehicle setColor(String color){
        this.color = color;
        return this;
    }
    
}

//class Bike extends Vehicle{
//
//    public Bike(String color, String service) {
//            super("Bike - ", color, service);
//            if(type.compareTo("Yamaha") == 0){
//                this.setService_charge(1000);
//                this.setEmployee_charge(200);
//            }
//            else if(type.compareTo("Suzuki") == 0){
//                this.setService_charge(900);
//                this.setEmployee_charge(200);
//            }
//            else{
//                this.setService_charge(800);
//                this.setEmployee_charge(100);
//            }
//            
//    }
//
//    @Override
//    public Vehicle setType(String type) {
//        return super.setType("Bike  - " + type);
//    }
//    
//}
//
//class Car extends Vehicle{
//
//    public Car(String type, String color) { 
//        super("Car - "+type, color);
//            if(type.compareTo("Volkaswagen") == 0){
//                this.setService_charge(2000);
//                this.setEmployee_charge(500);
//            }
//            else if(type.compareTo("Volvo") == 0){
//                this.setService_charge(2500);
//                this.setEmployee_charge(700);
//            }
//            else{
//                this.setService_charge(2200);
//                this.setEmployee_charge(600);
//            }
//    }
//
//    @Override
//    public Vehicle setType(String type) {
//        return super.setType("Car  - " + type);
//    }
//
//}
//
//class Bus extends Vehicle{
//
//    public Bus(String type, String color) {
//        super("Bus - "+type, color);
//            if(type.equals("Mercedes")){
//                this.setService_charge(5000);
//                this.setEmployee_charge(1000);
//            }
//            else if(type.compareTo("BMW") == 0){
//                this.setService_charge(7000);
//                this.setEmployee_charge(1500);
//            }
//            else{
//                this.setService_charge(5700);
//                this.setEmployee_charge(2000);
//            }
//    }
//
//    @Override
//    public Vehicle setType(String type) {
//        return super.setType("Bus  - " + type);
//    }
//
//
//}