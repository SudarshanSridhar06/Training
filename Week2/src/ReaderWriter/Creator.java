/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReaderWriter;

import java.io.*;

/**
 *
 * @author cb-sudarshan
 */
public class Creator {
    
    public static BufferedWriter createWriter(String filePath) throws Exception {
        FileWriter fileWriter = new FileWriter(new File(filePath));
        return new BufferedWriter(fileWriter);
    }
    
    public static BufferedReader createReader(String filePath) throws Exception {
        FileReader fileReader = new FileReader(new File(filePath));
        return new BufferedReader(fileReader);
    }
    
}
