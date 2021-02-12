
package casino;

import java.util.Scanner;

public class MenuA {
    
    //Users accounts;
    //account currentAccount;
            
    public static void menu(){
        Scanner input = new Scanner (System.in);
        //************JMH***************** Moved this to outside the if statement below
        boolean again = true;
        System.out.println("Hello and welcome to Woody's Casino");
        while(again == true){
        System.out.println("What would you like to do?");
        System.out.println("");
        System.out.println("1 - Sign in");
        System.out.println("");
        System.out.println("2 - Register");
        System.out.println("");
        System.out.println("3 - Exit");
        System.out.println("");
        int choice = input.nextInt();
        
        //menuA sends the current user's account details to the main code
            
        if(choice == 1){
            if(Users.signIn().equals(null)){
               
            } else {
                again = false;
            }
        } else if(choice == 2){
            Users.register();
            again = false;
        } else {
            System.exit(1);
        }
        
    }
    }
}
