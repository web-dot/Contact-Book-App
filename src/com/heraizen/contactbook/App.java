package com.heraizen.contactbook;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
               
        DisplayMenu.display();
        
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter your choice");
        System.out.println("*************************************");
        int choice = sc.nextInt();
       
        // call switch
        while(choice!=5) {
            Switch.switchIn(choice);
        }   
        
    }

}
