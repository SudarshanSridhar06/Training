/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

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

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isGender() {
        return gender;
    }

    public Student setGender(boolean gender) {
        this.gender = gender;
        return this;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public Student setSubjects(Subjects subjects) {
        this.subjects = subjects;
        return this;
    }

    public void display(){
        float[] marks = subjects.getMarks();
        String[] sub = subjects.getSubject_name();
        for(String s : sub)
            System.out.println(s);
        for(Float f : marks)
            System.out.println(f);
    }
      
}
