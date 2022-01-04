package com.heraizen.contactbook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
                contactMap.put(c.getMobile(), c);
                
                //System.out.println(contactMap);
                //System.out.println(contactList);

                break;
            case 2:
                DisplayContacts.display(contactMap);
                break;
            case 3:
                System.out.println("Enter text to search");
                String srchStr = sc.nextLine();
                Contact con=null;
                Collection<Contact> mapVal = contactMap.values();
                Iterator<Contact> valIter = mapVal.iterator();
                while(valIter.hasNext()) {
                    con = valIter.next();
                    if(con.getFirstName().contains(srchStr) || con.getLastName().contains(srchStr)||con.getMobile().contains(srchStr)) {
                        System.out.println("---------------------------------------------------------------------------------------------");
                        System.out.printf("%5s %15s %15s %10s %15s %15s", "UiD", "FirstName", "LastName", "Mobile", "Email", "Workplace");
                                        //"%5s %15s %15s %15s %10s %10s"
                        System.out.println();
                        System.out.println("---------------------------------------------------------------------------------------------");
                        System.out.format("%7s %13s %13s %13s %17s %13s", con.getId(), con.getFirstName(), con.getLastName(), con.getMobile(), con.getEmail(), con.getWorkplace());
                        System.out.println();
                    }
                    else {
                        System.out.println("No data found");
                    }
                }
                
                
                
                
                
        }
    }
}

