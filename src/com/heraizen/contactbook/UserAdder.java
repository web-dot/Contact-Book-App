package com.heraizen.contactbook;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAdder {

    private static String[] addMenu = {"1. First Name* ", "2. Last Name ", "3. Mobile* ", " Email* "};
    
    static Contact contact;
    static String firstName;
    static String lastName;
    static String mobile;
    static String email;
    static String workplace;
    
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
        System.err.println("Enter First Name");
        String FName = sc.nextLine();
        firstName=FName;
        addFName();
    }
    
    // get mobile
    public static void getMobile() {
        System.err.println("Enter Mobile number");
        String mob = sc.nextLine();
        mobile=mob;
        addMobile();
    }
    
    public static void getEmail() {
        System.err.println("Enter email");
        String mail = sc.nextLine();
        email=mail;
        addEmail();
    }
    
    //----------------ADD--------------------
    
    // add first name based on input criteria
    public static void addFName() {
        
        if(firstName.isEmpty()) {
            System.err.println("This field cannot be blank");
            getFName();
        }
        else {
            contact.setFirstName(firstName); //passing to accessor
        }
    }
    
    // add last name
    public static void addLName() {
        System.err.println("Enter Last Name");
        String LName = sc.nextLine();
        contact.setLastName(LName);
    }
    
    // add mobile based on input criteria
    public static void addMobile() {
        
        if(mobile.isEmpty()) {
            System.err.println("This field cannot be blank");
            getMobile();
        }
        if(checkMobile()) {
            System.err.println("A contact already exists with the entered mobile number.");
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
    
    //  add mobile based on input criteria
    public static void addEmail() {
        
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        boolean match = matcher.matches();
        System.out.println(match);
        
        if(email.isEmpty()) {
            System.err.println("This field cannot be blank");
            getEmail();
        }
        if(match) {
            contact.setEmail(email); //passing to accessor
        }
        else {
            System.err.println("Enter valid email. Example: abc123@xyz.com");
            getEmail();
        }
    }

    
    
}


