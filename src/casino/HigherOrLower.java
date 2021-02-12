/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class HigherOrLower {
    
    private static int bet = 0;
    private static int money = 0;
    private static int cardNo = 0;
    //private static ArrayList<account> userList = new ArrayList<>();
  //  private static account currentUser = new account("null", "null", 0, 0);
    public static int entry(int balance){
        
        Scanner input = new Scanner (System.in);
        
        if(balance < 1){
                bet = 0;
                System.out.println("Sorry but you don't have enough Woody Coins to play this game");
                System.out.println("if you wish to play then you can top up your balance in the main menu");
            } else {
        System.out.println("Welcome to...");
        System.out.println("");
        System.out.println(" ____     ____     _________     _________    ____    ____     __________    _________ ");
        System.out.println("|    |   |    |   |___   ___|   |  _______|  |    |  |    |   |  ________|  |   ___   |");
        System.out.println("|    |___|    |       | |       | |          |    |__|    |   | |________   |  |___|  |");
        System.out.println("|             |       | |       | | ______   |            |   |          |  |    _____|");
        System.out.println("|     ___     |       | |       | ||_____ |  |     __     |   |  ________|  |  |\\  \\     ");
        System.out.println("|    |   |    |    ___| |___    | |_____| |  |    |  |    |   | |________   |  | \\  \\   ");
        System.out.println("|____|   |____|   |_________|   |_________|  |____|  |____|   |__________|  |__|  \\__\\   ");
        System.out.println("");
        System.out.println(" _________     _________");
        System.out.println("|  _____  |   |   ___   |");
        System.out.println("| |     | |   |  |___|  |");
        System.out.println("| |     | |   |    _____|");
        System.out.println("| |     | |   |  |\\  \\");
        System.out.println("| |_____| |   |  | \\  \\");
        System.out.println("|_________|   |__|  \\__\\");
        System.out.println("");
        System.out.println(" __              ___________    __    __    __    __________    ___________");
        System.out.println("|  |            |   _____   |  | |   |  |  |  |  |          |  |    ___    |");
        System.out.println("|  |            |  |     |  |  | |   |  |  |  |  |  ________|  |   |___|   |");
        System.out.println("|  |            |  |     |  |  | |   |  |  |  |  | |________   |     ______|");
        System.out.println("|  |            |  |     |  |  | |   |  |  |  |  |  ________|  |   |\\  \\");
        System.out.println("|  |            |  |     |  |  | |   |  |  |  |  | |________   |   | \\  \\");
        System.out.println("|  |_________   |  |_____|  |  | |___|  |__|  |  |          |  |   |  \\  \\");
        System.out.println("|____________|  |___________|  |______________|  |__________|  |___|   \\__\\");
        System.out.println("");
        System.out.println("");
        System.out.println("The rules are you first bet money then try to guess ");
        System.out.println("if the next card flipped is going to be higher or lower");
        System.out.println("than the previous one");
        System.out.println("");
        System.out.println("Will you?");
        System.out.println("");
        System.out.println("1 - bet");
        System.out.println("");
        System.out.println("2 - exit");
        
        int choice = input.nextInt();
         if(choice == 1){
             System.out.println("How much would you like to bet?");
             bet = input.nextInt();
             if(bet > balance){
                 System.out.println("Sorry but you don't have enough to bet that much");
                 bet = 0;
                 System.out.println("Press enter to continue");
                 try{
                    System.in.read();
                    } catch(Exception e){
            
                    }
             }
         }
    }
        return(bet);
    }
    public static int main(int bet) {
        Scanner input = new Scanner (System.in);
        
        money = 0;
        boolean game = true;
        String number = null;
        int lastCard = 0;
        int winStreak = 0;
        double winnings = 0;
        

        Deck newDeck = new Deck();
        newDeck.shuffle();
            
            winnings = bet;
            newDeck.draw();
            System.out.println("You have the " + newDeck.reveal());
            //this is connected to the subclass which deals with drawing and shuffling cards
            //drawn = newDeck.draw();
            
            //this removes the card number from the card type
          //  suit = drawn - drawn %100;
            
            //this removes the card type from the card number
          //  drawn = drawn %100;
            
            //this is to show what the card is
            
            
            System.out.println("Will you change card?");
            System.out.println("");
            System.out.println("1 - yes");
            System.out.println("");
            System.out.println("2 - no");
            int choice = input.nextInt();
            if(choice == 1){
                newDeck.draw();
                System.out.println("You have the " + newDeck.reveal());

            }
            while(game == true){
            System.out.println("Is the next card higher or lower? or would you like to stop playing?");
            System.out.println("");
            System.out.println("1 - higher");
            System.out.println("");
            System.out.println("2 - lower");
            System.out.println("");
            System.out.println("3 - stop playing");
            choice = input.nextInt();
            lastCard = newDeck.revealNumber();
            if((choice == 1)||(choice == 2)){
            newDeck.draw();
            System.out.println("You have the " + newDeck.reveal());
            }
            if(((choice == 1)&&(newDeck.revealNumber() > lastCard))||((choice == 2)&&(newDeck.revealNumber() < lastCard))){
                winStreak = winStreak + 1;
                for(int s = 0; s < winStreak ; s++){
                    winnings = winnings + (0.5 * bet);
                }
                System.out.println("You were right!");
                System.out.println("");
                System.out.println("Your winnings are currently " + winnings + " woody coins!");
            } else if((choice != 1)&&(choice != 2)){
                game = false;
                
            } else {
                game = false;
                System.out.println("You were wrong!");
                System.out.println("");
                System.out.println("You lost the chance to get " + winnings + " woody coins!");
                money = 0;
            }
            }
            if(choice == 3){
               System.out.println("You won " + winnings + " woody coins");
               money = money + (int)winnings;
            }
        return(money);
    }
   }