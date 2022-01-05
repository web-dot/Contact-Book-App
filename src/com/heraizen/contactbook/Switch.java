package com.heraizen.contactbook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Switch {

    
    static List<Contact> contactList = new ArrayList<Contact>();
    static Map<String, Contact> contactMap = new HashMap<String, Contact>();
    static Map<String, Contact> idMap = new HashMap<String, Contact>();
    
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
                idMap.put(c.getId(), c);
                
                
                System.out.println(contactMap);
                //System.out.println(contactList);

                break;
            case 2:
                DisplayContacts.display(contactMap);
                break;
            case 3:
                if(contactMap.isEmpty()) {
                    System.out.println("No Contacts created");
                    System.out.println();
                    break;
                }
                System.out.println("Enter text to search");
                String srchStr = sc.nextLine();
                Contact con;
                boolean doesExist = false;
               
                List<Contact> matchList = new ArrayList<Contact>();
                matchList.clear();
                
                Collection<Contact> mapVal = contactMap.values();
                Iterator<Contact> valIter = mapVal.iterator();
                while(valIter.hasNext()) {
                    con = valIter.next();
                    if(con.getFirstName().contains(srchStr) || con.getLastName().contains(srchStr)||con.getMobile().contains(srchStr)) {
                        doesExist = true;
                        if(!matchList.contains(con)) {
                            matchList.add(con);
                            
                        }
                    }
                }
                    //System.out.println("ml " + matchList);
                    
                    if(doesExist) {
                        for(Contact cons : matchList) {
                            System.out.println("---------------------------------------------------------------------------------------------");
                            System.out.printf("%5s %15s %15s %10s %15s %15s", "UiD", "FirstName", "LastName", "Mobile", "Email", "Workplace");
                                            //"%5s %15s %15s %15s %10s %10s"
                            System.out.println();
                            System.out.println("---------------------------------------------------------------------------------------------");
                            System.out.format("%7s %13s %13s %13s %17s %13s", cons.getId(), cons.getFirstName(), cons.getLastName(), cons.getMobile(), cons.getEmail(), cons.getWorkplace());
                            System.out.println();
                              
                        }
                    }
                    else {
                        System.out.println("No data found");
                    }
                
                break;
            case 4:                
                DisplayContacts.display(contactMap);
                
                System.out.println("Enter the unique id to be updated");
                String uniqueId = sc.nextLine();

                Set<String> conKey = idMap.keySet();
                
                for(String key : conKey) {
                    if(key.equals(uniqueId)) {
                        Contact forUp = idMap.get(uniqueId);
                        String oldMobile = idMap.get(forUp.getId()).getMobile();
                        
                        UserAdder.getContact(forUp);
                        UserAdder.getFName();
                        UserAdder.getContactMap(contactMap);
                        boolean isUnique = UserAdder.getMobileNew(forUp);
                        if(isUnique) {
                            UserAdder.getEmail();
                            UserAdder.addWorkplace();
                            UserAdder.confirm();
                            contactMap.remove(oldMobile);
                            contactMap.put(forUp.getMobile(), forUp);
                            idMap.put(forUp.getId(), forUp);
                        }   
                    }
                    else {
                        System.out.println("input error");
                        
                    }
                }
                break;
            case 5:
                
                
                
            }
        }
    }

