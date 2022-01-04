package com.heraizen.contactbook;

public class Contact {
    
    String id;
    String firstName;
    String lastName;
    String mobile;
    
//    public Contact(String firstName, String lastName) {
//        FirstName = firstName;
//        LastName = lastName;
//    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    //first-name
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        
        // Validation
        if(firstName.length() < 3 || firstName.length() > 15) {
            System.out.println("First name should be between 3 to 15 characters in length.");
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
            System.out.println("Mobile number must have 10 digits with no special characters.");
            UserAdder.getMobile();
        }
        else {
            this.mobile=mobile;
        }
    }
    @Override
    public String toString() {
        return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile + "]";
    }
    
    
    
    
    
        
    
}
