package com.heraizen.contactbook;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        
        /*
        Contact c1 = new Contact();
        Contact c2 = new Contact();
        
        c1.id="100";
        c1.name="Ramu";
        c2.id="100";
        c2.name="Somu";
        
        Map<String, String> map = new HashMap<String, String>();
        
        map.put(c1.id, c1.name);
        String r = map.put(c2.id, c2.name);
        
        System.out.println(map);
        System.out.println(r);
        */
        
        DisplayMenu.display();
        
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter your choice");
        System.out.println("*************************************");
        int choice = sc.nextInt();
        
        
//        switch(choice) 
//        {
//            case 1:
//                UserAdder.addFName();
//                break;
//            default :
//                System.out.println("Invalid choice. Please enter 1 through 6 only.");
//                System.out.println();
//                DisplayMenu.display();
//                choice = sc.nextInt();
//                break;
//        }
            
            Contact c = new Contact();
            Switch.switchIn(choice, c);
            System.out.println(c.FirstName);
            
        
    }

}
