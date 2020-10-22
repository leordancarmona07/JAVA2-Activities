/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebookprogram;

import java.util.*;                 // importing all
import java.util.Collections;       // importing Collections
import java.util.Random;            // importing Random
import java.util.Scanner;           // importing Scanner
import java.util.regex.Pattern;     // importing regex.Pattern

/**
 *
 * @author 1styrGroupC
 */
class App {

    Scanner input = new Scanner(System.in); // Instantiating input
    Random random = new Random();           // Instantiating random
    ArrayList<PhoneBook> pBook = new ArrayList<>(); // Instantiating pBook

    static boolean isValid(String email) {
        //This is to be use as email validator
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            //checking if email is empty
            return false;
        }
        return pat.matcher(email).matches();
    }
    private boolean isPhoneNumberValid(String contactNumber) {
       boolean exist = true;
       if (!isNumeric(contactNumber)) {
           return false;
       }
       for (int index = 0; index < pBook.size(); index++) {
           if (pBook.get(index).getPhoneNumber().equals(contactNumber)) {
               System.out.println("Phone Number Already exists");
               exist = false;
               break;
           }
       }

       return exist;
   }

   private boolean isNumeric(String contactNumber) {
       try {
           Long.parseLong(contactNumber);
           return true;
       } catch (NumberFormatException e) {
           return false;
       }
   }

    public String menu() {
        //This is My Menu
        System.out.println("|'''''''''''''''''''''''''''''''''|");
        System.out.println("|      Welcome to Phonebook       |");
        System.out.println("|_________________________________|");
        System.out.println("|      What You Want To Do?       |");
        System.out.println("|         (1) Add Contact         |");
        System.out.println("|         (2) Update Contact      |");
        System.out.println("|         (3) Delete Contact      |");
        System.out.println("|         (4) Search Contact      |");
        System.out.println("|         (5) View Contacts       |");
        System.out.println("|_________________________________|");

        System.out.println("Your Choice: \n");
        //Asking the user's  Choice
        String choice = input.nextLine();

        return choice;
    }

    void addContact() {
        //use to add contact
        int intRandom = random.nextInt(500);
        String randomNumber = Integer.toString(intRandom);
        PhoneBook contact = new PhoneBook();
        contact.setID(randomNumber);
        System.out.println("Contact Last Name : \n");
        contact.setLastName(input.nextLine());
        System.out.println("Contact First Name : \n");
        contact.setFirstName(input.nextLine());
        
        System.out.println("Contact Number: ");
       String phoneNumber = input.nextLine();
       while (!isPhoneNumberValid(phoneNumber)) {
           System.out.println("Invalid Phone Number! Try Again ");
           System.out.print("Phone Number: ");
           phoneNumber = input.nextLine();
       }
       contact.setPhoneNumber(phoneNumber);

        System.out.print("Email: \n");
        String email = input.nextLine();
//        System.out.println(isValid(email));
        if (!isValid(email)) {//check if valid or not | false
            System.out.println(">>>Format must be ex@example.com");
            System.out.print("Enter email again: ");
            email = input.nextLine();
        }
        contact.setEmail(email);
        System.out.println("Address : \n");
        contact.setAddress(input.nextLine());

        pBook.add(contact);
        System.out.println("Contact with an ID of "
                + contact.getID()
                + " has been added successfully!");

    }

    void updateContact() {
        //use to update a contact
        if (pBook.isEmpty()) {
            System.out.println("Phone Book is Empty! Nothing to update!");
        } else {
            System.out.println("You are about to update a Contact "
                    + "Information!");
            System.out.println("_________________________________");
            System.out.println("");
            System.out.println("Enter ID you are going update : \n");
            String id = input.nextLine();
            boolean exists = false;
            OUTER:
            for (PhoneBook contact : pBook) {
                if (id.equals(contact.getID())) {
                    exists = true;
                    System.out.println("_____________________________");
                    System.out.println("What field to edit?");
                    System.out.println("1. ID");
                    System.out.println("2. Last Name");
                    System.out.println("3. First Name");
                    System.out.println("4. Phone Number");
                    System.out.println("5. Email");
                    System.out.println("6. Address");
                    System.out.println("_____________________________");
                    System.out.println("");
                    System.out.println("Input Choice : \n");
                    String choice = input.nextLine();
                    if (null == choice) {
                        System.out.println("Choice is not Valid! Nothing "
                                + "updated");
                        break OUTER;
                    } else {
                        switch (choice) {
                            case "1":
                                //This is to update the ID of the Contact
                                System.out.println("Enter new Contact ID : \n");
                                contact.setID(input.nextLine());
                                break;
                            case "2":
                                //This is to update the Last Name of the
                                //Contact
                                System.out.println("Enter new Last Name"
                                        + " : \n");
                                contact.setLastName(input.nextLine());
                                break;
                            case "3":
                                //This is to update the First Name of the 
                                //contact
                                System.out.println("Enter new First Name"
                                        + " : \n");
                                contact.setFirstName(input.nextLine());
                                break;
                            case "4":
                                //This is to update the Phone Number of the 
                                //COntact
                                System.out.println("Enter new Phone Number"
                                        + " : \n");
                                contact.setPhoneNumber(input.nextLine());
                                break;
                            case "5":
                                //This is to update the Email of the contact
                                System.out.print("Email: \n");
                                String email = input.nextLine();
                                if (!isValid(email)) {
                                    //check if valid or not | false
                                    System.out.println(">>>Format must be "
                                            + "ex@example.com");
                                    System.out.print("Enter email again: ");
                                    email = input.nextLine();
                                }
                                contact.setEmail(email);
                                break;
                            case "6":
                                //This is to update the address of the contact
                                System.out.println("Enter new Address : \n");
                                contact.setAddress(input.nextLine());
                                break;
                            default:
                                System.out.println("Choice is not Valid! "
                                        + "Nothing updated");
                                break;
                        }
                    }
                    System.out.println("Contact with an ID of "
                            + contact.getID()
                            + " has been updated successfully!");
                    break;
                }
            }
        }
    }

    void deleteContact() {
        //use to delete a contact
        System.out.println("[You are about to remove a Contact!]");
        System.out.println("_______________________________");
        System.out.println("");
        System.out.println("Enter the Contact ID : ");
        String chosenID = input.nextLine();

        for (PhoneBook contact : pBook) {
            if (chosenID.equals(contact.getID())) {
                pBook.remove(contact);
                System.out.println("Contact with an ID of "
                        + contact.getID()
                        + " has been deleted successfully!");
                break;
            }
        }
    }

    void searchContact() {
        //use to search contact
        System.out.println("[You are about to search a Contact!]");
        System.out.println("_______________________________");
        System.out.println("");
        System.out.println("Enter the Contact ID : ");
        String chosenID = input.nextLine();

        for (int i = 0; i < pBook.size(); i++) {
            if (pBook.get(i).getID().equals(chosenID)) {
                System.out.println("Search Result : ");
                System.out.println("");
                System.out.println("Contact ID : "
                        + pBook.get(i).getID());
                System.out.println("Contact First Name : "
                        + pBook.get(i).getFirstName()
                        + ", "
                        + pBook.get(i).getLastName());
                System.out.println("Contact ID : "
                        + pBook.get(i).getPhoneNumber());
                System.out.println("Contact ID : "
                        + pBook.get(i).getEmail());
                System.out.println("Contact ID : "
                        + pBook.get(i).getAddress());
            }
        }
    }

    void viewContacts() {
        //used for viewing contacts
        System.out.println("This/these is/are your Contacts : ");
        System.out.println("__________________________________");
        Collections.sort(pBook);
        for (int i = 0; i < pBook.size(); i++) {
            System.out.println("");
            System.out.println("Contact ID : "
                    + pBook.get(i).getID());
            System.out.println("Contact Full Name : "
                    + pBook.get(i).getLastName()
                    + ", "
                    + pBook.get(i).getFirstName());
            System.out.println("Contact ID : "
                    + pBook.get(i).getPhoneNumber());
            System.out.println("Contact ID : "
                    + pBook.get(i).getEmail());
            System.out.println("Contact ID : "
                    + pBook.get(i).getAddress());
        }

    }

}
