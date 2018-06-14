/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1_2;
import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
public class Person {
    private final String name;
    private Address address;
    private List<Phone> phone;
    
    public Person(String name, Address add, List<Phone> phone){
        this.name = name;
        this.address = add;
        this.phone = new ArrayList<>(phone);
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Phone> getPhone() {
        return phone;
    }
    
    @Override
    public String toString(){
        return this.name + this.address + this.phone + "\n";
    }
    
}
