/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.text.*;
import java.util.*;
import org.apache.commons.csv.*;
import org.json.*;

/**
 *
 * @author cb-sudarshan
 */

public class JsonConfigEx3 {

    public static void main(String[] args) throws ParseException, IOException, JSONException {

        FileWriter csvWriter = null;
        String JSONtext = "";

        String sourceFilename = "/Users/cb-sudarshan/Training/Downloads/Files/sample-input.csv";

        BufferedReader inputReader = null;

        try {
            
            JSONtext = new String(Files.readAllBytes(Paths.get("/Users/cb-sudarshan/JsonConfig.json")), StandardCharsets.UTF_8);           
            csvWriter = new FileWriter("/Users/cb-sudarshan/Training/sample-output.csv");
            inputReader = new BufferedReader(new FileReader(new File(sourceFilename)));

        } catch (FileNotFoundException e) {

            System.err.println(e);
            System.exit(0);

        }
        CSVFormat format = CSVFormat.newFormat(',').withHeader();
        CSVParser csvParser = new CSVParser(inputReader, format);

        JSONObject jsonObject = new JSONObject(JSONtext);
        List<CSVRecord> csvRecords = csvParser.getRecords();

        Map<String, Integer> headerMap = csvParser.getHeaderMap();
        System.out.println(headerMap);

        for (CSVRecord record : csvRecords) {//for every csv record
            Map<String, String> EachRecordMap = record.toMap();

            Iterator jsonKeyIterator = jsonObject.keys();
            
            while (jsonKeyIterator.hasNext()) { //for every key in json

                String key = (String) jsonKeyIterator.next();
                JSONObject keyObj = (JSONObject) jsonObject.get(key);
                String type = (String) keyObj.get("Type");
                //modify and update in EachRecordMap
                switch (type) {
                    
                    case "Date":
                        String strdate = EachRecordMap.get(key);
                        DateFormat originalFormat = new SimpleDateFormat(keyObj.getString("InputTimeStamp"));
                        DateFormat targetFormat = new SimpleDateFormat(keyObj.getString("OutputTimeStamp"));
                        Date date = originalFormat.parse(strdate);
                        String formattedDate = targetFormat.format(date);
                        EachRecordMap.put(key, formattedDate);
                        break;
                        
                    case "Number":
                        Double csvValue = Double.valueOf(EachRecordMap.get(key));
                        if (keyObj.get("Operator").equals("+")) {
                            csvValue += Integer.parseInt((String) keyObj.get("Value"));
                        } else if (keyObj.get("Operator").equals("-")) {
                            csvValue -= Integer.parseInt((String) keyObj.get("Value"));
                        } else if (keyObj.get("Operator").equals("*")) {
                            csvValue *= Integer.parseInt((String) keyObj.get("Value"));
                        } else {
                            csvValue /= Integer.parseInt((String) keyObj.get("Value"));
                        }
                        EachRecordMap.put(key, Double.toString(csvValue));
                        break;
                        
                    case "Modify":
                        
                        JSONArray removeFields = keyObj.getJSONArray("Remove Fields");
                        JSONArray fieldNames = keyObj.getJSONArray("Field Name");
                        StringBuilder customerDetails = new StringBuilder();
                        customerDetails.append("{");
                        //removing the specified fields and appending them as one
                        for (int i = 0; i < removeFields.length(); i++) {
                            
                            headerMap.remove((String) removeFields.get(i));
                            customerDetails.append("\"");
                            customerDetails.append((String) fieldNames.get(i));
                            customerDetails.append("\" : \"");
                            customerDetails.append(record.get((String) removeFields.get(i)));
                            customerDetails.append("\"");
                            
                        }
                        
                        customerDetails.setCharAt(customerDetails.length() - 1, '}');
                        headerMap.put(key, 14);
                        String[] csvHeaders = headerMap.keySet().toArray(new String[0]);
                        csvWriter.append(String.join(",", csvHeaders));
                        csvWriter.append("\n");
                        //System.out.println(headerMap);
                        EachRecordMap.put(key, customerDetails.toString());
                        break;

                }
            }

            Set<String> keyset = headerMap.keySet();

            int temp = 0;

            String[] updatedRecord = new String[keyset.size()];
            
            for (String Key : keyset) {
                updatedRecord[temp++] = EachRecordMap.get(Key);
            }
            
            csvWriter.append(String.join(",", updatedRecord));
            csvWriter.append("\n");
        }

        csvWriter.flush();
    }

}
