/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3_4;
import java.io.*;
import java.nio.file.*;
import java.util.*;
//import org.apache.commons.csv;

/**
 *
 * @author cb-sudarshan
 */
public class Ex4 {
    
    public static void main(String[] args){
        File csvFile = new File("/Users/cb-sudarshan/Downloads/Input.csv.xlsx");
        String line = "";
        int count=0;
        Path pathToFile = Paths.get("/Users/cb-sudarshan/Downloads/Input.csv.xlsx");

        try{
            Reader reader = Files.newBufferedReader(pathToFile);
            
        }
        catch (IOException e) {
            
            System.err.println(e);
            System.exit(0);
            
        }
//            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        
        
    }
    
}
