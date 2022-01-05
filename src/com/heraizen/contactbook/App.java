package com.heraizen.contactbook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
            
            int choice = 0;
            while(choice != 6) {
                choice = DisplayMenu.getChoice();
                Switch.switchIn(choice);
                }
            }
        
     }      
