/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3_4;

import com.opencsv.CSVReader;
import java.io.*;
import java.util.*;
import Day1_2.*;

/**
 *
 * @author cb-sudarshan
 */
public class Ex4R {

    public static void main(String[] args) throws Exception {

        CSVReader csvReader = null;

        //HashMap<String, List<List<String>>> customerDetailsMap = new HashMap<>();
        
        //List<List<String>> customerDetailsListToAddInMap = null;

        FileWriter csvWriter = null;
        boolean isHeader = true;

        int[] check_column = {0, 1, 12, 13, 14};

        try {

            csvReader = new CSVReader(new FileReader("/Users/cb-sudarshan/Training/Downloads/Files/input.csv"));
            csvWriter = new FileWriter("/Users/cb-sudarshan/Training/Week2/OutputR.csv");

        } catch (FileNotFoundException e) {

            System.err.println(e);
            System.exit(0);

        } catch (IOException e) {
            System.err.println(e);
            System.exit(0);
        }

        String[] row = null;
        List<String> uniqueRecordsCheckerList = new ArrayList<>();

        while ((row = csvReader.readNext()) != null) {
            List<String> customerRecordNew = Arrays.asList(row);
            StringBuilder checkerRecord = new StringBuilder("");

            if (isHeader) {
                csvWriter.append(String.join(",", customerRecordNew));
                csvWriter.append("\n");
                isHeader = false;
                continue;
            }

            for (int index : check_column) {
                checkerRecord.append(row[index]);
            }
            if (uniqueRecordsCheckerList.contains(checkerRecord.toString())) {
                continue;
            }

            uniqueRecordsCheckerList.add(checkerRecord.toString());
            csvWriter.append(String.join(",", customerRecordNew));
            csvWriter.append("\n");

        }

        csvWriter.flush();
    }

}
