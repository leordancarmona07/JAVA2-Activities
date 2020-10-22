/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebookprogram;

/**
 *
 * @author 1styrGroupC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        App app  = new App(); // This is to instantiate app
        while(true){//This is to display the menu
                    //as long as the program is running
            switch (app.menu()){
                case "1": //this is to call method to Add contact
                    app.addContact();
                    break;
                case "2": //this is to call method to Edit contact
                    app.updateContact();
                    break;
                case "3": //this is to call method to Remove contact
                    app.deleteContact();
                    break;
                case "4": //this is to call method to search contact
                    app.searchContact();
                    break;
                case "5": //this is to call method to View contacts
                    app.viewContacts();
                    break;
            }
            System.out.println("\n");
            //This is to add a space between the menu and the inputted choices
        }
    }
    
}
