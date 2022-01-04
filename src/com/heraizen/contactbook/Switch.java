package com.heraizen.contactbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Switch {

    
    static List<Contact> contactList = new ArrayList<Contact>();
    static Map<String, Contact> contactMap = new HashMap<String, Contact>();
    
    public static void switchIn(int num) {
        Scanner sc = new Scanner(System.in);
        switch(num) 
        {
            case 1:
                Contact c = new Contact();
                
                UserAdder.getContact(c);
                
                UserAdder.getFName();
                
                UserAdder.getContactMap(contactMap);
                UserAdder.getMobile();
                
                UserAdder.getEmail();
                UserAdder.addWorkplace();
                UserAdder.setId();
                UserAdder.confirm();
                
                
                //contactList.add(c);
                //contactMap.put(c.getMobile(), c);
                
                //System.out.println(contactMap);
                //System.out.println(contactList);

                break;
            case 2:
                
            default :
                System.out.println("Invalid choice. Please enter 1 through 6 only.");
                System.out.println();
                DisplayMenu.display();
                num = sc.nextInt();
                switchIn(num);
                break;
        }
    }
}

