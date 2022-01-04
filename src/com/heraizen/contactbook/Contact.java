package com.heraizen.contactbook;

import java.util.regex.Pattern;

public class Contact {
    
    String id;
    String firstName;
    String lastName;
    String mobile;
    String email;
    String workplace;
    
//    public Contact(String firstName, String lastName) {
//        FirstName = firstName;
//        LastName = lastName;
//    }
    
    public String getId() {
        return this.id;
    }
    public void setId() {
        String mobStr = this.mobile.substring(6);
        String nameStr = this.firstName.substring(0,1).toUpperCase();
        this.id = nameStr+mobStr;
    }
    
    //first-name
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        
        // Validation
        if(firstName.length() < 3 || firstName.length() > 15) {
            System.err.println("First name should be between 3 to 15 characters in length.");
            UserAdder.getFName();;
        }
        else {
            this.firstName=firstName;
            UserAdder.addLName();
        }
    }
    
    //last-name
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    //mobile
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        
        // Validation
        if(mobile.length() != 10) {
            System.err.println("Mobile number must have 10 digits with no special characters.");
            UserAdder.getMobile();
        }
        else {
            this.mobile=mobile;
        }
    }
    
    //email
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String mail) {
        email=mail;
    }
    
    //workplace
    public String getWorkplace() {
        return workplace;
    }
    
    public void setWorkplace(String workplace) {
        this.workplace=workplace;
    }
    
    @Override
    public String toString() {
        return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile + "]";
    }
    
    
    
    
    
        
    
}
