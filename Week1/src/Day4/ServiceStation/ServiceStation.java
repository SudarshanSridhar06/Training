/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day4.ServiceStation;
import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
class Person{
    private final String name;
    private String address;
    private String contact;
    private Vehicle vehicle;
    private final int employee_id;
    private final int customer_id;
    private static int emp = 100;
    private static int cust = 100;
    private ArrayList<Person> customers;
    

    public Person(String name, String address, String contact, Vehicle vehicle, boolean emp, boolean cust) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.vehicle = vehicle;
        if(emp == true){
            this.employee_id = ++this.emp;
        }
        else{
            this.employee_id = 0;
        }
        if(cust == true){
            this.customer_id = ++this.cust;
        }
        else{
            this.customer_id = 0;
        }
        if(emp == false && cust == true){
            customers = null;
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public List<Person> getCustomers() {
        return customers;
    }

    public Person setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Person setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    } 

    public Person setCustomers(ArrayList<Person> customers) {
        this.customers = customers;
        return this;
    }
     
}

public class ServiceStation {
    
    public static void displayCharges(){
        System.out.println("Bike - Yamaha, Service Charge :1000, EmployeeCharge : 200");
        System.out.println("Bike - Suzuki, Service Charge : 900, EmployeeCharge : 200");
        System.out.println("Bike - Others, Service Charge : 800, EmployeeCharge : 100");
        System.out.println("Car - Volkswagen, Service Charge : 2000, EmployeeCharge : 500");
        System.out.println("Car - Volvo, Service Charge : 2500, EmployeeCharge : 700");
        System.out.println("Car - Others, Service Charge : 2200, EmployeeCharge : 600");
        System.out.println("Bus - Mercedes, Service Charge : 5000, EmployeeCharge : 1000");
        System.out.println("Bus - BMW, Service Charge : 7000, EmployeeCharge : 1500");
        System.out.println("Bus - Others, Service Charge : 5700, EmployeeCharge : 2000");
    }
    
    public static void main(String[] args){
        ServiceStation.displayCharges();
        ArrayList<Person> persons = new ArrayList<>();
        ArrayList<Invoice> invoices = new ArrayList<>();
        
        Person emp1 = new Person("Emp1", "Coimbatore", "9988998899", 
                new Bike("Yamaha", "Black"), true, false);
        Person empcust = new Person("Emp2", "Chennai", "123456789", 
                new Car("Volvo", "White"), true, true);
       
        persons.add(emp1);
        persons.add(empcust);
        persons.add(new Person("Cust1", "Chennai", "1928374656",
                new Bike("Suzuki", "Grey"), false, true));
        
        invoices.add(new Invoice(persons.get(2), emp1));
        invoices.add(new Invoice(empcust, emp1));
        
        invoices.forEach(invoice -> {invoice.display();});
        
        
        
    }
    
}
