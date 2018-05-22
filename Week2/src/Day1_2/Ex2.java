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

public class Ex2 {
    public static void main(String[] args){
        HashMap<String, List<String>> map = new HashMap<>();
        
        String[] words = {"Dig", "Digest", "Memory", "Memorandum", "Plead", 
        "Please", "Pleasure", "Dignity", "Sincere", "Sinusoidal", "Ball", "Antenna"
        , "Baleno", "Antivirus"};
        
        ArrayList<String>[] lists = (ArrayList<String>[])new ArrayList[10];
        int count = 0;
        //System.out.println(words[0].startsWith("Di"));
        
        for(int i = 0; i < words.length; i++){
            //System.out.println(words[i]);
            if(words[i].compareTo("") != 0){
                lists[count] = new ArrayList<>();
                String prefix = words[i].substring(0, 3);
                for(int j = i; j < words.length; j++){
                    if(words[j].compareTo("") != 0 && words[j].startsWith(prefix)){
                        lists[count].add(words[j]);
                        words[j] = "";
                    }
                }
                //System.out.println(lists);
                map.put(prefix, lists[count++]);         
            }
        }
        
        TreeMap<String, List<String>> sorted = new TreeMap<>();
        sorted.putAll(map);
        
        sorted.forEach((key, values) -> System.out.println("key: " + key + " value:" + values));
        
    }
}
