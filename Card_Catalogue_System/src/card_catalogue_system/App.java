/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_catalogue_system;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 1styrGroupC
 */
class App {
    Scanner input = new Scanner(System.in);
    ArrayList<CatalogueCard> cat = new ArrayList<>();
    public String choice(){
        System.out.println("|'''''''''''''''''''''''''''''''''|");
        System.out.println("|     CARD CATALOGUE OPTIONS      |");
        System.out.println("|          (1) Add Card           |");
        System.out.println("|          (2) Edit Card          |");
        System.out.println("|          (3) Remove Card        |");
        System.out.println("|          (4) View Card/s        |");
        System.out.println("|_________________________________|");
        
        System.out.println("Your Choice: ");
        String choice = input.nextLine();
        
        return choice;
    }
    public void addCard(){
        CatalogueCard card = new CatalogueCard();
        System.out.println("Card ID : ");
        card.setCardID(input.nextLine());
        System.out.println("Book Title : ");
        card.setTitle(input.nextLine());
        System.out.println("Book Author : ");
        card.setAuthor(input.nextLine());
        System.out.println("Year Published : ");
        card.setYearPublished(input.nextLine());
        System.out.println("Publisher : ");
        card.setPublisher(input.nextLine());
        
        cat.add(card);
        System.out.println("Card has been added successfully!");
    }
    public void editCard(){
        if (cat.isEmpty()){
         System.out.println("Card Catalog is Empty !!");
         return;
     }
        System.out.println("You are about to edit a Card!");
        System.out.println("______________________________");
       System.out.println("Enter ID to edit : ");    
       String id = input.nextLine();
       boolean exists = false;
       for (CatalogueCard card: cat){
           if (id.equals(card.getCardID())){
               exists = true;
               System.out.println("Enter new Card ID: ");
               card.setCardID(input.nextLine());
               System.out.println("Enter new Book Title: ");
               card.setTitle(input.nextLine());
               System.out.println("Enter new Book Author: ");
               card.setAuthor(input.nextLine());
               System.out.println("Enter new Year Published: ");
               card.setYearPublished(input.nextLine());
               System.out.println("Enter new Publisher: ");
               card.setPublisher(input.nextLine());
               
               break;
           }
       }
    }
    public void removeCard(){
        System.out.println("[You are about to remove a CARD!]");
        System.out.println("_______________________________");
        System.out.println("Enter the Card ID : ");
        String chosenID = input.nextLine();
        
       for (CatalogueCard card: cat){
           if (chosenID.equals(card.getCardID())){
               cat.remove(card);
               break;
           }
       }
        System.out.println("Card with an ID of ".concat(chosenID).concat(" has been deleted!"));
    }
    public void viewCard(){
        System.out.println("|'''''''''''''''''''''''''''''''''|");
        System.out.println("|     Please Indicate to View     |");
        System.out.println("|         (1) View a Card         |");
        System.out.println("|         (2) View All Cards      |");
        System.out.println("|_________________________________|");
        
        System.out.println("Your Choice: ");
        String choice = input.nextLine();
        
        if (null == choice){
            System.out.println("Please input either (1) or (2)...");
        }else switch (choice) {
            case "1":
                System.out.println("Enter Card ID : ");
                String cardChosen = input.nextLine();
                for (int i = 0; i < cat.size(); i++) {
                    if (cat.get(i).getCardID().equals( cardChosen)) {
                        System.out.println("");
                        System.out.println("Card ID: " + cat.get(i).getCardID());
                        System.out.println("Book Title: " + cat.get(i).getTitle());
                        System.out.println("Book Author: " + cat.get(i).getAuthor());
                        System.out.println("Year Published: " + cat.get(i).getYearPublished());
                        System.out.println("Publisher: " + cat.get(i).getPublisher());
                        
                    }
                }    break;
            case "2":
                System.out.println("[ These are the List of Cards!]");
                for (int i = 0; i < cat.size(); i++) {
                    System.out.println("Card ID: " + cat.get(i).getCardID());
                    System.out.println("Book Title: " + cat.get(i).getTitle());
                    System.out.println("Book Author: " + cat.get(i).getAuthor());
                    System.out.println("Year Published: " + cat.get(i).getYearPublished());
                    System.out.println("Publisher: " + cat.get(i).getPublisher());
                    System.out.println("______________________________");
                    
                }    break;
            default:
                System.out.println("Please input either (1) or (2)...");
        }
    }
}
