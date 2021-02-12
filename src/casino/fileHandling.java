
package casino;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class fileHandling {
    
    private static String folderDirectory = System.getProperty("user.dir")+ "\\userList.txt";
    
public static void save(ArrayList<account> userList) {
    try{
        FileWriter writeToFile = new FileWriter(folderDirectory, false);
        PrintWriter printToFile = new PrintWriter(writeToFile);
        for(int i = 0; i < userList.size() ; i++){
            printToFile.println(userList.get(i).toString());
        }
        printToFile.close();
        writeToFile.close();
    } catch (Exception e){
        System.out.println("Error: " + e);
    }
}
    public static ArrayList<account> load(){
        ArrayList<account> userList = new ArrayList<>(); // This is a temp arraylist used so we can get everything out of the file before passing it over
        String lineFromFile;
        try{
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while((lineFromFile = read.readLine()) != null){
                String[] accountDetails = lineFromFile.split(",");
                //String username, String password, int balance, int borrowed
                account newAccount = new account(accountDetails[0], accountDetails[1], Integer.parseInt(accountDetails[2]), Integer.parseInt(accountDetails[3]));
                userList.add(newAccount);
            }
            read.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return(userList);
    }
}
//    public static void create(){
//        try{
//            if(myObj.createNewFile()){
//                System.out.println("File created: " + myObj.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (IOException e){
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }
//    public static void newSave(ArrayList<account> userList){
//        try{
//            BufferedReader read = new BufferedReader(new FileReader(myObj));
//            String[] accountDetails = lineFromFile.split(",");
//            myObj.write();
//        }
//    }
//}
