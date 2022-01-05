package com.heraizen.contactbook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DisplayMenu {
    
    public static int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        int choice = 0;
       
        try {
            while(choice!=6) {
               
                System.out.println("************Contact Book************");
                System.out.println("Press 1 to Add Contact");
                System.out.println("Press 2 to View Contacts");
                System.out.println("Press 3 to Search Contact");
                System.out.println("Press 4 to Update Contact");
                System.out.println("Press 5 to Delete Contact");
                System.out.println("Press 6 to 1Exit");
                System.out.println("*************************************");
                
                System.out.println("Enter your choice");
                choice = sc.nextInt();
                return choice;
                }
        }
        catch(InputMismatchException e) {
            System.out.println("Invalid Input, Please try again");
            getChoice();
       } 
        System.out.println(choice);
        return choice;
    }
    
}
