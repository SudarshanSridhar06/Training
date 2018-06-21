/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;

/**
 *
 * @author cb-sudarshan
 */
public class Mark {
    
    public enum Subject{
        HINDI, ENGLISH, MATHS, SCIENCE, SOCIALSCIENCE; 
        
    }
    private Subject subject;
    private int mark;

    public Mark(String subject, int mark) {
        this.subject = Subject.valueOf(subject);
        this.mark = mark;
    }

    public String getSubject() {
        return subject.toString();
    }

    public Mark setSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public int getMark() {
        return mark;
    }

    public Mark setMark(int mark) {
        this.mark = mark;
        return this;
    }
    
    @Override
    public String toString(){
        StringBuilder toDisplay = new StringBuilder();
        toDisplay.append(this.subject.toString());
        toDisplay.append(":");
        toDisplay.append(this.mark);
        toDisplay.append("\n");
        return toDisplay.toString();
    }
    
}
