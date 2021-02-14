
package casino;

import java.util.Scanner;
import java.util.Random;

public class SlotMachine {

    public static int entry(int balance){
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to...");
            System.out.println("");
            System.out.println(" ad88888ba  88                       88b           d88                       88          88                         ");
            System.out.println("d8\"     \"8b 88              ,d       888b         d888                       88          \"\"                         ");
            System.out.println("Y8,         88              88       88`8b       d8'88                       88                                     ");
            System.out.println("`Y8aaaaa,   88  ,adPPYba, MM88MMM    88 `8b     d8' 88 ,adPPYYba,  ,adPPYba, 88,dPPYba,  88 8b,dPPYba,   ,adPPYba,  ");
            System.out.println("  `\"\"\"\"\"8b, 88 a8\"     \"8a  88       88  `8b   d8'  88 \"\"     `Y8 a8\"     \"\" 88P'    \"8a 88 88P'   `\"8a a8P_____88  ");
            System.out.println("        `8b 88 8b       d8  88       88   `8b d8'   88 ,adPPPPP88 8b         88       88 88 88       88 8PP\"\"\"\"\"\"\"  ");
            System.out.println("Y8a     a8P 88 \"8a,   ,a8\"  88,      88    `888'    88 88,    ,88 \"8a,   ,aa 88       88 88 88       88 \"8b,   ,aa  ");
            System.out.println(" \"Y88888P\"  88  `\"YbbdP\"'   \"Y888    88     `8'     88 `\"8bbdP\"Y8  `\"Ybbd8\"' 88       88 88 88       88  `\"Ybbd8\"'  ");
            System.out.println("");
            if(balance < 1){
            System.out.println("Sorry but you don't have enough Woody Coins to play");
            System.out.println("Press enter to continue");
            try{
            System.in.read();
            } catch(Exception e){
            
            }
            }
            System.out.println("Welcome to the slot machines.");
            System.out.println("");
            System.out.println("One go costs one Woody Coin");
            System.out.println("");
            System.out.println("Would you like to:");
            System.out.println("");
            System.out.println("1 - Play");
            System.out.println("");
            System.out.println("2 - Leave");
            
            int choice = input.nextInt();
            if(choice != 1){
                choice = 0;
            }
            return(choice);
    }
    
    public static int main() {
        Scanner input = new Scanner (System.in);
        Random rand = new Random();
        
        int money = 0;
        String[] slot = new String[4];
        int result = 0;   
        boolean again = true;
        int prize = 0;
            
                for(int i = 0 ; i < 4 ; i++){
                    //there are 115 different sides to each of the slots so 40 of them are melons, 30 of them are plums, 10 of them are grapes, 10 of them are oranges, 5 of them are cherries, 5 of them are sevens, 3 of them are bells, and 2 of them are bars
                result = rand.nextInt(114) + 1;
                if((result > 0)&&(result < 41)){
                    slot[i] = "Melon";
                    prize = 5;
                } else if((result > 40)&&(result < 71)){
                    slot[i] = "Plum";
                    prize = 10;
                } else if((result > 70)&&(result < 81)){
                    slot[i] = "Grape";
                    prize = 15;
                } else if((result > 80)&&(result < 91)){
                    slot[i] = "Lemon";
                    prize = 20;
                } else if((result > 90)&&(result < 101)){
                    slot[i] = "Orange";
                    prize = 25;
                } else if((result > 100)&&(result < 106)){
                    slot[i] = "Cherry";
                    prize = 30;
                } else if((result > 105)&&(result < 111)){
                    slot[i] = "Seven";
                    prize = 50;
                } else if((result > 110)&&(result < 113)){
                    slot[i] = "Bell";
                    prize = 100;
                } else {
                    slot[i] = "Bar";
                    prize = 1000;
                }
            }
                System.out.println("");
                System.out.println("________________________________________________________________________");
                System.out.print("     |      ");
                System.out.print(slot[1]);
                System.out.print("        |        ");
                System.out.print(slot[2]);
                System.out.print("        |        ");
                System.out.print(slot[3]);
                System.out.println("        |        ");
                
                if(slot[1].equals(slot[2])&&(slot[2].equals(slot[3]))){
                    System.out.println("Congratulations, you got three " + slot[1] + "s");
                    System.out.println("You won " + prize + " Woody Coins");
                } else {
                    System.out.println("You didn't get anything");
                    prize = 0;
                }
        System.out.println("Press enter to continue");
        try{
            System.in.read();
        } catch(Exception e){
            
        }
return(prize);   
}
}