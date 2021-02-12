
package casino;

import java.util.Comparator;

public class account {
    private String username;
    private String password;
    private int balance;
    private int borrowed;
    
    public account(String username, String password, int balance, int borrowed) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.borrowed = borrowed;
    }

    public String toString() {
        return username+","+password+","+balance+","+borrowed;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public int getBorrowed() {
        return borrowed;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setBorrowed(int borrowed) {
        this.borrowed = borrowed;
    }
    public void saveToFile(String fileName){
       
    }
    public void loadFromFile(String fileName){
        
    }
//    class balanceCompare implements Comparator<account>
//    {
//        @Override
//        public int compaew(account s1, account s2)
//        {
//            return s2.balance - s1.balance;
//        }
//    }
}
