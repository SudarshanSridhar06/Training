/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3_4;

import Day1_2.*;
import java.io.*;
import java.util.*;
import org.apache.commons.csv.*;

/**
 *
 * @author cb-sudarshan
 */
public class Ex5 {

    public static void createCsvFile() throws IOException {

        FileWriter csvWriter = null;

        try {

            csvWriter = new FileWriter("/Users/cb-sudarshan/Training/Week2/PhoneDirectoryInput.csv");

        } catch (FileNotFoundException e) {

            System.err.println(e);
            System.exit(0);

        }

        csvWriter.append("Name,Door No,Street,City,State,Pincode,Mobile,Work,Home\n");
        csvWriter.append("Sudarshan,27,Arimalam Colony,Coimbatore, TN,641021, 8877323737,1223344567,9988776655\n");
        csvWriter.append("Random,123,adsf,Chennai,TN,123456,,123456789,,\n");
        csvWriter.append("xyz,12,qwerrty,Salem, Tn,641001,,1029384756,1298765432\n");
        csvWriter.append("xyz,22,dfv,Erode, Tn,641022,1029384756,,1265432987\n");
        csvWriter.flush();
    }

    public static void main(String[] args) throws IOException {
        createCsvFile();

        HashMap<String, List<Person>> mapOfPersons = new HashMap<>();
        BufferedReader inputReader = null;
        CSVParser csvParser = null;

        CSVFormat format = CSVFormat.newFormat(',').withHeader();
        
        try {
            
            inputReader = new BufferedReader(new FileReader(new File("/Users/cb-sudarshan/Training/Week2/PhoneDirectoryInput.csv")));
            
        } catch (FileNotFoundException e) {
            
            System.err.println(e);
            System.exit(0);
            
        }
        csvParser = new CSVParser(inputReader, format);
        
        List<CSVRecord> csvRecordOfPersons = csvParser.getRecords();
        
        for(CSVRecord personRecord : csvRecordOfPersons){
            
            String personName = personRecord.get("Name");
            Address personAddress = new Address(Integer.parseInt(personRecord.get("Door No")), personRecord.get("Street"),
                personRecord.get("City"), personRecord.get("State"), Integer.parseInt(personRecord.get("Pincode")));
            List<Phone> phoneListOfPerson = new ArrayList<>();
            
            if(!personRecord.get("Mobile").equals("")){
                phoneListOfPerson.add(new Phone(personRecord.get("Mobile"), "MOBILE"));
            }
            if(!personRecord.get("Work").equals("")){
                phoneListOfPerson.add(new Phone(personRecord.get("Work"), "WORK"));
            }
            if(!personRecord.get("Home").equals("")){
                phoneListOfPerson.add(new Phone(personRecord.get("Home"), "HOME"));
            }
            
            if(mapOfPersons.get(personName.toUpperCase()) != null){
                List<Person> tempList= mapOfPersons.get(personName.toUpperCase());
                tempList.add(new Person(personName, personAddress, phoneListOfPerson));
                mapOfPersons.put(personName.toUpperCase(), tempList);
            }
            else{
                List<Person> persons = new ArrayList<>();  
                persons.add(new Person(personName, personAddress, phoneListOfPerson));
                mapOfPersons.put(personName.toUpperCase(),persons);
            }
            
        }
        
        Set<String> keySet = mapOfPersons.keySet();
        for(String key : keySet){
            System.out.println(key);
            System.out.println(mapOfPersons.get(key));
        }
    }

}
