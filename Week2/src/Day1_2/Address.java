/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1_2;

/**
 *
 * @author cb-sudarshan
 */
public class Address {
    private int door_no;
    private String street;
    private String city;
    private String state;
    private int pincode;
    
    public Address(){
        
    }
    
    public Address(int no, String street, String city, String state, int pincode){
        this.door_no = no;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public int getDoorNo() {
        return door_no;
    }

    public String getStreet() {
        return street;
    }

    public Address setDoor_no(int door_no) {
        this.door_no = door_no;
        return this;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public Address setPincode(int pincode) {
        this.pincode = pincode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getPincode() {
        return pincode;
    }
    
    @Override
    public String toString(){
        return "\n" + Integer.toString(this.door_no) + ", " + this.street + ", " +
                this.city + ", " + this.state + ", " + Integer.toString(this.pincode) + "\n";
    }
    
}
