/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1_2;

import java.util.*;

/**
 *
 * @author cb-sudarshan
 */
public class PhoneDirectory {

    public static void addPerson(HashMap<String, List<Person>> persons) {
        System.out.println("Eg : Name \nDoor No, Street, City, State, Pincode \nMobileType Mobile Number \netc..");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the details");

        List<String> input = new ArrayList<>();
        String line = "";
        while (!(line = sc.nextLine()).equals("")) {
            input.add(line);
        }

        String[] ad = input.get(1).split(",");
        Address add = new Address(Integer.valueOf(ad[0]), ad[1], ad[2], ad[3], Integer.valueOf(ad[4]));

        List<Phone> phone = new ArrayList<>();
        for (int i = 2; i < input.size(); i++) {
            ad = input.get(i).split(" ");
            phone.add(new Phone(ad[1], ad[0]));

        }
        //persons.put(input.get(0), new Person(input.get(0), add, phone));
        if (persons.containsKey(input.get(0).toUpperCase())) {
            List<Person> per = persons.get(input.get(0).toUpperCase());
            per.add(new Person(input.get(0), add, phone));
            persons.put(input.get(0).toUpperCase(), per);
        } else {
            List<Person> per = new ArrayList<>();
            per.add(new Person(input.get(0), add, phone));
            persons.put(input.get(0).toUpperCase(), per);
        }

    }

    public static void searchUsingName(HashMap<String, List<Person>> persons) {
        System.out.println("Enter the name of the person..");
        String name = new Scanner(System.in).next();
        Set<String> keys = persons.keySet();
        List<Person> per = new ArrayList<>();
        per = persons.get(name);
        for (Person person : per) {
            System.out.println(person);
        }
    }

    public static void searchUsingPhone(HashMap<String, List<Person>> persons) {
        System.out.println("Enter the number of the person..");
        String number = new Scanner(System.in).next();
        Set<String> keys = persons.keySet();
        List<Person> per = new ArrayList<>();
        SEARCH:
        for (String key : keys) {
            per = persons.get(key);
            for (Person person : per) {
                List<Phone> phone = person.getPhone();
                for (Phone ph : phone) {
                    if (ph.getNumber().equals(number)) {
                        System.out.println(person);
                        break SEARCH;
                    }

                }
            }
        }
    }

    public static void display(HashMap<String, List<Person>> persons) {
        Set<String> keys = persons.keySet();
        List<Person> per = new ArrayList<>();
        for (String key : keys) {
            per = persons.get(key);
            for (Person person : per) {
                System.out.println(person);
            }
        }
    }

    public static void displayMenu(HashMap<String, List<Person>> persons) {
        boolean choic;
        do {
            //System.out.print("\033[H\033[2J");
            System.out.println("1.Add Person \n2.Search using name \n3.Search using phone \n4.Display Entries");
            System.out.print("Enter your choice...");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    PhoneDirectory.addPerson(persons);
                    break;
                case 2:
                    PhoneDirectory.searchUsingName(persons);
                    break;
                case 3:
                    PhoneDirectory.searchUsingPhone(persons);
                    break;
                case 4:
                    PhoneDirectory.display(persons);
                    break;
            }
            System.out.println("Continue..?? Y/N");
            choic = sc.next().equalsIgnoreCase("y") ? true : false;
        } while (choic);
    }

    public static void createPersons(HashMap<String, List<Person>> persons) {

        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("9988776655", "mobile"));
        phones.add(new Phone("1122334455", "work"));
        phones.add(new Phone("1234567899", "HOME"));
        phones.add(new Phone("9876543212", "Work"));
        phones.add(new Phone("1199882233", "mobile"));
        phones.add(new Phone("5647382910", "Mobile"));
        phones.add(new Phone("1289341211", "home"));
        phones.add(new Phone("9876512231", "Work"));
        phones.add(new Phone("1029143212", "home"));
        phones.add(new Phone("9833121212", "Work"));
        phones.add(new Phone("9871221211", "mobile"));
        phones.add(new Phone("1231312312", "mobile"));
        phones.add(new Phone("4433221111", "Work"));

        List<Phone> phne = new ArrayList<>();
        phne.add(phones.get(0));
        phne.add(phones.get(1));
        phne.add(phones.get(2));

        List<Address> address = new ArrayList<>();
        address.add(new Address(27, "Arimalam Colony", "Coimbatore", "TamilNadu", 641021));
        address.add(new Address(13, "Sengupta street", "Coimbatore", "TamilNadu", 641003));
        address.add(new Address(2, "Tibrewal Nagar", "Coimbatore", "TamilNadu", 641001));
        address.add(new Address(21, "Kanappa Nagar", "Chennai", "TamilNadu", 600028));
        address.add(new Address(12, "Veerabadran Street", "Chennai", "TamilNadu", 600010));

        List<Person> per = new ArrayList<>();
        per.add(new Person("Arun", address.get(0), phne));
        persons.put("ARUN", per);

        phne.clear();
        phne.add(phones.get(3));
        phne.add(phones.get(4));
        phne.add(phones.get(5));
        List<Person> per1 = new ArrayList<>();
        per1.add(new Person("Balaji", address.get(1), phne));
        persons.put("BALAJI", per1);

        phne.clear();
        phne.add(phones.get(6));
        phne.add(phones.get(7));
        phne.add(phones.get(8));
        List<Person> per2 = new ArrayList<>();
        per2.add(new Person("Arunk", address.get(2), phne));
        persons.put("ARUNK", per2);

        phne.clear();
        phne.add(phones.get(9));
        phne.add(phones.get(10));
        List<Person> per3 = new ArrayList<>();
        per3.add(new Person("ArunKarthick", address.get(3), phne));
        persons.put("ARUNKARTHICK", per3);

        phne.clear();
        phne.add(phones.get(11));
        phne.add(phones.get(12));
        List<Person> per4 = new ArrayList<>();
        per4.add(new Person("Daniel", address.get(4), phne));
        persons.put("DANIEL", per4);

    }

    public static void main(String[] args) {

        HashMap<String, List<Person>> persons = new HashMap<>();
        PhoneDirectory.createPersons(persons);

        PhoneDirectory.displayMenu(persons);

    }

}
