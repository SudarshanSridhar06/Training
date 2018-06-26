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
public class Ex4 {

    public static void main(String[] args) throws Exception {

        CSVReader csvReader = null;

        HashMap<String, List<List<String>>> customerDetailsMap = new HashMap<>();
        List<String> customer_recordNew = null;
        List<List<String>> customerDetailsListToAddInMap = null;

        FileWriter csvWriter = null;
        boolean isHeader = true;

        int[] check_column = {0, 1, 12, 13, 14};

        try {

            csvReader = new CSVReader(new FileReader("/Users/cb-sudarshan/Training/Downloads/Files/input.csv"));
            csvWriter = new FileWriter("/Users/cb-sudarshan/Training/Week2/Output.csv");

        } catch (FileNotFoundException e) {

            System.err.println(e);
            System.exit(0);
            
        } catch (IOException e) {
            System.err.println(e);
            System.exit(0);
        }

        String[] row = null;

        while ((row = csvReader.readNext()) != null) {

            customer_recordNew = Arrays.asList(row);
            customerDetailsListToAddInMap = new ArrayList<>();

            if (isHeader) {
                csvWriter.append(String.join(",", customer_recordNew));
                csvWriter.append("\n");
                isHeader = false;
                continue;
            }

            if (customerDetailsMap.get(row[0]) != null) {
                boolean insertRecord = true;
                customerDetailsListToAddInMap = customerDetailsMap.get(row[0]);

                for (List<String> customerRecord : customerDetailsListToAddInMap) {
                    if (insertRecord) {
                        for (int index : check_column) {

                            if (!customer_recordNew.get(index).equals(customerRecord.get(index))) {

                                insertRecord = true;
                                break;

                            } else {

                                insertRecord = false;

                            }

                        }
                    }

                }
                if (insertRecord) {
                    customerDetailsListToAddInMap.add(customer_recordNew);
                    customerDetailsMap.put(row[0], customerDetailsListToAddInMap);
                }

            } else {

                customerDetailsListToAddInMap.add(customer_recordNew);
                customerDetailsMap.put(row[0], customerDetailsListToAddInMap);

            }
        }

        System.out.println(customerDetailsMap.size());

        Set<String> keySet = customerDetailsMap.keySet();

        for (String key : keySet) {
            customerDetailsListToAddInMap = customerDetailsMap.get(key);
            for (List<String> record : customerDetailsListToAddInMap) {
                csvWriter.append(String.join(",", record));
                csvWriter.append("\n");
            }
        }
        csvWriter.flush();
    }

}
