package singleplayerbj;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class SinglePlayerBJ {

    protected static SinglePlayerBJ thread;
    
    public static void main(String[] args) throws InterruptedException{
        Scanner in = new Scanner(System.in);
        String playerName;
        String playAgain = "yes";
        
        System.out.println("\t\t\u2665\u2660-BLACKJACK-\u2666\u2663\n\n\n\n");
        
        System.out.println("Please enter your name:");
        playerName = in.nextLine();
        System.out.println("Welcome " + playerName + ", you will start with $100 in your stack. \n\n\n\t\tCards are being dealt...\n");
        
        //////////timer code:
        thread = new SinglePlayerBJ();
        Timer timer = new Timer();
        TimerTask task = new Helper();
        
        Date date = new Date();
        timer.schedule(task, 1000, 1000);
        
        synchronized(thread){
            thread.wait();
            timer.cancel();
            timer.purge();
        }     
        ////////////end timer code
                  
        while(!playAgain.equalsIgnoreCase("n")){
            Round newRound = new Round(playerName);
            System.out.println("\t\tWould you like to play again? (n for no)");
            playAgain = in.nextLine();
            if(playAgain.equals("n")){
                System.out.println("Goodbye!");
            }
        }      
    }   
}

class Helper extends TimerTask{
    String[] suits = {"\u2665","\u2660","\u2666","\u2663"};
    public static int i = 0;
    public void run(){
        System.out.println("\t\t\t"+suits[i]);
        i++;
        if(i == 4){
            synchronized(SinglePlayerBJ.thread)
            {
                SinglePlayerBJ.thread.notify();
            }
        }
    }    
}

/*TODO:
-Make aces' rank both 1 and 10 when necesary
-Fix duplicate cards!
-Add betting
-Add clearScreen()
-Add timed transitions
-Dealer gets initially dealt one face up card and one face down
-Add a split play after initial deal is a pair
-Dealer is hitting when he should stay (right after initial deal)
-No "hit or stand?" prompt after initial deal
-Get brokeFlag working for ending game
*/