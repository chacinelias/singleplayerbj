package singleplayerbj;

public class Card{
    private String pip;
    private int rank;
    private String suit;
    private final int DECKSIZE = 52;
    private boolean[] deck = new boolean[DECKSIZE];
    private StringBuilder myGraphic;

    private final String spades = "\u2660";
    private final String hearts = "\u2665";
    private final String diamonds = "\u2666";
    private final String clubs = "\u2663";
    
    Card(int deckIndex){
        //array for marking cards as in play (true=in play, false=not yet played)
        deck[deckIndex] = true;
        //debug print statement
//        for(int i = 0; i < DECKSIZE; i++){
//            System.out.println(i+" "+deck[i]);
//        }
        
        if(deckIndex >= 0 && deckIndex <13){
            this.suit = spades;
            //0-12  spades
            //0 1 2 3 4 5 6 7 8 9 10 11 12  
            //A 2 3 4 5 6 7 8 9 10 J  Q  K
            if(deckIndex > 9){
                rank = 10;
                if(deckIndex == 10){
                    pip = "J";
                }else if(deckIndex == 11){
                    pip = "Q";
                }else if(deckIndex == 12){
                    pip = "K";
                }
            }else{
                if(deckIndex == 0){
                    pip = "A";
                    rank = 1;
                }else{
                    rank = deckIndex + 1;
                    pip = Integer.toString(rank);
                }
            }   
            myGraphic = new StringBuilder(suit+pip);
        }
        if(deckIndex > 12 && deckIndex <26){
            this.suit = hearts;
            //13-25 hearts
            //13 14 15 16 17 18 19 20 21 22 23 24 25 
            // A  2  3  4  5  6  7  8  9 10  J  Q  K
            if(deckIndex > 22){
                rank = 10;
                if(deckIndex == 23){
                    pip = "J";
                }else if(deckIndex == 24){
                    pip = "Q";
                }else if(deckIndex == 25){
                    pip = "K";
                }
            }else{
                if(deckIndex == 13){
                    pip = "A";
                    rank = 1;
                }else{
                    rank = deckIndex - 12;
                    pip = Integer.toString(rank);
                }
            }   
            myGraphic = new StringBuilder(suit+pip);
        }
        if(deckIndex > 25 && deckIndex <39){
            this.suit = diamonds;
            //26-38 diamonds
            //26 27 28 29 30 31 32 33 34 35 36 37 38 
            //A  2  3  4  5  6  7  8  9  10  J  Q  K              
            if(deckIndex > 35){
                rank = 10;
                if(deckIndex == 36){
                    pip = "J";
                }else if(deckIndex == 37){
                    pip = "Q";
                }else if(deckIndex == 38){
                    pip = "K";
                }
            }else{
                if(deckIndex == 26){
                    pip = "A";
                    rank = 1;
                }else{
                    rank = deckIndex - 25;
                    pip = Integer.toString(rank);
                }
            }        
            myGraphic = new StringBuilder(suit+pip);
        }
        if(deckIndex > 38 && deckIndex <52){
            this.suit = clubs;
            //39-51 clubs 
            //39 40 41 42 43 44 45 46 47 48 49 50 51
            //A  2  3  4  5  6  7  8  9  10 J  Q  K             
            if(deckIndex > 48){
                rank = 10;
                if(deckIndex == 49){
                    pip = "J";
                }else if(deckIndex == 50){
                    pip = "Q";
                }else if(deckIndex == 51){
                    pip = "K";
                }           
            }else{
                if(deckIndex == 39){
                    pip = "A";
                    rank = 1;
                }else{
                    rank = deckIndex - 38;
                    pip = Integer.toString(rank);
                }
            }   
            myGraphic = new StringBuilder(suit+pip);
        }
    }

    public int getRank() {
        return rank;
    }

    public String getPip() {
        return pip;
    }

    public StringBuilder getMyGraphic() {
        return myGraphic;
    }
    
}
