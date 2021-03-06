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
                
                contactMap.put(c.getMobile(), c);
                idMap.put(c.getId(), c);
                
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
                String srchStr = sc.nextLine().toLowerCase();
                Contact con;
                boolean doesExist = false;
               
                List<Contact> matchList = new ArrayList<>();
                matchList.clear();
                
                Collection<Contact> mapVal = contactMap.values();
                Iterator<Contact> valIter = mapVal.iterator();
                
                //mapVal.stream().map(arg0)
                
                while(valIter.hasNext()) {
                    con = valIter.next();
                    if(con.getId().contains(srchStr) || con.getFirstName().contains(srchStr) || con.getLastName().contains(srchStr)||con.getMobile().contains(srchStr)) {
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
                if(idMap.isEmpty() && contactMap.isEmpty()) {
                    System.out.println("No Contacts created");
                }
                else {
                    DisplayContacts.display(contactMap);
                    
                    System.out.println("Enter the unique id to be updated");
                    String uniqueId = sc.nextLine();
                    
                    boolean idExists = false;
                    
                    Set<String> conKey = idMap.keySet();
                    
                    for(String key : conKey) {
                        if(key.equals(uniqueId)) {
                            
                            Contact forAbort = new Contact(idMap.get(uniqueId).getId(), idMap.get(uniqueId).getFirstName(), idMap.get(uniqueId).getLastName(), idMap.get(uniqueId).getMobile(), idMap.get(uniqueId).getEmail(), idMap.get(uniqueId).getWorkplace());
                            idExists=true;
                            
                            Contact forUp = idMap.get(uniqueId);
                            String oldMobile = idMap.get(forUp.getId()).getMobile();
                            
                            UserAdder.getContact(contactMap.get(oldMobile));
                            UserAdder.getFName();
                            UserAdder.getContactMap(contactMap);
                            boolean isUnique = UserAdder.getMobileNew(forAbort);
                            if(isUnique) {
                                UserAdder.getEmail();
                                UserAdder.addWorkplace();
                                UserAdder.confirm();
                                contactMap.remove(oldMobile);
                                contactMap.put(forUp.getMobile(), forUp);
                                idMap.put(forUp.getId(), forUp);
                            }   
                        }
                    }
                    if(!idExists) {
                        System.out.println("No contact exists with the entered unique id");
                    }
                }
                break;
            case 5:
                if(idMap.isEmpty() && contactMap.isEmpty()) {
                    System.out.println("No Contacts created");
                }
                else {
                    DisplayContacts.display(contactMap);
                    System.out.println("Enter the unique id to be deleted");
                    String delId = sc.nextLine();
                    boolean doExist = false;
                    Set<String> checkSet = idMap.keySet();
                    for(String id : checkSet) {
                        if(id.equals(delId)) {
                            doExist=true;
                            System.out.println("Selected contact will be deleted. Proceed (Y/N)?");
                            String input = sc.nextLine();
                            if(input.equals("n") || input.equals("N")) {
                                System.out.println("Deletion aborted");
                            }
                            if(input.equals("y") || input.equals("Y")) {
                                String mobile = idMap.get(delId).getMobile();
                                contactMap.remove(mobile);
                                idMap.remove(delId);
                                System.out.println("Selected record deleted successfully.");
                                break;
                            }
                            
                        }
                
                    }
                    if(!doExist) {
                        System.out.println("No contact exists with the entered unique id");
                    }
                }
                
                break;
            case 6:
                System.out.println("Thank you. Please hit enter to exit the system.");
                String s = sc.nextLine();
                break;
            default:
                System.out.println("Invalid input");
                break;
            }
        }
    }

