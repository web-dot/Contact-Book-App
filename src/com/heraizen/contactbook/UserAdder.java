package com.heraizen.contactbook;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAdder {

    private static String[] addMenu = {"1. First Name* ", "2. Last Name ", "3. Mobile* ", "4. Email* ", "5. workplace"};
    
    static Contact contact;
    static String firstName;
    static String lastName;
    static String mobile;
    static String email;
    static String workplace;
    
    static String oldMobile;
    
    static Scanner sc = new Scanner(System.in);
    static Scanner sc1 = new Scanner(System.in);
    
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
        System.out.println("Enter First Name[min-length-3:Mandatory]");
        String FName = sc.nextLine().toLowerCase();
        firstName=FName;
        addFName();
    }
    
    // get mobile
    public static void getMobile() {
        System.out.println("Enter Mobile number[10 digits:Mandatory]");
        String mob = sc.nextLine();
        mobile=mob;
        addMobile();
    }
    
    public static boolean getMobileNew(Contact c) {
        System.out.println("Enter new Mobile number");
        String mob = sc.nextLine();
        mobile=mob;
        boolean isUnique = addMobileNew(c);
        return isUnique;
    }
    
    // get email
    public static void getEmail() {
        System.out.println("Enter email[format-abc@gmail.com:Mandatory]");
        String mail = sc.nextLine().toLowerCase();
        email=mail;
        addEmail();
    }
    
    //----------------ADD--------------------
    
    // set first name based on input criteria
    public static void addFName() {
        
        if(firstName.isEmpty()) {
            System.out.println("This field cannot be blank");
            getFName();
        }
        if(!ifLetter(firstName)) {
            System.out.println("Please enter only alphabets.");
            getFName();
        }
        else {
            contact.setFirstName(firstName); //passing to accessor
        }
    }
    
    // set last name
    public static void addLName() {
        System.out.println("Enter Last Name[Optional]");
        sc1.reset();
        String LName = sc1.nextLine().toLowerCase();
        lastName=LName;
        if(!ifLetter(lastName)) {
            System.out.println("Please enter only alphabets.");
            addLName();
        }
        contact.setLastName(lastName);
    }
    
    // set mobile based on input criteria
    public static void addMobile() {
        
        if(mobile.isEmpty()) {
            System.out.println("This field cannot be blank");
            getMobile();
        }
        if(checkMobile()) {
            System.out.println("A contact already exists with the entered mobile number.");
            getMobile();
        }
        if(!ifNumber(mobile)) {
            System.out.println("Please enter only numbers.");
            getMobile();
        }
        else {
            contact.setMobile(mobile); //passing to accessor
        }
    }
    
    public static boolean addMobileNew(Contact c) {
        boolean mobIsUnique = true;
        if(mobile.isEmpty()) {
            System.out.println("This field cannot be blank");
            getMobileNew(c);
        }
        else{
            Set<String> set = contactMap.keySet();
            String checkId = contact.getId();
            for(String mob : set) {
                String inIds = contactMap.get(mob).getId(); 
                if(!inIds.equals(checkId) && mob.equals(mobile)) {
                    System.out.println("Updated mobile number belongs to a different contact. Update cancelled");
                    mobIsUnique=false;
                    contactMap.put(c.getMobile(), c);
                }
            }
        }
        if(mobIsUnique) {
            contact.setMobile(mobile);
        }        
        return mobIsUnique;
    }
    
    // check if mobile exist
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
    
    //  set email based on input criteria
    public static void addEmail() {
        if(email.isEmpty()) {
            System.out.println("This field cannot be blank");
            getEmail();
        }
        Set<String> set = contactMap.keySet();
        for(String mob : set) {
            String usersMail = contactMap.get(mob).getEmail();
            //System.out.println(usersMail);
            if(usersMail.equals(email)) {
                System.out.println("This email is already taken");
                getEmail();
            }
        }
        
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        //boolean match = matcher.matches();
        //System.out.println(match);
        
        
        if(matcher.matches()) {
            contact.setEmail(email); //passing to accessor
        }
        else {
            System.out.println("Enter valid email. Example: abc123@xyz.com");
            getEmail();
        }
    }

    // set workplace
    public static void addWorkplace() {
        System.out.println("Enter workplace[Optional]");
        String work = sc.nextLine().toLowerCase();
        workplace = work;
        if(!ifLetter(workplace)) {
            System.out.println("Please enter only alphabets.");
            addWorkplace();
        }
        contact.setWorkplace(workplace);;
    }
    
    //check if not letter
    public static boolean ifLetter(String str) {
        boolean isLetter = true;
        for(int i=0; i<str.trim().length(); i++) {
            if(!Character.isSpaceChar(str.charAt(i))) {
                if(!Character.isLetter(str.charAt(i))) {
                    isLetter=false;
                    break;
                }
            }
            
        }
        return isLetter;
    }
    
    //check if not number
    public static boolean ifNumber(String str) {
        boolean isDigit = true;
        for(int i=0; i<str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                isDigit = false;
                break;
            }
        }
        return isDigit;
    }
    
    // set id
    public static void setId() {
        contact.setId();
    }
    
    // confirmation
    public static void confirm() {
        System.out.println("Contact has been successfully added with unique id: " +  contact.getId());
        System.out.println();
    }
    
}


