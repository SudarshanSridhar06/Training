/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day5;
import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
class Mobile{
    private String name;
    private String remainingCharge;
    
    public Mobile(String name){
        this.name = name;
    }
    
    public void name(){
        System.out.print("Name : " + name + ", ");
    }
    
    public void remainingCharge(){
        System.out.println("Remaining Charge : " + remainingCharge);
    }
}

public class MobileAnonymousClassMain {
    
    public static void main(String[] args){
        List<Mobile> mobiles = new ArrayList<>();
        
        mobiles.add(new Mobile("Moto"){
            @Override
            public void remainingCharge(){
                System.out.println("Remaining Charge : 25");
            }
        });
        
        mobiles.add(new Mobile("Nokia"){
            @Override
            public void remainingCharge(){
                System.out.println("Remaining Charge : 50");
            }
        });
        
        mobiles.add(new Mobile("Samsung"){
            @Override
            public void remainingCharge(){
                System.out.println("Remaining Charge : 45");
            }
        });
        
        mobiles.add(new Mobile("Lenovo"){
            @Override
            public void remainingCharge(){
                System.out.println("Remaining Charge : 89");
            }
        });
        
        for(Mobile mobile : mobiles){
            mobile.name();
            mobile.remainingCharge();
        }
    }
    
}
