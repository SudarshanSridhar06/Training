/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;

import java.util.Arrays;

/**
 *
 * @author cb-sudarshan
 */
public class Teacher {
    
    private String name;
    private String joiningDate;
    private long salary;
    private String id;
    private String[] handlingClasses;
    
    public Teacher(){
        
    }

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }

    public String getDate() {
        return joiningDate;
    }

    public Teacher setDate(String date) {
        this.joiningDate = date;
        return this;
    }

    public long getSalary() {
        return salary;
    }

    public Teacher setSalary(long salary) {
        this.salary = salary;
        return this;
    }

    public String getId() {
        return id;
    }

    public Teacher setId(String id) {
        this.id = id;
        return this;
    }

    public String[] getHandlingClasses() {
        return handlingClasses;
    }

    public Teacher setHandlingClasses(String[] handlingClasses) {
        this.handlingClasses = new String[handlingClasses.length];
        this.handlingClasses = Arrays.copyOf(handlingClasses, handlingClasses.length);
        return this;
    }
    
    public String toString(){
        StringBuilder toDisplay = new StringBuilder();
        toDisplay.append(this.name);
        toDisplay.append("\n");
        toDisplay.append(this.id);
        toDisplay.append("\n");
        toDisplay.append(this.salary);
        toDisplay.append("\n");
        toDisplay.append("HandlingClasses - ");
        toDisplay.append(Arrays.asList(handlingClasses));
        return toDisplay.toString();
    }
    
}
