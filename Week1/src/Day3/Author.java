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
public class Author {
    
    private final String name;
    private String email;
    private final char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Author setEmail(String email) {
        this.email = email;
        return this;
    }

    public char getGender() {
        return gender;
    }
    
    public String toDisplay(){
        return "[ " + this.name + " ][ '" + this.gender + "' ] at [ " + this.email + " ]"; 
    }
    
}
