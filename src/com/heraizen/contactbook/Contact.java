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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
        result = prime * result + ((workplace == null) ? 0 : workplace.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contact other = (Contact) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (mobile == null) {
            if (other.mobile != null)
                return false;
        } else if (!mobile.equals(other.mobile))
            return false;
        if (workplace == null) {
            if (other.workplace != null)
                return false;
        } else if (!workplace.equals(other.workplace))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile + "]";
    }
    
    
    
    
    
        
    
}
