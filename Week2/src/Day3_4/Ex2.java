/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3_4;

import java.io.*;
import java.util.*;
import org.apache.commons.lang3.*;
import static ReaderWriter.Creator.*;

/**
 *
 * @author cb-sudarshan
 */
public class Ex2 {

//    public static BufferedWriter createWriter(String filePath) throws Exception {
//        FileWriter fileWriter = new FileWriter(new File(filePath));
//        return new BufferedWriter(fileWriter);
//    }
//    
//    public static BufferedReader createReader(String filePath) throws Exception {
//        FileReader fileReader = new FileReader(new File(filePath));
//        return new BufferedReader(fileReader);
//    }

    public static void updateMap(String key, Map<String, Integer> map) {
        if (map.containsKey(key)) {

            map.put(key, map.get(key) + 1);

        } else {

            map.put(key, 1);

        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String filename = "/Users/cb-sudarshan/file.txt";

        Map<String, Integer> mapToCountWords = new HashMap<>();

        File file = new File(filename);

        BufferedWriter buffWriter = createWriter("/Users/cb-sudarshan/fileCopy.txt");
        Scanner scanner = new Scanner(file);
        String word = null;
        //yyyy-MM-dd HH:mm:ss.ssss
        while (scanner.hasNext()) {

            word = scanner.next();
            StringBuilder sb = null;

            String[] temp = word.split("[!?()\"]");
            for (String wordSplit : temp) {
                
                if (wordSplit.isEmpty()) {
                    continue;
                }
               
                sb = new StringBuilder(wordSplit);
                
                if (sb.toString().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"/*regex for email*/)) {
                    System.out.println(sb.toString().toUpperCase());
                    updateMap(sb.toString().toUpperCase(), mapToCountWords);
                    continue;
                }
                
                String urlRegex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&?.@#/%=~_|]";
                String urlRegex1 = "(http://|https://)(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?";
                
                if (sb.toString().matches(urlRegex)) {
                    System.out.println(sb.toString().toUpperCase());
                    updateMap(sb.toString().toUpperCase(), mapToCountWords);
                    continue;
                }

                if (sb.charAt(wordSplit.length() - 1) == ',' || sb.charAt(wordSplit.length() - 1) == '.') {
                    sb.deleteCharAt(wordSplit.length() - 1);
                }
                
                if(sb.length() != 0){
                    
                    updateMap(sb.toString().toUpperCase(), mapToCountWords);
                    
                }
                

            }

        }
        
        

        Set<String> keys = mapToCountWords.keySet();

        for (String key : keys) {
            //System.out.println(key + " : " + mapToCountWords.get(key));
            buffWriter.write(key + " : " + mapToCountWords.get(key) + "\n");
        }

        buffWriter.close();

    }

}
