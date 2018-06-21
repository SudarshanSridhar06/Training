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
public class Student {
    
    private String name;
    private String dateOfJoining;
    private String id;
    private String standard;
    private Mark[] marks;   
    
    public Student(){
        
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public Student setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
        return this;
    }

    public String getId() {
        return id;
    }

    public Student setId(String id) {
        this.id = id;
        return this;
    }

    public String getStandard() {
        return standard;
    }

    public Student setStandard(String standard) {
        this.standard = standard;
        return this;
    }

    public Mark[] getMarks() {
        return marks;
    }

    public Student setMarks(Mark[] marks) {
        this.marks = new Mark[marks.length];
        this.marks = Arrays.copyOf(marks, marks.length);
        return this;
    }

    @Override
    public String toString(){
        StringBuilder toDisplay = new StringBuilder();
        toDisplay.append(this.name);
        toDisplay.append("\n");
        toDisplay.append(this.standard);
        toDisplay.append("\n");
        toDisplay.append(this.id);
        toDisplay.append("\n");
        for(int i = 0; i< marks.length; i++){
            toDisplay.append(this.marks[i]);
        }
        return toDisplay.toString();
    }
    
}
