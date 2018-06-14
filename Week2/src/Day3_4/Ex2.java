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
public class Ex2 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the filename");
        String filename = sc.next();

        Map<String, Integer> mapToCountWords = new TreeMap<>();

        File file = null;
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedWriter buffWriter = null;
        BufferedReader buffReader = null;

        try {

            file = new File(filename);
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(new File("/Users/cb-sudarshan/fileCopy.txt"));
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

        Scanner sc1 = new Scanner(file);
        String word = null;

        while (sc1.hasNext()) {

            word = sc1.next().replaceAll("[^A-Za-z0-9]", "");

            if (mapToCountWords.containsKey(word.toUpperCase())) {

                mapToCountWords.put(word.toUpperCase(), mapToCountWords.get(word.toUpperCase()) + 1);

            } else {

                mapToCountWords.put(word.toUpperCase(), 1);

            }
            System.out.println(word);
        }

        Set<String> keys = mapToCountWords.keySet();

        for (String key : keys) {

            buffWriter.write(key + " : " + mapToCountWords.get(key) + "\n");

        }
        
        buffWriter.close();
        fileWriter.close();
        buffReader.close();
        fileReader.close();
    }

}
