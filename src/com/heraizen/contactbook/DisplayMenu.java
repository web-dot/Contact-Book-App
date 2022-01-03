package com.heraizen.contactbook;

public class DisplayMenu {
    
    private static String[] menu = {"1. Add Contact", "2. View Contact"};
    
    public static void display() {
        System.out.println("************Contact Book************");
        for(String option : menu) {
            System.out.println(option);
        }
    } 
}
