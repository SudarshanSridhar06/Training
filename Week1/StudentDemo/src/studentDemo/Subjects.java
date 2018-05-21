/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentDemo;
import java.util.*;

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

    public void setSubject_name(String[] subject_name) {
        int iter=0;
        for(String s:subject_name)
            subject_name[iter++] = s;
    }

    public float[] getMarks() {
        return marks;
    }

    public void setMarks(float[] marks) {
        int iter = 0;
        for(Float f:marks)
            marks[iter++] = f;
    }
    
    
    
}
