/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3_4;

import java.io.*;
import java.util.*;
import org.apache.commons.lang3.*;

/**
 *
 * @author cb-sudarshan
 */
public class Ex2 {
    
    
    public static BufferedWriter createWriter(String filePath) throws Exception{
        FileWriter fileWriter = null;
        fileWriter = new FileWriter(new File(filePath));
        return new BufferedWriter(fileWriter);
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        //   /Users/cb-sudarshan/file.txt
        String filename = "/Users/cb-sudarshan/file1.txt";

        Map<String, Integer> mapToCountWords = new HashMap<>();

        File file =  new File(filename);
        FileReader fileReader = null;

        try {

            fileReader = new FileReader(file);

        } catch (FileNotFoundException e) {

            System.err.println(e);
            System.exit(0);

        }

        BufferedWriter buffWriter = createWriter("/Users/cb-sudarshan/fileCopy.txt");
        BufferedReader buffReader = new BufferedReader(fileReader);
        Scanner scanner = new Scanner(file);
        String word = null;
        //yyyy-MM-dd HH:mm:ss.ssss
        while (scanner.hasNext()) {

            word = scanner.next();
            StringBuilder sb = null;
//            int count = StringUtils.countMatches("hello", "l");

            
            String[] temp = word.split("[!?()\"]");
            for (String string : temp) {
                if(string.isEmpty()){
                    continue;
                }
                sb = new StringBuilder(string);
//                sb.trimToSize(); why is this needed?
                //move url and emails outside the while loop
                if(sb.toString().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"/*regex for email*/)){
                    System.out.println(sb.toString());
                    continue;
                }
                String urlRegex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&?.@#/%=~_|]";
                String urlRegex1 = "(http://|https://)(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?";
                if(sb.toString().matches(urlRegex)){
                    System.out.println(sb.toString());
                    continue;
                }
//                if (sb.length() != 0) { Why is this needed
                    //System.out.println(sb.toString());
                if (sb.charAt(string.length() - 1) == ',' || sb.charAt(string.length() - 1) == '.') {
                    sb.deleteCharAt(string.length() - 1);
//                        sb.trimToSize(); //why???
                }
                if (sb.length() != 0) {
                    if (sb.charAt(0) == ',' || sb.charAt(0) == '.') {//What is the case here?
                        System.out.println("comma at the start: " + sb);
                        sb.deleteCharAt(0);
//                            sb.trimToSize(); //why?
                    }

                }
                if (sb.length() != 0) {
                    System.out.println(sb.toString().toUpperCase());
                }
//                }

            }

            if (mapToCountWords.containsKey(sb.toString().toUpperCase())) {

                mapToCountWords.put(sb.toString().toUpperCase(), mapToCountWords.get(sb.toString().toUpperCase()) + 1);

            } else {

                mapToCountWords.put(sb.toString().toUpperCase(), 1);

            }
            //System.out.println(word + ": " + mapToCountWords.get(word.toUpperCase()));
        }

        Set<String> keys = mapToCountWords.keySet();

        for (String key : keys) {

            buffWriter.write(key + " : " + mapToCountWords.get(key) + "\n");

        }

        buffWriter.close();
//        fileWriter.close();
        buffReader.close();
        fileReader.close();
    }

}
