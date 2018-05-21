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
public class ResultGenerator {
    
    public static void generateResult(Student student){
        System.out.println("Student Name : " + student.getName());
        Subjects sub = student.getSubjects();
        float[] marks = sub.getMarks();
        float sum = 0;
        for(float mark : marks){
            sum += mark;
        }
        System.out.println("Total marks = " + sum);
        System.out.println("Average mark = " + sum/3);
    }
    
}
