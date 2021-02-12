
package casino;

import java.util.Scanner;
import java.util.Random;

public class Roulette {
    
    private static int winning = 0;
    private static int bet = 0;
    private static int choice = 0;
    private static int type = 0;
    
    public static int entry(int balance){
        Scanner input = new Scanner(System.in);
        
        if(balance < 1){
                bet = 0;
                System.out.println("Sorry but you don't have enough Woody Coins to play this game");
                System.out.println("if you wish to play then you can top up your balance in the main menu");
        } else {
        System.out.println("Hello and welcome to...");
        System.out.println("                                   88                                       ");
        System.out.println("                                   88              ,d      ,d               ");
        System.out.println("                                   88              88      88               ");
        System.out.println("8b,dPPYba,  ,adPPYba,  88       88 88  ,adPPYba, MM88MMM MM88MMM ,adPPYba,  ");
        System.out.println("88P'   \"Y8 a8\"     \"8a 88       88 88 a8P_____88   88      88   a8P_____88  ");
        System.out.println("88         8b       d8 88       88 88 8PP\"\"\"\"\"\"\"   88      88   8PP\"\"\"\"\"\"\"  ");
        System.out.println("88         \"8a,   ,a8\" \"8a,   ,a88 88 \"8b,   ,aa   88,     88,  \"8b,   ,aa  ");
        System.out.println("88          `\"YbbdP\"'   `\"YbbdP'Y8 88  `\"Ybbd8\"'   \"Y888   \"Y888 `\"Ybbd8\"'  ");
        System.out.println("");
        System.out.println("The rules are that you get to choose from one of the following bets:");
        System.out.println("");
        System.out.println("1 - Red or Black");
        System.out.println("");
        System.out.println("2 - A single number (1 - 36)");
        System.out.println("");
        System.out.println("3 - A group of numbers (1 - 12, 13 - 24, 25 - 36)");
        System.out.println("");
                    System.out.println("Press enter to continue");
                    try{
                        System.in.read();
                        } catch(Exception e){
                        }
        System.out.println("");
        System.out.println("You will then choose how much you would like to bet");
        System.out.println("if you win then you get paid back the money and extra based on the bet you chose");
        System.out.println("");
                    System.out.println("Press enter to continue");
                    try{
                        System.in.read();
                        } catch(Exception e){
                        }
        System.out.println("");
        System.out.println("Which bet will you choose?");
        System.out.println("");
        System.out.println("");
        System.out.println("1 - Red or Black");
        System.out.println("");
        System.out.println("2 - A single number (1 - 36)");
        System.out.println("");
        System.out.println("3 - A group of numbers (1 - 12, 13 - 24, 25 - 36");
        System.out.println("");
        System.out.println("4 - or you can exit");
        choice = input.nextInt();
        type = choice;
        winning = 0;
        if(choice < 4){
             System.out.println("How much would you like to bet?");
             bet = input.nextInt();
             if(bet > balance){
                 System.out.println("Sorry but you don't have enough to bet that much");
                 bet = 0;
             }
         } else {
            bet = 0;
        }
    }
        return(bet);
    }

    public static int main(int bet) {
        Scanner input = new Scanner (System.in);
        Random r1 = new Random();
        int colour = 0;
        int number = 0;
        boolean win = false;
        String ballColour = "null";
        boolean result = false; 
        
        
        choice = type;
        
        if(choice != 4){
        if(choice == 1){
            System.out.println("What colour will you choose?");
            System.out.println("");
            System.out.println("1 - Red");
            System.out.println("");
            System.out.println("2 - Black");
            colour = input.nextInt();
            if((colour != 1)&&(colour != 2)){
                boolean error = true;
                while(error == true){
                System.out.println("Invalid option, try again");
                colour = input.nextInt();
                if((colour != 1)&&(colour != 2)){
                    
                } else {
                    error = false;
                }
            }
        }
        }
        if(choice == 2){
            System.out.println("What number will you choose?");
            number = input.nextInt();
            
            if((number < 1)||(number > 36)){
            boolean error = true;
            while(error == true){
                System.out.println("Invalid option, try again");
                number = input.nextInt();
                if((number < 1)||(number > 36)){
                    
                } else {
                    error = false;
                }
        }
        
    }
            

}
            if(choice == 3){
                System.out.println("What set of numbers will you choose?");
                System.out.println("");
                System.out.println("1 - (1 - 12)");
                System.out.println("");
                System.out.println("2 - (13 - 24)");
                System.out.println("");
                System.out.println("3 - (25 - 36)");
                number = input.nextInt();
                if((number < 1)||(number > 3)){
                    boolean error = true;
                    while(error == true){
                        System.out.println("Invalid option, try again");
                        number = input.nextInt();
                        if((number < 1)||(number > 3)){
                            
                        } else {
                            error = false;
                        }
                    }
                }
            }
            
            //this is where the ball's postion is randomized
            int ball = r1.nextInt(36);
            
            //this is where the ball's collumm is worked out
            int column = (int) Math.ceil(ball / 12.0);
            
            if((choice == 1)&&(colour == 1)&&(ball %2 == 1)){
                win = true;
            } else if((choice == 1)&&(colour == 1)&&(ball %2 == 0)){
                win = false;
            } else if((choice == 1)&&(colour == 2)&&(ball %2 == 1)){
                win = false;
            } else if((choice == 1)&&(colour == 2)&&(ball %2 == 0)){
                win = true;
            } else if((choice == 2)&&(number == ball)){
                win = true;
            } else if((choice == 2)&&(number != ball)){
                win = false;
            } else if((choice == 3)&&(number == column)){
                win = true;
            } else {
                win = false;
            }
            if(ball == 0){
                win = false;
            }
            if(choice == 1){
                winning = bet;
            } else if(choice == 2){
                winning  = bet * 35;
            } else {
                winning = bet * 2;
            }
            if(ball %2 == 1){
                ballColour = "red";
            } else {
                ballColour = "black";
            }
            System.out.println("The ball landed on " + ball + " " + ballColour);
            if(win == true){
                System.out.println("");
                System.out.println("You won " + winning + " Woody Coins");
            } else {
                System.out.println("");
                System.out.println("You lost " + bet + " Woody Coins");
                winning = 0;
            }
                }
        return(winning);
}
}