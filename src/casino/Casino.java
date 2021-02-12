package casino;

import java.util.ArrayList;
import java.util.Scanner;

public class Casino {

    // public static ArrayList<account> userList = new ArrayList<>();
    private static account currentUser = new account("null", "null", 0, 0);
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Users.setUserList(fileHandling.load()); // ***************************** JMH ******************** Changed this line to get the data from the file into the users class

        int verify = 0;
        int choice = 0;
        int option = 0;
        boolean playing = true;
        boolean repeat = true;
        boolean gamePlay = false;
        
        //each of the games have a copy of the current user's data which they can rewrite after the user has finished playing the game
        HigherOrLower game1 = new HigherOrLower();
        BlackJack game2 = new BlackJack();
        Roulette game3 = new Roulette();
        SlotMachine game4 = new SlotMachine();
        TopUp account = new TopUp();
        while (repeat == true) {

            //this holds the current account's details which can be used for other classes to use
            menu();
            
            //this is to make sure that the main part of the casino works after the first time it has run
            playing = true;
            
            //in each of the games are two classes: entry and main
            //entry is to check that the user has enough money to play as well as to make sure that the bet that is put down can be paid by the account
            //main is where the actual game part is
            //after either of these classes have finished, the program saves to make sure that the actions aren't taken back
            
            while (playing == true) {
                
                Greeting greet = new Greeting();
                greet.hello(currentUser);
                MenuB menuB = new MenuB();
                choice = menuB.menu();
                if (choice == 1) {
                    gamePlay = true;
                    while(gamePlay == true){
                    
                    verify = game1.entry(currentUser.getBalance());
                    
                    if(verify > 0){
                    currentUser.setBalance(currentUser.getBalance() - verify);
                    Users.save();
                    currentUser.setBalance(currentUser.getBalance() + game1.main(verify));
                    Users.save();
                    System.out.println("Would you like to play again?");
                    System.out.println("");
                    System.out.println("1 - Yes");
                    System.out.println("");
                    System.out.println("2 - No");
                    option = input.nextInt();
                    if(option == 1){
                        gamePlay = true;
                    } else {
                        gamePlay = false;
                    }
                    } else {
                        gamePlay = false;
                    }
                    }

                } else if (choice == 2) {
                    gamePlay = true;
                    while(gamePlay == true){
                    verify = game2.entry(currentUser.getBalance());
                    
                    if(verify > 0){
                    currentUser.setBalance(currentUser.getBalance() - verify);
                    Users.save();
                    currentUser.setBalance(currentUser.getBalance() + game2.main(verify));
                    Users.save();
                    System.out.println("Would you like to play again?");
                    System.out.println("");
                    System.out.println("1 - Yes");
                    System.out.println("");
                    System.out.println("2 - No");
                    option = input.nextInt();
                    if(option == 1){
                        gamePlay = true;
                    } else {
                        gamePlay = false;
                    }
                    } else {
                        gamePlay = false;
                    }
                            }
                } else if (choice == 3) {
                    gamePlay = true;
                    while(gamePlay == true){
                        verify = game3.entry(currentUser.getBalance());
                        if(verify > 0){
                            currentUser.setBalance(currentUser.getBalance() - verify);
                            Users.save();
                            currentUser.setBalance(currentUser.getBalance() + game3.main(verify));
                            Users.save();
                            System.out.println("Would you like to play again?");
                            System.out.println("");
                            System.out.println("1 - Yes");
                            System.out.println("");
                            System.out.println("2 - No");
                            option = input.nextInt();
                            if(option == 1){
                                gamePlay = true;
                            } else {
                                gamePlay = false;
                            }
                            } else {
                                gamePlay = false;
                            }
                        }
                } else if (choice == 4) {
                    gamePlay = true;
                    while(gamePlay == true){
                        verify = game4.entry(currentUser.getBalance());
                        if(verify == 1){
                            currentUser.setBalance(currentUser.getBalance() - 1);
                            Users.save();
                            currentUser.setBalance(currentUser.getBalance() + game4.main());
                            Users.save();
                        } else {
                            gamePlay = false;
                        }
                    }
                } else if (choice == 5) {

                    //this will get a method in Users to use a method in TopUp to add money to the account details as well as add how much you have borrowed
                    int change = TopUp.account();
                    currentUser.setBalance(currentUser.getBalance() + change);
                    currentUser.setBorrowed(currentUser.getBorrowed() + change);
                    //whenever User.save(); is used a new copy of the accounts are made
                    Users.save();
                } else if (choice == 6) {
                    playing = false;
                } else {
                    repeat = false;
                    playing = false;
                }
            }
        }
    }

    public static void menu() {
        //  Scanner input = new Scanner (System.in);
        boolean again = true;
        System.out.println("Hello and welcome to Woody's Casino");
        while (again == true) {
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
            if (choice == 1) {
                currentUser = Users.signIn();
                if (currentUser.equals(null)) {
                    System.out.println("An error has occurred");
                } else {
                    again = false;
                }
            } else if (choice == 2) {
                currentUser = Users.register();
                again = false;
            } else {
                System.exit(1);
            }

        }
    }
}
