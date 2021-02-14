package casino;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Comparator;

public class Users {

    private static String folderDirectory = System.getProperty("user.dir") + "\\userList.txt";
    private static ArrayList<account> userList = new ArrayList<>();
    static int i = 0;
    static int position = 0;

    public static void main(String[] args) {
        //this loads the user list
        load();
    }

    public static void setUserList(ArrayList<account> users){//********************JMH******************** Added this method to get userlist from file
        userList = users;
    }
    
    //this method finds an already created account
    public static account signIn() {
        Scanner input = new Scanner(System.in);
        account currentAccount = null;
        boolean again = true;
        //load();

        //this converts all of the passwords to what they actually are
            for(i = 0; i < userList.size(); i++){
                String actualPassword = "";
                String encryptedPassword = userList.get(i).getPassword();
                for(int s = 0; s < encryptedPassword.length(); s++){
                    int letter = (int) encryptedPassword.charAt(s);
                    letter = letter - 1;
                    actualPassword = actualPassword + (char) letter;
                }
                userList.get(i).setPassword(actualPassword);
            }
            
        //this will repeat until a valid account is used
        while (again == true) {
            System.out.println("");
            System.out.println("What is your username?");
            String username = input.next();

            System.out.println("");
            System.out.println("What is your password?");
            String password = input.next();
            position = -1;
            
            
            for (i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUsername().equals(username) && userList.get(i).getPassword().equals(password)) {
                    position = i;
                    break;
                }
            }
            if (position == -1) {
                System.out.println("There is no account with those details, either you entered the username or the password wrong");
                System.out.println("Try again");
            } else {
                //currentAccount = new account(userList.get(i).getUsername(), userList.get(i).getPassword(), userList.get(i).getBalance(), userList.get(i).getBorrowed());
                currentAccount = userList.get(i);
                again = false;
            }
        }
        
        //this converts all the passwords back into their encrypted version
        for(i = 0; i < userList.size(); i++){
                String actualPassword = "";
                String encryptedPassword = userList.get(i).getPassword();
                for(int s = 0; s < encryptedPassword.length(); s++){
                    int letter = (int) encryptedPassword.charAt(s);
                    letter = letter + 1;
                    actualPassword = actualPassword + (char) letter;
                }
                userList.get(i).setPassword(actualPassword);
            }
        //the current user's account details are sent back to menuA
        return (currentAccount);
    }

    //this method creates a new account
    public static account register() {
        Scanner input = new Scanner(System.in);
        boolean repeat = true;
        System.out.println("Every new account is given 50 Woody Coins free");
        System.out.println("");
        System.out.println("What is your new username?");

        String newUsername = input.next();

        System.out.println("");
        System.out.println("What is your new password?");

        String newPassword = "null";
        while (repeat == true) {
            newPassword = input.next();
            if (newPassword.length() < 10) {
                System.out.println("");
                System.out.println("The password is too weak, it must have at least 10 characters");
            } else {
                repeat = false;
            }
        }
        //this is a function to encrypt each password
        String encryptedPassword = "";
        for(int i = 0; i < newPassword.length(); i++){
            int letter = (int) newPassword.charAt(i);
            letter = letter + 1;
            encryptedPassword = encryptedPassword + (char)letter;
        }
        
        //this makes a new user with the username and password entered, a balance of 50 Woody Coins and no coins borrowed
        account newUser = new account(newUsername, encryptedPassword, 50, 0);
        userList.add(newUser);
        //this saves the list encase the user stops the program forcefully
        save();
        //the new user's account details are sent back to menuA
        return (newUser);
    }

//    public void changeBalance(){
//      //this changes the balance of the current user
//      int earning = userList.get(position).getBalance();
//      userList.get(position).setBalance(TopUp.account() + earning);
//      int borrowed = userList.get(position).getBorrowed();
//      userList.get(position).setBorrowed() + borrowed);
//      save(userList);
//    }

    public static String getUsername(int i) {

        return (userList.get(i).getUsername());
    }

    public static int getUserListLength() {
        
        return (userList.size());
    }
    
    public static int getDifference(int i) {
        
        return (userList.get(i).getBalance() - userList.get(i).getBorrowed());
    }
    public static void save() {
        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < userList.size(); i++) {
                printToFile.println(userList.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void load() {
        // ArrayList<account> userList = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] accountDetails = lineFromFile.split(",");
                //String username, String password, int balance, int borrowed
                account newAccount = new account(accountDetails[0], accountDetails[1], Integer.parseInt(accountDetails[2]), Integer.parseInt(accountDetails[3]));
                userList.add(newAccount);
            }
            read.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
