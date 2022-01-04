package com.heraizen.contactbook;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class DisplayContacts {
    
       public static void display(Map map) {
           
           if(map.isEmpty()) {
               System.out.println("No Contacts created");
           }
           else {
               Collection<Contact> mapVal = map.values();
               Iterator<Contact> valIter = mapVal.iterator();
               
               System.out.println("---------------------------------------------------------------------------------------------");
               System.out.printf("%5s %15s %15s %10s %15s %15s", "UiD", "FirstName", "LastName", "Mobile", "Email", "Workplace");
                               //"%5s %15s %15s %15s %10s %10s"
               System.out.println();
               System.out.println("---------------------------------------------------------------------------------------------");
               
               while(valIter.hasNext()) {
                   Contact c = valIter.next();
                   System.out.format("%7s %13s %13s %13s %17s %13s", c.getId(), c.getFirstName(), c.getLastName(), c.getMobile(), c.getEmail(), c.getWorkplace());
                   System.out.println();
               } 
           }
              
             
       }
}
