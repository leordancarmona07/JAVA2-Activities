/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_catalogue_system;

import java.util.Scanner;

/**
 *
 * @author 1styrGroupC
 */
public class Card_Catalogue_System {

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
        App app  = new App();
        while(true){
            switch (app.choice()){
                case "1": //Add
                    app.addCard();
                    break;
                case "2": //Edit
                    app.editCard();
                    break;
                case "3": //Remove
                    app.removeCard();
                    break;
                case "4": //View
                    app.viewCard();
                    break;
            }
            System.out.println("\n");
        }
    }
    
}
