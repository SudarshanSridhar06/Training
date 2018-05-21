/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentDemo;

/**
 *
 * @author cb-sudarshan
 */
public class Student {
    
    private int id;
    private String name;
    private boolean gender;
    private Subjects subjects;
    
    public Student(){
        
    }

    public Student(int id, String name, boolean gender, Subjects subjects) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.subjects = subjects;
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }
    
    
    
}
