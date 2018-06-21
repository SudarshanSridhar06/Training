/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template sourceFile, choose Tools | Templates
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

        Scanner scanner = new Scanner(System.in);
        System.out.println("File name..");
        //   /Users/cb-sudarshan/file.txt
        String sourceFilename = scanner.next();

        File sourceFile = new File(sourceFilename);
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedWriter buffWriter = null;
        BufferedReader buffReader = null;

        try {
            
            fileReader = new FileReader(sourceFile);
            

        } catch (FileNotFoundException e) {
            
            System.err.println(e);
            System.exit(0);
            
        }
        
        System.out.println("SearchWord..");
        String searchWord = scanner.next().toUpperCase();
        File targetFile = new File("/Users/cb-sudarshan/" + searchWord + ".locations.txt");
        
        try{
            
            fileWriter = new FileWriter(targetFile);
            
        } catch (IOException e) {
            
            System.err.println(e);
            System.exit(0);
            
        }
        
        buffWriter = new BufferedWriter(fileWriter);
        buffReader = new BufferedReader(fileReader);
        
        String textLine = buffReader.readLine();
        int linecount = 1;
        boolean found = false;

        while (textLine != null) {
            textLine = textLine.toUpperCase();
            if (textLine.contains(searchWord)) {

                found = true;
                StringBuilder writeToFile = new StringBuilder("");
                writeToFile.append(linecount);
                writeToFile.append(" : ");

                while (textLine.contains(searchWord)) {

                    writeToFile.append(textLine.indexOf(searchWord));
                    writeToFile.append(",");
                    textLine = textLine.replaceFirst(searchWord, "");

                }

                writeToFile.setCharAt(writeToFile.length() - 1, '.');
                buffWriter.write(writeToFile.toString() + "\n");

            }

            linecount++;
            textLine = buffReader.readLine();

        }

        if (!found) {
            System.out.println("Word Not Found");
            targetFile.delete();
        }

        buffWriter.close();
        fileWriter.close();
        buffReader.close();
        fileReader.close();
    }

}
