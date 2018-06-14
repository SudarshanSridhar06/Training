/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3_4;

import java.io.*;
import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
public class Ex3 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("File name..");
        String filename = sc.next();

        System.out.println("SearchWord..");
        String searchWord = sc.next();

        File file = null;
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedWriter buffWriter = null;
        BufferedReader buffReader = null;


        try {

            file = new File(filename);
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(new File("/Users/cb-sudarshan/" + searchWord + ".locations.txt"));
            buffWriter = new BufferedWriter(fileWriter);
            buffReader = new BufferedReader(fileReader);
            
        } catch (IOException e) {
            
            System.err.println(e);
            System.exit(0);
            
        }

        if (!file.isFile()) {

            System.err.println("Input a valid text file");
            System.exit(0);

        }

        String textLine = buffReader.readLine();
        int linecount = 1;

        while (textLine != null) {

            if (textLine.contains(searchWord)) {

                StringBuilder writeToFile = new StringBuilder("");
                writeToFile.append(linecount);
                writeToFile.append(" : ");
                
                while (textLine.contains(searchWord)) {

                    writeToFile.append(textLine.indexOf(searchWord));
                    writeToFile.append(",");
                    textLine = textLine.replaceFirst(searchWord, "");
                    
                }
                
                writeToFile.setCharAt(writeToFile.length()-1, '.');
                buffWriter.write(writeToFile.toString() + "\n");
                
            }
            
            linecount++;
            textLine = buffReader.readLine();

        }
        
        buffWriter.close();
        fileWriter.close();
        buffReader.close();
        fileReader.close();
    }
    

}
