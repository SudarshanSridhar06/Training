/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;
import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
public class StudentDemoMain {
    
    static int id = 101;
    
    public void storeStudentData(Student s){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Student name..");
        String name = sc.next();
        boolean gender;
        System.out.println("Gender ? M/F");
        gender = sc.next().compareTo("M") == 0;
        
        System.out.println("Enter the 3 subjetcs name separated by space");
        Subjects sub = new Subjects();
        
        String[] subs = sc.next().split(",");
        //System.out.println(subs.length);
        
        System.out.println("Enter 3 Marks");
        float[] marks = new float[3];
        
        for(int i = 0; i < 3; i++)
            marks[i] = (float)sc.nextFloat();
        
        sub.setMarks(marks);
        sub.setSubject_name(subs);
        
        s.setGender(gender);
        s.setId(id);
        s.setName(name);
        s.setSubjects(sub);
        id++;
        
        ResultGenerator.generateResult(s);
        
    }
    
    public static void main(String[] args){
        StudentDemoMain demo = new StudentDemoMain();
        String check;
        do{
            Scanner sc = new Scanner(System.in);
            Student stud = new Student();
            demo.storeStudentData(stud);
            System.out.println("Want to create another student? Y/N");
            check = sc.next();
        }
        while(check.compareTo("Y") == 0);
        
    }
    
}
