
package casino;

//import static higherorlower.HigherOrLower.deck;
//import static higherorlower.HigherOrLower.cardNo;
//import static higherorlower.HigherOrLower.cardType;
//import static higherorlower.HigherOrLower.drawn;
//import static higherorlower.HigherOrLower.i;
//import static higherorlower.HigherOrLower.suit;
//import static higherorlower.HigherOrLower.top;


import java.util.Random;

public class Deck {
    int top = 0;
    int [] deck = new int [52];  
    public int drawn = 0;
    
    public Deck(){
        
        int current = 0;
            
        //this creates the deck
        
        for(int i = 0; i < 4; i++){
            for(int s = 0; s < 13; s++){
                deck[current] = (i + 1)*100 + s + 1;
                current = current + 1;
            }
        }
    }
    public void shuffle(){
        Random rand = new Random();
        int replace = 0;
        for(int i = 0; i < 100; i++){
            
            int a = rand.nextInt(52);
            int b = rand.nextInt(52);
            
            //this swaps the postions of two of the cards
            replace = deck[a];
            deck[a] = deck[b];
            deck[b] = replace;
        }
        top = 0;
    }
    public int draw(){
        
        drawn = deck[top];
        
        top = top + 1;
        if(top == 53){
            shuffle();
        }
        
        
        
        return(drawn);
    }
    public String reveal(){
        
        int cardSuit = drawn - drawn %100; 
        cardSuit = cardSuit / 100;
        int cardNumber = drawn %100;
        String cardType = "null";
        
        if(cardNumber == 1){
                cardType = "Ace";
            } else if(cardNumber == 2){
                cardType = "Two";
            } else if(cardNumber == 3){
                cardType = "Three";
            } else if(cardNumber == 4){
                cardType = "Four";
            } else if(cardNumber == 5){
                cardType = "Five";
            } else if(cardNumber == 6){
                cardType = "Six";
            } else if(cardNumber == 7){
                cardType = "Seven";
            } else if(cardNumber == 8){
                cardType = "Eight";
            } else if(cardNumber == 9){
                cardType = "Nine";
            } else if(cardNumber == 10){
                cardType = "Ten";
            } else if(cardNumber == 11){
                cardType = "Jack";
            } else if(cardNumber == 12){
                cardType = "Queen";
            } else {
                cardType = "King";
            }
                 if(cardSuit == 1){
                return(cardType + " of Hearts");
            } else if(cardSuit == 2){
                return(cardType + " of Diamonds");
            } else if(cardSuit == 3){
                return(cardType + " of Clubs");
            } else {
                return(cardType + " of Spades");
            }
    }
    public int revealNumber(){
        return(drawn %100);
    }
}
