package com.heraizen.contactbook;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UserAdder {

    private static String[] addMenu = {"1. First Name* ", "2. Last Name ", "3. Mobile* "};
    
    static Contact contact;
    static String firstName;
    static String lastName;
    static String mobile;
    
    static Scanner sc = new Scanner(System.in);
    
    static Map<String, Contact> contactMap;
       
    public static void getContact(Contact c) {
        contact = c;
    }
    public static void getContactMap(Map map) {
        contactMap=map;
    }
    
    //----------------GET--------------------
    
    // get first name
    public static void getFName() {
        System.out.println("Enter First Name");
        String FName = sc.nextLine();
        firstName=FName;
        addFName();
    }
    
    // get mobile
    public static void getMobile() {
        System.out.println("Enter Mobile number");
        String mob = sc.nextLine();
        mobile=mob;
        addMobile();
    }
    
    //----------------ADD--------------------
    
    // add first name based on input criteria
    public static void addFName() {
        
        if(firstName.isEmpty()) {
            System.out.println("This field cannot be blank");
            getFName();
        }
        else {
            contact.setFirstName(firstName); //passing to accessor
        }
    }
    
    // add last name
    public static void addLName() {
        System.out.println("Enter Last Name");
        String LName = sc.nextLine();
        contact.setLastName(LName);
    }
    
    // add mobile based on input criteria
    public static void addMobile() {
        
        if(mobile.isEmpty()) {
            System.out.println("This field cannot be blank");
            getMobile();
        }
        if(checkMobile()) {
            System.out.println("A contact already exists with the entered mobile number.");
            getMobile();
        }
        else {
            contact.setMobile(mobile); //passing to accessor
        }
    }
    
    //check mobile
    public static boolean checkMobile() {
        
        Set<String> set = contactMap.keySet();
        boolean mobExists = false;
        for(String mob : set) {
            if(mob.equals(mobile)) {
                mobExists = true;
                break;
            }
        }
        return mobExists;
    }
    

    
    
}


