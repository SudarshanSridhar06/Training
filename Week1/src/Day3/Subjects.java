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
public class Subjects {
    
    private String[] subject_name;
    private float[] marks;
    
    public Subjects(){
        subject_name = new String[3];
        marks = new float[3];
    }
    
    public Subjects(String[] name, float[] marks){
        int iter=0;
        for(String s:name)
            subject_name[iter++] = s;
        iter = 0;
        for(Float f:marks)
            marks[iter++] = f;
    }

    public String[] getSubject_name() {
        return subject_name;
    }

    public Subjects setSubject_name(String[] subject_name) {
        int iter=0;
        for(String s:subject_name)
            this.subject_name[iter++] = s;
        return this;
    }

    public float[] getMarks() {
        return marks;
    }

    public Subjects setMarks(float[] marks) {
        int iter = 0;
        for(Float f:marks){
            this.marks[iter++] = f;
            //System.out.println(marks[iter-1] +"set");
        }
        return this;
    }
    
    public void display(){
        for(String s : subject_name)
            System.out.println(s);
        for(Float f : marks)
            System.out.println(f);
    }
    
    
    
}
