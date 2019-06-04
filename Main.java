import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] cards = {"AC", "AS", "AH", "AD", "KC", "KS", "KH", "KD", "QC", "QS", "QH", "QD", "JC", "JS", "JH",
                "JD", "XC", "XS", "XH", "XD", "9C", "9S", "9H", "9D", "8C", "8S", "8H", "8D", "7C", "7S",
                "7H", "7D", "6C", "6S", "6H", "6D", "5C", "5S", "5H", "5D", "4C", "4S", "4S", "4D", "3C", "3S",
                "3H", "3D", "2C", "2S", "2H", "2D"};
        //An array for all of the cards in a deck, with "Q" standing for Queen, "J" for Jack, etc.
        boolean play = true;
        boolean game = true;
        String playerCard = null;
        String opponentCard = null;
        int playerCardValue;
        int opponentCardValue;
        String noWinner = "Nobody won the game, quit early. \n";
        String playerWins = "You won the game. \n";
        String opponentWins = "The opponent won the game. \n";

        while (play == true) {
            boolean playerWinner = false;
            boolean opponentWinner = false;
            ArrayList<String> fullDeck = null;
            ArrayList<String> playerDeck = new ArrayList<String>();
            ArrayList<String> opponentDeck = new ArrayList<String>();
            ArrayList<String> mid = new ArrayList<String>();
            System.out.println("");
            System.out.print("\u2663");
            System.out.print("\u2666");
            System.out.print("\u2665");
            System.out.print("\u2660");
            System.out.print(" Welcome to the card game War ");
            System.out.print("\u2660");
            System.out.print("\u2665");
            System.out.print("\u2666");
            System.out.print("\u2663");
            System.out.println("\n");

            fullDeck = Cards.createDeck(cards);
            fullDeck = Cards.shuffle(fullDeck);
            Cards.divideDeck(fullDeck, playerDeck, opponentDeck);
            //Calling the divideDeck method to randomize the cards in each deck

            int playerCount = 0;
            int opponentCount = 0;

            while (game == true) {
                System.out.println("You have " + playerDeck.size() + " cards. The opponent has " + opponentDeck.size()
                        + " cards. \n");
                int warCount = 1;
                playerCard = playerDeck.get(0);
                opponentCard = opponentDeck.get(0);
                playerCardValue = Cards.rank(playerCard);
                opponentCardValue = Cards.rank(opponentCard);
                System.out.println("Are you ready? Press enter to continue, or type (q) to quit playing.");
                System.out.println("--------------------------------------------------------------------");
                if (input.nextLine().equals("q")) { //player quits if q is printed
                    game = false;
                    break;
                }
                System.out.println("Your card is >> " + playerCard);
                System.out.println("The opponent's card is >> " + opponentCard + " \n");
                game = Cards.result(playerCardValue, opponentCardValue, playerDeck, opponentDeck, mid, warCount,
                        game, playerCount, opponentCount);
                if (playerCardValue > opponentCardValue) {
                    playerCount++;
                } else if (playerCardValue < opponentCardValue) {
                    opponentCount++;
                } //Counts how many rounds the player and opponent both win

                if (game == false) {
                    if (playerDeck.size() < 2) {
                        opponentWinner = true;
                    } else if (opponentDeck.size() < 2) {
                        playerWinner = true;
                    }
                } else if (playerDeck.size() <= 0) {
                    game = false;
                } else if (opponentDeck.size() <= 0) {
                    game = false;
                }
            }
            if (playerWinner == true) {
                System.out.println("You WIN the game!! Congratulations :)))\n ");
                System.out.println("Thanks for playing! \n");
                Cards.emoji();
                Write.write(String.valueOf(playerCount), String.valueOf(opponentCount), (playerWins));
                //calls the write class & method to write how many games each player has won
                Read.read();
                //calls the read class & method to print the score on the terminal
                Cards.emoji();
            } else if (opponentWinner == true) {

                System.out.println("The opponent wins the game... Bummer :((( \n ");
                System.out.println("Thanks for playing! \n");
                Cards.emoji();
                Write.write(String.valueOf(playerCount), String.valueOf(opponentCount), (opponentWins));
                //calls the write class & method to write how many games each player has won
                Read.read();
                //calls the read class & method to print the score on the terminal
                Cards.emoji();
            }
            System.out.println("Press (q) to quit the game. ");

            if (input.nextLine().equals("q")) {
                System.out.println("\n");
                play = false;
                System.out.println("Thanks for playing! \n");
                Cards.emoji();
                Write.write(String.valueOf(playerCount), String.valueOf(opponentCount), (noWinner));
                //calls the write class & method to write how many games each player has won
                Read.read();
                //calls the read class & method to print the score on the terminal
               Cards.emoji();
            }
        }
    }
}