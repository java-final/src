import java.util.*;

public class Cards{

    public static ArrayList<String> shuffle(ArrayList<String> deck) {
        ArrayList<String> x = new ArrayList<String>();
        for (int i = 0; i < 52; i++) {
            Random random = new Random();
            int y = random.nextInt(deck.size());
            x.add(deck.get(y));
            deck.remove(y);
        }
        return x;
    }
    public static ArrayList<String> createDeck(String [] deck){
        ArrayList<String> newDeck = new ArrayList<String>();
        for(int i = 0; i < deck.length; i++){
            newDeck.add(deck[i]);
        }
        return newDeck;
    }
    public static void divideDeck(ArrayList<String> fullDeck, ArrayList<String> playerDeck, ArrayList<String> opponentDeck){
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
            rank=Character.getNumericValue(cards.charAt(0));
        }
        return rank;
    }
    public static void war(ArrayList<String> playerDeck, ArrayList<String> opponentDeck, ArrayList<String> mid,
                           int warCount, boolean game,int playerCount,int opponentCount){//addresses decks when there is a war
        Scanner input = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~~ENTERING WAR~~~~~~~~~~~~~~~~~~~~");
        System.out.println("You each place a face down card");
        System.out.println();

        String playerWarCard=mid.get(mid.size()-2);
        String houseWarCard=mid.get(mid.size()-1);
        int playerWarRank= Cards.rank(playerWarCard);
        int houseWarRank = Cards.rank(houseWarCard);

        System.out.println("You now play a face up card: " + playerWarCard);
        System.out.println("Press enter to see the outcome...");
        input.nextLine();
        System.out.println("They play a face up card: " + houseWarCard);
        warCount++;
        Cards.result(playerWarRank, houseWarRank, playerDeck, opponentDeck, mid, warCount, game, playerCount, opponentCount);
    }
}
