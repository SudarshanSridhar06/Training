/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template sourceFile, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3_4;

import java.io.*;
import java.util.regex.*;
import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
public class Ex3R {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String sourceFilename = "/Users/cb-sudarshan/file1.txt";

        File sourceFile = new File(sourceFilename);
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {

            fileReader = new FileReader(sourceFile);

        } catch (FileNotFoundException e) {

            System.err.println(e);
            System.exit(0);

        }

        System.out.println("SearchWord..");
        String searchWord = scanner.next().toLowerCase();
        StringBuilder searchWordBuilder = new StringBuilder(searchWord);
        File targetFile = new File("/Users/cb-sudarshan/" + searchWord + ".locations.txt");

        try {

            fileWriter = new FileWriter(targetFile);

        } catch (IOException e) {

            System.err.println(e);
            System.exit(0);

        }

        BufferedWriter buffWriter = new BufferedWriter(fileWriter);
        BufferedReader buffReader = new BufferedReader(fileReader);
        Pattern pattern = Pattern.compile(searchWordBuilder.toString(), Pattern.CASE_INSENSITIVE);

        String textLine = buffReader.readLine();
        int linecount = 1;
        boolean found = false;

        while (textLine != null) {

            if (textLine.toLowerCase().contains(searchWord)) {

                StringBuilder writeToFile = new StringBuilder("");
                String[] wordsOfLine = textLine.split("[!?()\" ]");
                int count = 1;
                Map<Integer, Boolean> checkMap = new HashMap<>();

                for (String word : wordsOfLine) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();
                        if (word.contains(searchWord)) {
                            if (word.equals(searchWord)) {
                                checkMap.put(count, true);
                                found = true;
                            } else {
                                checkMap.put(count, false);
                            }
                            count++;
                        }
                    }
                }

                Matcher matcher = pattern.matcher(textLine);
                //System.out.println(textLine);
                count = 1;
                boolean first = true;
                while (matcher.find()) {

                    if (checkMap.get(count)) {
                        if (first) {
                            writeToFile.append(linecount);
                            writeToFile.append(" : ");
                            first = false;
                        }
                        writeToFile.append(matcher.start());
                        writeToFile.append(",");
                    }
                    count++;
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
        buffReader.close();
    }

}
