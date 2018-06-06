package singleplayerbj;

import java.io.IOException;
import java.util.*;

public class Round {
    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    private String playerName;
    private boolean bustFlag;
    private boolean bjFlag;
    private static int numRounds = 0;
    //private static float stack = 100;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;
    private int playerHandCount, dealerHandCount;
    private final int DECKSIZE = 52;
    
    Round(String playerName){
        this.playerName = playerName;
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        bustFlag = false;
        bjFlag = false;
        playerHandCount = 0;
        dealerHandCount = 0;
        numRounds++;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        action();
    }
    
    public void action(){
        String playerAction = "placeholder";
        initialDeal();
        printHand();
        if(!bjFlag){
            System.out.println("Hit or Stand?\n");
            playerAction = in.nextLine(); 
        }else stand();

        while(!bjFlag && !bustFlag && !playerAction.equals("stand")){
            bustFlag = hit(bustFlag);
            if(!bustFlag) playerAction = in.nextLine();  
        }
        if(playerAction.equalsIgnoreCase("stand")){
            stand();
        }
    }
    
    public void initialDeal(){
        Card firstCard = new Card(rand.nextInt(DECKSIZE));
        Card secondCard = new Card(rand.nextInt(DECKSIZE));
        playerHand.add(firstCard);
        playerHand.add(secondCard);
        playerHandCount = firstCard.getRank() + secondCard.getRank();
        
        if( (firstCard.getPip().equals("A") && ( secondCard.getPip().equals("J") || secondCard.getPip().equals("Q") || secondCard.getPip().equals("K") ) ) || secondCard.getPip().equals("A") 
                && ( firstCard.getPip().equals("J") || firstCard.getPip().equals("Q") || firstCard.getPip().equals("K") ) ){

            System.out.println("BLACKJACK!!! You win!");
            bjFlag = true;

        }
        
        Card firstDealerCard = new Card(rand.nextInt(DECKSIZE));
        Card secondDealerCard = new Card(rand.nextInt(DECKSIZE));
        dealerHand.add(firstDealerCard);
        dealerHand.add(secondDealerCard);
        dealerHandCount = firstDealerCard.getRank() + secondDealerCard.getRank();
    }    
    
    public boolean hit(boolean bustFlag){
        Card freshCard = new Card(rand.nextInt(DECKSIZE));
        playerHand.add(freshCard);
        playerHandCount = playerHandCount + freshCard.getRank();
        printHand();
        if(playerHandCount > 21){
            System.out.println("You have busted! \n");
            return bustFlag = true;
        }else{
            return bustFlag = false;
        }
    }
    //dealer goes here
    public void stand(){
        if(!bjFlag){
            Card freshCard = new Card(rand.nextInt(DECKSIZE));
            dealerHand.add(freshCard);
            dealerHandCount = dealerHandCount + freshCard.getRank();
            printHand();
            if(dealerHandCount < 17){
                stand();
            }else if(dealerHandCount > 21){
                System.out.println("Dealer has Busted! You win!");
            }else{
                if(dealerHandCount > playerHandCount){
                    System.out.println("Dealer wins.");
                }else if(dealerHandCount < playerHandCount){
                    System.out.println("You win!");
                }else{
                    System.out.println("Push!");
                }
            }
        }
    }
    
    public void printHand(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("-------------------------------------------------------------\nROUND "+ numRounds + "\nYour hand:");
        for(Card currPlayerCard: playerHand){
            System.out.print("[" + currPlayerCard.getMyGraphic() + "]");
        }
        if(!bjFlag){
            System.out.println("\nCount: "+ playerHandCount);
        }
        System.out.println("\n\nDealer's hand:");
        for(Card currDealerCard: dealerHand){
            System.out.print("[" + currDealerCard.getMyGraphic() + "]");
        }
        System.out.print("\nCount: " + dealerHandCount + "\n\n");
    }
}
