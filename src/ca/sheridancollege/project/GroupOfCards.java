/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 */
public class GroupOfCards {

    private int deckSize = 108;
    public Card[] cards = new Card[deckSize];
    //The group of cards, stored in an ArrayList
    //private ArrayList <Card> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int givenSize) {
        size = givenSize;
    }

    public Card[] ShuffleCards(Card[] array) {
        Random rgen = new Random();  // Random number generator			

        for (int i = 0; i < array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            Card temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }

    /**
     * Add comments during class to explain what this method does.
     */
    public void generateDeck() {
        int countCards = 0;
        while (countCards < 108) {
            try{
            for (Card.Colour s : Card.Colour.values()) {
                for (Card.Value v : Card.Value.values()) {
                    cards[countCards] = (new Card(s, v));
                    countCards++;
                }
            }
            }catch(Exception ex){
                
            }
        }
    }

}//end class
