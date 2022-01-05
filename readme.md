## Contact Book Application
-----------------------------------------------------------------------------------------------------------------------------------------------
Technology: JSE (Core Java)
IDE: Eclipse / Netbeans
Focus: OOPs concepts, Exception Handling, Collections Framework
-----------------------------------------------------------------------------------------------------------------------------------------------
Create a Contact Book application with the following functionalities:
1. Add a new contact
2. Display all existing contacts
3. Search contacts based on given search string
4. Update an existing contact
5. Delete an existing contact


This application should be developed using Command Line Interface (CLI) as there is no Graphical
User Interface (GUI).


A Contact must have the following information:

#### 1. uid: User ID (Mandatory)
This is an internally generated id that uniquely identifies a contact within the
application.
#### 2. firstName: First name (Mandatory)
This field cannot be empty; it must be between 3 – 15 characters long. If the entered first name
is not of this length, an error message should be displayed “ First name should be between 3
to 15 characters in length. ” The system should then prompt for firstName to be re-entered.
#### 3. lastName: Last name (Optional)
This is an optional field with no validation.
#### 4. mobile: mobile phone number (Mandatory)
This field cannot be empty. It should be 10 characters long, should contain only numbers, and
no alphabets or special characters are permitted. If the entered data violates this rule, an error
message should be displayed “ Mobile number must have 10 digits with no special
characters. ” The system should prompt for mobile to be re-entered.
#### 5. email: email address (Mandatory)
This field cannot be empty. It must be a valid email in the correct format. If it is not valid, an
error message should be displayed “ Enter valid email. Example: abc123@xyz.com ” The
system should prompt for email to be re-entered.
#### 6. workplace: Name of city where the contact resides/works (Optional)
This is an optional field with no validation.
Generic error messages:
#### 1. If a mandatory field is left blank or has only spaces, display the error message “This
field cannot be left blank.”
#### 2. If a non-alphabetic character is entered in a character only field (like first name or last
name), display the error message “Please enter only alphabets.”.
#### 3. If an alphabet is entered in a number only field (like mobile number), display the error
message “Please enter only numerals”.



#### Points that need to be addressed:
1. Validations
2. Exceptions handling
3. Using the most efficient data structure for storing data (Preferably Collections Framework)
4. Following naming conventions and writing clean code
5. Project directory structure
