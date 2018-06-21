/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.*;
import Day1_2.*;
import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
public class Ex2 {

    public static void main(String[] args) throws JSONException {

        String JSONtext = "";
        Map<String, List<Person>> mapContainingPersons = new HashMap<>();

        try {

            JSONtext = new String(Files.readAllBytes(Paths.get("/Users/cb-sudarshan/PhoneDirectory.json")), StandardCharsets.UTF_8);

        } catch (FileNotFoundException e) {

            System.err.println(e);
            System.exit(0);

        } catch (IOException e) {

            System.err.println(e);
            System.exit(0);
        }

        JSONObject jsonObject = new JSONObject(JSONtext);
        JSONArray jsonArrayOfPersons = jsonObject.getJSONArray("Persons");

        for (int i = 0; i < jsonArrayOfPersons.length(); i++) {

            List<Phone> contact = new ArrayList<>();
            JSONObject personObj = jsonArrayOfPersons.getJSONObject(i);
            JSONArray personPhoneArray = personObj.getJSONArray("Phone");
            JSONObject personAddressObj = personObj.getJSONObject("Address");
            //System.out.println(personObj.get("Name").toString());
            for (int j = 0; j < personPhoneArray.length(); j++) {

                JSONObject phoneObj = personPhoneArray.getJSONObject(j);
                contact.add(new Phone(phoneObj.getString("Number"), phoneObj.getString("Type")));

            }

            Address personAddress = new Address();
            personAddress.setDoor_no(personAddressObj.getInt("Door No")).setCity(personAddressObj.getString("City"))
                    .setPincode(personAddressObj.getInt("Pincode")).setState(personAddressObj.getString("State"))
                    .setStreet(personAddressObj.getString("Street"));

            List<Person> tempList = new ArrayList<>();
            if (mapContainingPersons.get(personObj.get("Name").toString().toUpperCase()) != null) {

                tempList = mapContainingPersons.get(personObj.get("Name").toString().toUpperCase());

            }

            tempList.add(new Person(personObj.get("Name").toString(), personAddress, contact));
            mapContainingPersons.put(personObj.get("Name").toString().toUpperCase(), tempList);
            

        }
        System.out.println(mapContainingPersons);

    }

}
