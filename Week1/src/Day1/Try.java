/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1;

/**
 *
 * @author cb-sudarshan
 */

class Try1{
    String name ;
    
    public Try1(String n){
      name = n;   
    }
    
    public String getName(){
        return name;
    }
    
    public void display(){
        System.out.println(name);
    }
    
}

class Try2{
    private final Try1 obj;
    
    public Try2(Try1 o){
        obj = o;
    }
    
    public void change(){
        obj.name = "Changed";
    }
    
    public void display(){
        System.out.println(obj.getName());
    }
}

public class Try {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Try1 ob = new Try1("original");
        ob.display();
        Try2 obj = new Try2(ob);
        obj.display();
        obj.change();
        obj.display();
        ob.display();
    }
    
}
