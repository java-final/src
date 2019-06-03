import java.util.*;

public class Cards{

    public static ArrayList<String> shuffle(ArrayList<String> deck) {
        //this method shuffles the deck randomly
        ArrayList<String> x = new ArrayList<String>();
        for (int i = 0; i < 52; i++) {
            Random random = new Random(); //randomness!
            int y = random.nextInt(deck.size());
            x.add(deck.get(y));
            deck.remove(y);
        }
        return x;
    }
    public static ArrayList<String> createDeck(String [] deck){
        //this method creates a deck of 52 cards
        ArrayList<String> newDeck = new ArrayList<String>();
        for(int i = 0; i < deck.length; i++){
            newDeck.add(deck[i]);
        }
        return newDeck;
    }
    public static void divideDeck(ArrayList<String> fullDeck, ArrayList<String> playerDeck, ArrayList<String> opponentDeck){
       //this method divides the deck into 26 cards each
        for(int i = 1; i < 53; i++){
            if(i % 2 == 0){
                playerDeck.add(fullDeck.get(i - 1));
            }
            else{
                opponentDeck.add(fullDeck.get(i - 1));
            }
        }
    }
    public static boolean result(int playerCardValue, int opponentCardValue, ArrayList<String> playerDeck,
                                 ArrayList<String> opponentDeck, ArrayList<String> mid, int warCount, boolean game, int playerCount, int opponentCount){
        //this method checks what card value is larger, and adds/removes cards to the decks
        if(warCount < 2){
            mid.add(playerDeck.get(0));
            mid.add(opponentDeck.get(0));
            playerDeck.remove(0);
            opponentDeck.remove(0);
        }
        if(playerCardValue > opponentCardValue){
            Cards.playerWins(playerDeck, opponentDeck, mid, warCount, playerCount);

        }
        else if(opponentCardValue > playerCardValue){
            Cards.opponentWins(playerDeck, opponentDeck, mid, warCount, opponentCount);

        }
        else{
            if(playerDeck.size() < 2 || opponentDeck.size() < 2){
                game = false;
            }
            else{
                mid.add(playerDeck.get(0));
                mid.add(opponentDeck.get(0));
                playerDeck.remove(0);
                opponentDeck.remove(0);
                mid.add(playerDeck.get(0));
                mid.add(opponentDeck.get(0));
                playerDeck.remove(0);
                opponentDeck.remove(0);
                Cards.war(playerDeck, opponentDeck, mid, warCount, game, playerCount, opponentCount);
            }
        }
        return game;
    }
    public static void playerWins(ArrayList<String> playerDeck, ArrayList<String> opponentDeck,
                                  ArrayList<String> mid, int warCount, int playerCount){
        //this method is called when the player card value is larger
        if(warCount > 1){
            System.out.println("You WON the war round! So, you received >> " + mid);
        }
        else{
            System.out.println("You won this round!! \n");
        }
        System.out.println();
        playerDeck.addAll(mid);
        mid.clear();
    }
    public static void opponentWins(ArrayList<String> playerDeck, ArrayList<String> opponentDeck,
                                    ArrayList<String> mid, int warCount, int opponentCount){
        //this method is called when the opponent card value is larger
        if(warCount > 1){
            System.out.println("Aw... They won the war round.");
        }
        else{
            System.out.println("The opponent won the round. \n");

        }
        System.out.println();
        opponentDeck.addAll(mid);
        mid.clear();
    }
    public static int rank(String cards){
        //this method puts certain card rankings at a higher value: ace = highest, 2 = lowest
        int rank = 0;
        if(cards.charAt(0) == 'X'){
            rank = 10;
        }
        else if(cards.charAt(0) == 'J'){
            rank = 11;
        }
        else if(cards.charAt(0) == 'Q'){
            rank = 12;
        }
        else if(cards.charAt(0) == 'K'){
            rank = 13;
        }
        else if(cards.charAt(0) == 'A'){
            rank = 14;
        }
        else{
            rank = Character.getNumericValue(cards.charAt(0));
        }
        return rank;
    }
    public static void war(ArrayList<String> playerDeck, ArrayList<String> opponentDeck, ArrayList<String> mid,
                           int warCount, boolean game,int playerCount,int opponentCount){
      //called when there is a war (two cards hold same rank)
        Scanner input = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~~ENTERING WAR~~~~~~~~~~~~~~~~~~~~");
        System.out.println("You each place a face down card");
        System.out.println();

        String playerWarCard = mid.get(mid.size()-2);
        String opponentWarCard = mid.get(mid.size()-1);
        int playerWarRank = Cards.rank(playerWarCard);
        int opponentWarRank = Cards.rank(opponentWarCard);

        System.out.println("You now play a face up card: " + playerWarCard);
        System.out.println("Press enter to see the outcome...");
        input.nextLine();
        System.out.println("They play a face up card: " + opponentWarCard);
        warCount++;
        Cards.result(playerWarRank, opponentWarRank, playerDeck, opponentDeck, mid, warCount, game, playerCount, opponentCount);
    }
}
