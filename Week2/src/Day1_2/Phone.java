/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1_2;

/**
 *
 * @author cb-sudarshan
 */
public class Phone {
    
    private enum PhoneType{
        MOBILE, WORK, HOME;
    }
    
    private String number;
    private PhoneType type;
    
    public Phone(String number, String type){
        this.number = number;
        this.type = PhoneType.valueOf(type.toUpperCase());
    }

    public String getNumber() {
        return number;
    }

    public PhoneType getType() {
        return type;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = PhoneType.valueOf(type.toUpperCase());
    } 
    
    @Override
    public String toString(){
        return type.toString() + " : " + this.number ;
    }
    
}
