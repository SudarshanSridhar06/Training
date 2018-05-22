/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1_2;
import java.util.*;

/**
 *
 * @author cb-sudarshan
 */

public class Ex1 {
    
    public static void main(String[] args){
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        
        String[] words = {"Hello", "World", "Good", "Hey", "Excellent",
        "Great", "Nice", "Food", "Eat", "Raw"};
        
        ArrayList<String>[] lists = (ArrayList<String>[])new ArrayList[10];
        
        for(String word : words){
            int length = word.length();
            if(lists[length] == null)
                lists[length] = new ArrayList<String>();
            lists[length].add(word);
        }
        
        for(int i = 0; i < 10; i++){
            if(lists[i] != null)
                map.put(i, lists[i]);
        }
        
        map.forEach((key, values) -> System.out.println("key: " + key + " value:" + values));
        
    }
    
}
