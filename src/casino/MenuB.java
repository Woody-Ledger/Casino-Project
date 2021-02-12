
package casino;

import java.util.Scanner;

public class MenuB {
    public int menu(){
        Scanner input = new Scanner (System.in);
        
        System.out.println("");
        System.out.println("What would you like to do?");
        System.out.println("");
        System.out.println("1 - Play Higher or Lower");
        System.out.println("");
        System.out.println("2 - Play Black Jack");
        System.out.println("");
        System.out.println("3 - Play Roulette");
        System.out.println("");
        System.out.println("4 - Play Slot Machines");
        System.out.println("");
        System.out.println("5 - Top up your account");
        System.out.println("");
        System.out.println("6 - Logout");
        System.out.println("");
        System.out.println("7 - Exit");
        
        int choice = input.nextInt();
        return(choice);
    }
}
