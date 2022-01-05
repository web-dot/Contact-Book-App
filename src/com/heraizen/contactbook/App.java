package com.heraizen.contactbook;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
               
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println();
        int choice = 0;
       
        // call switch
        while(choice!=6) {
            
            System.out.println("************Contact Book************");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.println("*************************************");
            
            System.out.println("Enter your choice");
            
            choice = sc.nextInt();
            
            Switch.switchIn(choice);
        }   
        
    }

}
