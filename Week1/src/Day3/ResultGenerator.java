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
public class ResultGenerator {
    
    public static void generateResult(Student student){
        System.out.println("Student Name : " + student.getName() + ", Student id :"
                + " " + student.getId() );
        Subjects sub = student.getSubjects();
        //sub.display();
        float[] marks = sub.getMarks();
        float sum = 0;
        for(float mark : marks){
            //System.out.println(mark + "res");
            sum += mark;
        }
        System.out.println("Total marks = " + sum);
        System.out.println("Average mark = " + sum/3);
        //student.display();
    }
    
}
