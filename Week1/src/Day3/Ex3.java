/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

import java.util.ArrayList;

/**
 *
 * @author cb-sudarshan
 */

class Employee{
    private final String name;
    private final char gender;
    private double income;
    private double tax;

    public Employee(String name, char gender, double income) {
        this.name = name;
        this.gender = gender;
        this.income = income;
        this.tax = 0;
    } 

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public double getIncome() {
        return income;
    }

    public Employee setIncome(double income) {
        this.income = income;
        return this;
    }

    public double getTax() {
        return tax;
    }

    public Employee setTax(double tax) {
        this.tax = tax;
        return this;
    }
    
    public void display(double amount){
        System.out.println("[ " + this.name + " ][ " + this.gender + " ] "
                + "TaxableIncome [ " + amount + " ] Tax [ " + this.tax + " ]");
    }
    
    public static void calculateTax(Employee employee){
        Double taxableamount = (double)0;
        // 10% of income exceeding 50k as tax for male employees
        if(employee.gender == 'M' && employee.income > 50000){
            taxableamount = employee.income - 50000;
            employee.tax = (taxableamount) / 10;
            
        }
        
        // 7% of income exceeding 60k as tax for female employees
        if(employee.gender == 'F' && employee.income > 60000){
            taxableamount = employee.income - 60000;
            employee.tax = (taxableamount) * 7 / 100;
        }
        
        employee.display(taxableamount);
    }
    
}

public class Ex3 {
    
    public static void main(String[] args){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Emp1",'M',50000));
        employees.add(new Employee("Emp2",'M',60000));
        employees.add(new Employee("Emp3",'F',76000));
        employees.add(new Employee("Emp4",'F',60000));
        
        for(Employee employee : employees)
            Employee.calculateTax(employee);
    }
    
}
