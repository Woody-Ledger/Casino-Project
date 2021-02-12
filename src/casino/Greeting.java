
package casino;

import java.util.ArrayList;


public class Greeting {
    
   // public static ArrayList<account> userList = new ArrayList<>();
    
    public static void hello(account currentUser){
        System.out.println("");
        System.out.println("Welcome to...");
        System.out.println("Press enter to continue");
        try{
            System.in.read();
        } catch(Exception e){
            
        }
        System.out.println("I8,        8        ,8I                                88                            ,ad8888ba,                       88                          ");
        System.out.println("`8b       d8b       d8'                                88                           d8\"'    `\"8b                      \"\"                          ");
        System.out.println(" \"8,     ,8\"8,     ,8\"                                 88                          d8'                                                            ");
        System.out.println("  Y8     8P Y8     8P  ,adPPYba,   ,adPPYba,   ,adPPYb,88 8b       d8 ,adPPYba,    88            ,adPPYYba, ,adPPYba, 88 8b,dPPYba,   ,adPPYba,   ");
        System.out.println("  `8b   d8' `8b   d8' a8\"     \"8a a8\"     \"8a a8\"    `Y88 `8b     d8' I8[    \"\"    88            \"\"     `Y8 I8[    \"\" 88 88P'   `\"8a a8\"     \"8a  ");
        System.out.println("   `8a a8'   `8a a8'  8b       d8 8b       d8 8b       88  `8b   d8'   `\"Y8ba,     Y8,           ,adPPPPP88  `\"Y8ba,  88 88       88 8b       d8  ");
        System.out.println("    `8a8'     `8a8'   \"8a,   ,a8\" \"8a,   ,a8\" \"8a,   ,d88   `8b,d8'   aa    ]8I     Y8a.    .a8P 88,    ,88 aa    ]8I 88 88       88 \"8a,   ,a8\"  ");
        System.out.println("     `8'       `8'     `\"YbbdP\"'   `\"YbbdP\"'   `\"8bbdP\"Y8     Y88'    `\"YbbdP\"'      `\"Y8888Y\"'  `\"8bbdP\"Y8 `\"YbbdP\"' 88 88       88  `\"YbbdP\"'   ");
        System.out.println("                                                              d8'                                                                                 ");
        System.out.println("                                                             d8'                                                                                  ");
        System.out.println("");
        System.out.println("Press enter to continue");
        try{
            System.in.read();
        } catch(Exception e){
            
        }
        System.out.println("");
        System.out.println("Welcome to the main area of Woody's Casino, " + currentUser.getUsername());
        System.out.println("");
        
        //enstead of the leaderboards showing the winners in order, it enstead just shows everyone's points which are found by taking coins borrowed away from the balance
        System.out.println("");
        System.out.println("Here are all the user's points");
        System.out.println("The higher the points, the better the player");
        System.out.println("");
        System.out.println("");
        for(int i = 0; i < Users.getUserListLength() ; i++){
            System.out.println("");
            System.out.println(Users.getUsername(i) + ": " + Users.getDifference(i) + " points");
        }
        System.out.println("");
        System.out.println("You have " + currentUser.getBalance() + " Woody Coins and have borrowed " + currentUser.getBorrowed() + " Woody Coins");
        System.out.println("");
        
        //this will only continue the program when the user has pressed the enter key, this is to break up larger text groups to read easier
        System.out.println("Press enter to continue");
        try{
            System.in.read();
        } catch(Exception e){
            
        }
    }
}
