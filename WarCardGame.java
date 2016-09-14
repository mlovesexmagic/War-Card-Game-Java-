/*Zhipeng (Adrian) Mei
  August 30, 2016 
  Purpose: This program is a card game called War. For purly entertainment only.
  Inputs: This program does not ask use for any input.
  Output: The winner of War card game.
*/
import java.util.ArrayList;     //import ArrayList  
import java.util.Random;        //import Random
import java.util.List;          //import List
import java.util.Collections;   //import Collections
import java.util.LinkedList;    //import LinkList

public class WarCardGame {
    public static void main(String[] args) {
        
        List<Card> cardDeck = new ArrayList<Card>(); //create an ArrayList "cardDeck"
        
        for(int x=0; x<4; x++){          //0-3 for suit (4 suits)
            for(int y=2; y<15; y++){     //2-14 for rank (13 ranks)
                cardDeck.add(new Card(x,y)); //create new card and add into the deck
            } //end rank for
        }//end suit for
        
        Collections.shuffle(cardDeck, new Random()); //shuffle the deck randomly
        
        //creating 2 decks, each for player1/player2
        LinkedList<Card> deck1 = new LinkedList<Card>();
        LinkedList<Card> deck2 = new LinkedList<Card>();
        
        deck1.addAll(cardDeck.subList(0, 25));              //26 cards for p1       
        deck2.addAll(cardDeck.subList(26, cardDeck.size()));//26 cards for p2
        
        while(true){
            Card p1Card = deck1.pop();  //each player place one card face up
            Card p2Card = deck2.pop();
            
            //display the face up card
            System.out.println("Player 1 plays card is " + p1Card.toString());
            System.out.println("Player 2 plays card is " + p2Card.toString());
            
            //rank comparation between two cards
            if(p1Card.getCard() > p2Card.getCard()){//if player 1 win 
                deck1.addLast(p1Card);  //higher rank wins both cards and 
                deck1.addLast(p2Card);  //places them at the bottom of his deck.
                System.out.println("PLayer 1 wins the round");
            }//end if
 
            else if(p1Card.getCard() < p2Card.getCard()){//if player 2 win 
                deck2.addLast(p1Card);   
                deck2.addLast(p2Card);  
                System.out.println("PLayer 2 wins the round");
            }//end else if
            
            else { //war happens when both cards' rank matched
                System.out.println("War"); 
                
                //creating war cards
                List<Card> war1 = new ArrayList<Card>(); 
                List<Card> war2 = new ArrayList<Card>();
                
                //checking do players have enough (4)cards to stay in game
                for(int x=0; x<3; x++){ 
                    //either one player runs out of card is game over
                    if(deck1.size() == 0 || deck2.size() == 0 ){                      
                        break;
                    }//end if
                    
                    System.out.println("War card for player1 is xx\nWar card for player2 is xx");

                    war1.add(deck1.pop());  //place additional card for war
                    war2.add(deck2.pop());                  
                }//end for
                
                //only compare result when both players have enough cards for war
                if(war1.size() == 3 && war2.size() == 3 ){
                    //display the war cards from each player
                    System.out.println("War card for player1 is " + war1.get(0).toString());
                    System.out.println("War card for player2 is " + war2.get(0).toString());
                    
                    //if player 1 wins the war round
                    if(war1.get(2).getCard() > war2.get(2).getCard()){
                        deck1.addAll(war1); //player1 get all 10 cards
                        deck1.addAll(war2);
                        System.out.println("Player 1 wins the war round");
                    }//end if
                    //otherwise player 2 wins the war round
                    else{
                        deck2.addAll(war1); //player2 get all 10 cards
                        deck2.addAll(war2);
                        System.out.println("Player 2 wins the war round");
                    }//end else                      
                }//end if
                
            }//end war round else
            
            //game over either one player runs out of card(deck size is 0)
            if(deck1.size() == 0 ){
                System.out.println("game over\nPlayer 1 wins the game");
                break;
            }
            else if(deck2.size() == 0){
                System.out.println("game over\nPlayer 2 wins the game");
                break;
            }
        }//end while  

    }//end main       
}//end WarCardGame class
