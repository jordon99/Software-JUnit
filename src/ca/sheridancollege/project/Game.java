/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 * @author dancye, 2018
 */
public class Game {

    private final String UNO;//the title of the game
    private ArrayList<Player> players;// the players of the game
    ArrayList<Integer> takenCards = new ArrayList<Integer>();
    ArrayList<Integer> cardsForPile = new ArrayList<Integer>();
    ArrayList<Integer> cardsForGamePile = new ArrayList<Integer>();
    boolean gameOver = false;

    public static void main(String[] args) {
        Game Uno = new Game("Uno");
        Card[] handOfCards = new Card[7];
        GroupOfCards UnoCards = new GroupOfCards(108);
        UnoCards.generateDeck();
        Uno.createPile();
        Uno.getStartingCard();
        Uno.setPlayers(Uno.players, 2);
        for (int j = 0; j < Uno.players.size(); j++) {
            Player playeri;
            playeri = Uno.players.get(j);
            Uno.genHand(playeri);
        }
        Uno.createPile();
        for (int k = 0; k < Uno.players.size(); k++) {
            Player play = Uno.players.get(k);
            Uno.choiceMenu(play);
        }
    }

    public Game(String givenName) {
        UNO = givenName;
        players = new ArrayList();
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     * @param numOfPlayers sets amount of players
     */
    public void setPlayers(ArrayList<Player> players, int numOfPlayers) {
        String playerName;
        Card[] hand = new Card[7];
        for (int i = 1; i <= numOfPlayers; i++) {
            playerName = "Player" + i;
            Player play = new Player(playerName, hand);
            players.add(play);
        }
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on
     * your game.
     */
    public static void play() {

    }

    public void choiceMenu(Player player) {
        Card[] handOfCards = new Card[7];
        GroupOfCards UnoCards = new GroupOfCards(108);
        UnoCards.generateDeck();
        Card[] playerHand = player.getPlayerHand();     
        int topCard = cardsForGamePile.get(0);
        System.out.println("-----------------------------");
        System.out.println(player.getPlayerID() + " Turn");
        System.out.println("The top card is " + UnoCards.cards[topCard]);
        System.out.println("Your Cards:");
        for (int i = 0; i < playerHand.length; i++) {
            System.out.println("Card " + String.valueOf(i + 1) + " " + playerHand[i]);
        }
        System.out.println("Enter -5 to quit");
        System.out.print("Enter Your Choice: ");
        Scanner scan = new Scanner(System.in);
        int userChoice = scan.nextInt();
        switch (userChoice) {
            case 1:
                if(canPlace(UnoCards.cards[topCard], playerHand[0]) == true){
                addToGamePile(playerHand[0]);
                }else{
                    System.out.println("invalid attempt turn skipped");                
                }
                break;
            case 2:
                if(canPlace(UnoCards.cards[topCard], playerHand[1]) == true){
                addToGamePile(playerHand[1]);
                }else{
                    System.out.println("invalid attempt turn skipped");                
                }
                break;
            case 3:
                if(canPlace(UnoCards.cards[topCard], playerHand[2]) == true){
                addToGamePile(playerHand[2]);
                }else{
                    System.out.println("invalid attempt turn skipped");                
                }
                break;
            case 4:
                if(canPlace(UnoCards.cards[topCard], playerHand[3]) == true){
                addToGamePile(playerHand[3]);
                }else{
                    System.out.println("invalid attempt turn skipped");                
                }
                break;
            case 5:
               if(canPlace(UnoCards.cards[topCard], playerHand[4]) == true){
                addToGamePile(playerHand[4]);
                }else{
                    System.out.println("invalid attempt turn skipped");                
                }
                break;
            case 6:
                if(canPlace(UnoCards.cards[topCard], playerHand[5]) == true){
                addToGamePile(playerHand[5]);
                }else{
                    System.out.println("invalid attempt turn skipped");                
                }
                break;
            case 7:
               if(canPlace(UnoCards.cards[topCard], playerHand[6]) == true){
                addToGamePile(playerHand[6]);
                }else{
                    System.out.println("invalid attempt turn skipped");                
                }
                break;
            case -5:
                gameOver = true;
                break;
        }

    }

    public void genHand(Player player) {
        Card[] handOfCards = new Card[7];
        GroupOfCards UnoCards = new GroupOfCards(108);
        UnoCards.generateDeck();
        Random rgen = new Random();
        int dealedCard;
        int i = 0;
        int handSize = 0;
        while (true) {
            dealedCard = rgen.nextInt(108);
            dealedCard += 1;

            if (takenCards.isEmpty()) {
                takenCards.add(dealedCard);
                handOfCards[i] = UnoCards.cards[dealedCard];
                handSize++;
            } else {

                for (int j = 0; j < takenCards.size(); j++) {
                    if (dealedCard == takenCards.get(j)) {
                        break;
                    } else {
                        handOfCards[i] = UnoCards.cards[dealedCard];
                        takenCards.add(dealedCard);
                        handSize++;
                        break;
                    }

                }
            }
            if (handSize > 6) {
                player.setPlayerHand(handOfCards);
                break;
            }
            i++;
        }

    }

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public static void declareWinner() {

    }

    public static void startGame() {

    }

    public void createPile() {
        for (int i = 0; i < 108; i++) {
            cardsForPile.add(i);
        }
        cardsForPile.removeAll(takenCards);
        Collections.shuffle(cardsForPile);
    }

    public static void discardPile() {

    }

    public Card getStartingCard() {
        Card[] handOfCards = new Card[7];
        GroupOfCards UnoCards = new GroupOfCards(108);
        UnoCards.generateDeck();
        int top = cardsForPile.get(0);
        cardsForGamePile.add(top);
        Card topCard = UnoCards.cards[top];
        cardsForPile.remove(0);
        return topCard;
    }

    public Card getCardFromPile() {
        Card[] handOfCards = new Card[7];
        GroupOfCards UnoCards = new GroupOfCards(108);
        UnoCards.generateDeck();
        int top = cardsForPile.get(0);
        Card topCard = UnoCards.cards[top];
        cardsForPile.remove(0);
        return topCard;
    }

    public static void createAction() {

    }

    public void addToGamePile(Card playedCard) {
        Card[] handOfCards = new Card[7];
        GroupOfCards UnoCards = new GroupOfCards(108);
        UnoCards.generateDeck();
        Card checkedCard;
        for (int i = 0; i < UnoCards.cards.length; i++) {
            checkedCard = UnoCards.cards[i];
            if (playedCard.getColour().equals(checkedCard.getColour())) {
                if (playedCard.getValue().equals(checkedCard.getValue())) {
                    cardsForGamePile.add(i);
                    break;
                }
            }
        }
        Collections.reverse(cardsForGamePile);
    }

    public boolean canPlace(Card cardToPlace, Card topCard) {
        if (cardToPlace.getColour().equals(topCard.getColour())) {
            return true;
        } else {
            return false;
        }
    }

}//end class
