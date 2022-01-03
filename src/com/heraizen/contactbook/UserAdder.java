package com.heraizen.contactbook;

import java.util.Scanner;

public class UserAdder {

    private static String[] addMenu = {"1. First Name", "2. Last Name"};
    
    
//    public static void displayAddMenu() {
//        for(String option : addMenu) {
//            System.out.println(option);
//        }
//    }
    
    
    
    public static void addFName(Contact c) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name");
        String FName = sc.nextLine();
        
        if(FName.isEmpty()) {
            System.out.println("This field cannot be blank");
            addFName(c);
        }
        else {
            c.FirstName=FName;
        }
    }
    public static void addLName(Contact c) {
        
    }
    
    
    
    
    
    
}


