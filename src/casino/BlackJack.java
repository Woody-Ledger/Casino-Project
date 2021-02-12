
package casino;

import java.util.Scanner;

public class BlackJack {

    private static int bet = 0;
    private static int reward = 0;
    
    public static int entry(int balance){
        Scanner input = new Scanner(System.in);
        
        if(balance < 1){
                bet = 0;
                System.out.println("Sorry but you don't have enough Woody Coins to play this game");
                System.out.println("if you wish to play then you can top up your balance in the main menu");
        } else {
        System.out.println("Welcome...");
        System.out.println("");
        System.out.println("88888888ba  88                       88                   88                       88         ");
        System.out.println("88      \"8b 88                       88                   88                       88         ");
        System.out.println("88      ,8P 88                       88                   88                       88         ");
        System.out.println("88aaaaaa8P' 88 ,adPPYYba,  ,adPPYba, 88   ,d8             88 ,adPPYYba,  ,adPPYba, 88   ,d8   ");
        System.out.println("88\"\"\"\"\"\"8b, 88 \"\"     `Y8 a8\"     \"\" 88 ,a8\"              88 \"\"     `Y8 a8\"     \"\" 88 ,a8\"    ");
        System.out.println("88      `8b 88 ,adPPPPP88 8b         8888[                88 ,adPPPPP88 8b         8888[      ");
        System.out.println("88      a8P 88 88,    ,88 \"8a,   ,aa 88`\"Yba,     88,   ,d88 88,    ,88 \"8a,   ,aa 88`\"Yba,   ");
        System.out.println("88888888P\"  88 `\"8bbdP\"Y8  `\"Ybbd8\"' 88   `Y8a     \"Y8888P\"  `\"8bbdP\"Y8  `\"Ybbd8\"' 88   `Y8a  ");
        System.out.println("");
        System.out.println("");
        System.out.println("What do you want to do?");
        System.out.println("");
        System.out.println("1 - Play");
        System.out.println("");
        System.out.println("2 - exit");
        int choice = input.nextInt();
        if(choice == 1){
             System.out.println("How much would you like to bet?");
             bet = input.nextInt();
             if(bet > balance){
                 System.out.println("Sorry but you don't have enough to bet that much");
                 bet = 0;
             }
         }
    }
        return(bet);
    }
    public static int main(int bet){
        
    Scanner input = new Scanner(System.in);

    //as a reminder, aces are 1
    boolean won = false;
    boolean playing = true;
        
        int[] cards = new int[52];
        String[] wordCards = new String[52];
        int i = 1;
        
            reward = bet;
            
            //when the game starts, two cards are drawn
            Deck newDeck = new Deck();
            newDeck.shuffle();
                
            cards[0] = newDeck.draw();
            wordCards[0] = newDeck.reveal();
            
            System.out.print("You have the " + newDeck.reveal());
                
            cards[1] = newDeck.draw();
            wordCards[1] = newDeck.reveal();
            
            System.out.println(" and the " + newDeck.reveal());
            
            //if all the cards add up to over 21 then the game ends
            int sum = (cards[0] %100) + (cards[1] %100);
            if(sum > 21){
                playing = false;
                won = false;
                System.out.println("Your cards added up to over 21 so you lose");
            }
            while(playing == true){
                i = i + 1;
                System.out.println("Will you:");
                System.out.println("");
                System.out.println("1 - hit");
                System.out.println("");
                System.out.println("2 - or stop");
                int choice = input.nextInt();
                if(choice == 1){
                   
                    cards[i] = newDeck.draw();
                    wordCards[i] = newDeck.reveal();
                    
                    System.out.println("You drew the " + newDeck.reveal());
                    System.out.print("You have the " + wordCards[0]);
                    sum = cards[0] % 100;
                    for(int s = 1; s < i + 1; s++){
                        sum = sum + (cards[s] %100);
                        System.out.print(" and the " + wordCards[s]);
                    }
                    System.out.println("");
                    if(sum > 21){
                        System.out.println("Your cards added up to over 21 so you lose");
                        won = false;
                        playing = false;
                    }
                    System.out.println("");
                    System.out.println("Press enter to continue");
                    try{
                        System.in.read();
                        } catch(Exception e){
                        }
                } else {
                    playing = false;
                    if (sum > 18){
                        won = true;
                    reward = reward + bet;
                } else {
                    won = false;
                    System.out.println("You only win if it's between 19 and 21");
                    System.out.println("");
                    System.out.println("Press enter to continue");
                    try{
                        System.in.read();
                    } catch(Exception e){
            
                    }   
                }
            }
            }
            if(won == true){
                System.out.println("Congratulations you won " + reward + " Woody Coins");
            } else {
                System.out.println("You lost " + bet + " Woody Coins");
                System.out.println("Press enter to continue");
                try{
                    System.in.read();
                } catch(Exception e){
            
                }
            }
        return(reward);
    }
}
