/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day5;
import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
class Employee{
    private String name;
    private int age;
    private int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }
    
    public void display(){
        System.out.println("Name : " + this.name + ", Age : " + this.age + ", Salary : " + this.salary);
    }
}

public class AnonymousClass {
    
    public static void main(String[] args){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("name", 20, 10000));
        employees.add(new Employee("bala", 21, 15000));
        employees.add(new Employee("arun", 19, 12000));
        employees.add(new Employee("yoga", 25, 11500));
        employees.add(new Employee("aadh", 19, 12000));
        
        System.out.println("Employee List before Sorting :\n");
        for(Employee employee : employees)
            employee.display();
        
        System.out.println("\nEmployee List after sorting by age :\n");
        Collections.sort(employees, new Comparator(){
            public int compare(Object ob1, Object ob2){
                Employee temp = (Employee)ob1;
                Employee temp1 = (Employee)ob2;
                return temp.getAge()-temp1.getAge();
            }
        });
        for(Employee employee : employees)
            employee.display();
        
        System.out.println("\nEmployee List after sorting by name :\n");
        Collections.sort(employees, new Comparator(){
            public int compare(Object ob1, Object ob2){
                Employee temp = (Employee)ob1;
                Employee temp1 = (Employee)ob2;
                return temp.getName().compareTo(temp1.getName());
            }
        });
        for(Employee employee : employees)
            employee.display();
        
        System.out.println("\nEmployee List after sorting by salary :\n");
        Collections.sort(employees, new Comparator(){
            public int compare(Object ob1, Object ob2){
                Employee temp = (Employee)ob1;
                Employee temp1 = (Employee)ob2;
                return temp.getSalary()-temp1.getSalary();
            }
        });
        for(Employee employee : employees)
            employee.display();
    }
}
