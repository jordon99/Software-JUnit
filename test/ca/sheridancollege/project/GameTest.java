/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alecg
 */
public class GameTest {

    /**
     * Test of setPlayers method, of class Game.
     */
    @Test
    public void testSetPlayers() {
        GroupOfCards UnoCards = new GroupOfCards(108);
        UnoCards.generateDeck();
        Game Uno = new Game("UNO");
        System.out.println("setPlayers");
        ArrayList<Player> players = new ArrayList<>();
        int numOfPlayers = 2;
        Uno.setPlayers(players, numOfPlayers);
        assertEquals(players.size(), numOfPlayers);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    /**
     * Test of addToGamePile method, of class Game.
     */
    @Test
    public void testAddToGamePile() {
        GroupOfCards UnoCards = new GroupOfCards(108);
        UnoCards.generateDeck();
        Game Uno = new Game("UNO");
        System.out.println("addToGamePile");
        Card playedCard = UnoCards.cards[12];
        Uno.addToGamePile(playedCard);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of canPlace method, of class Game.
     */
    @Test
    public void testCanPlace() {
        GroupOfCards UnoCards = new GroupOfCards(108);
        UnoCards.generateDeck();
        Game Uno = new Game("UNO");
        System.out.println("canPlace");
        Card cardToPlace = UnoCards.cards[12];
        Card topCard = UnoCards.cards[13];
        boolean expResult = true;
        boolean result = Uno.canPlace(cardToPlace, topCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail
    }
    
}
