/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template sourceFile, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3_4;

import java.io.*;
import java.util.regex.*;
import java.util.*;
import static ReaderWriter.Creator.*;

/**
 *
 * @author cb-sudarshan
 */
public class Ex3 {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String sourceFilename = "/Users/cb-sudarshan/file.txt";
        BufferedWriter buffWriter = null;
        BufferedReader buffReader = null;

        try {

             buffReader = createReader(sourceFilename);

        } catch (FileNotFoundException e) {

            System.err.println(e);
            System.exit(0);

        }

        System.out.println("SearchWord..");
        String searchWord = scanner.next();
        StringBuilder searchWordBuilder = new StringBuilder("\\b");
        searchWordBuilder.append(searchWord).append("\\b");
        File targetFile = new File("/Users/cb-sudarshan/" + searchWord.toLowerCase() + ".locations.txt");

        try {

             buffWriter = createWriter("/Users/cb-sudarshan/" + searchWord.toLowerCase() + ".locations.txt");

        } catch (IOException e) {

            System.err.println(e);
            System.exit(0);

        }

        String textLine = buffReader.readLine();
        int linecount = 1;
        boolean found = false;

        while (textLine != null) {
            
            boolean first = true;
            textLine = String.join(" ", textLine.split("[!?()\"]")).replaceAll(" +", " ");
            //System.out.println(textLine);
            StringBuilder writeToFile = new StringBuilder("");
            
            Pattern pattern = Pattern.compile(searchWordBuilder.toString(), Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(textLine);
            
            while (matcher.find()) {
                
                found = true;
                if (first) {
                    writeToFile.append(linecount);
                    writeToFile.append(" : ");
                    first = false;
                }
                writeToFile.append(matcher.start());
                writeToFile.append(",");
                
            }
            
            if (writeToFile.length() != 0) {
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
        buffReader.close();
    }

}
