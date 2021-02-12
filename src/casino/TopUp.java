/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.util.ArrayList;
import java.util.Scanner;

public class TopUp {
    
    private static int choice = 0;
   // private static ArrayList<account> userList = new ArrayList<>();
    
    public static int account(){
        Scanner input = new Scanner (System.in);
        System.out.println("");
        System.out.println("How much money do you want to add to your account?");
        System.out.println("");
        System.out.println("1 - 5 Woody Coins");
        System.out.println("");
        System.out.println("2 - 10 Woody Coins");
        System.out.println("");
        System.out.println("3 - 20 Woody Coins");
        System.out.println("");
        System.out.println("4 - 50 Woody Coins");
        System.out.println("");
        System.out.println("5 - 100 Woody Coins");
        System.out.println("");
        System.out.println("6 - custom amount");
        
        choice = input.nextInt();
        if(choice == 1){
            choice = 5;
            System.out.println("");
            System.out.println("5 Woody Coins have been added");
        } else if(choice == 2){
            System.out.println("");
            System.out.println("10 Woody Coins have been added");
            choice = 10;
        } else if(choice == 3){
            System.out.println("");
            System.out.println("20 Woody Coins have been added");
            choice = 20;
        } else if(choice == 4){
            System.out.println("");
            System.out.println("50 Woody Coins have been added");
            choice = 50;
        } else if(choice == 5){
            System.out.println("");
            System.out.println("100 Woody Coins have been added");
            choice = 100;
        } else {
            System.out.println("");
            System.out.println("How many Woody Coins would you like to add?");
            choice = input.nextInt();
            System.out.println("");
            System.out.println(choice + " Woody Coins have been added");
        }
        return(choice);
    }
}
