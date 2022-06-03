/**
 * This is the Deck Class
 * 
  * Contains methods to generate deck [Hearts, Club, Diamonds]
 * Data Structures used:
 * - Linked List [Helps to manipulate Data inside the List]
 * 
 * @author: Shonim
 * @contributor: Owyn
 * @date: 27/05/2022 [DD/MM/YYYY]
 * @modified: 01/05/2022 [DD/MM/YYYY]
 */ 

// Libraries
import java.util.*;

public class Deck {

    // Number of cards in deck = 32
    static int deckSize = 32;
    static List<Card> generateDeck() {
        
        // LinkedList for Deck of Cards
        // Can be used to do actions such as: assign new cards, remove cards, suffle the deck.
        List<Card> deck = new LinkedList<>();

        /**
         * Methods to add list of hearts, clubs, and diamonds to deck
         * @return deck;
         */    
        deck.addAll(generateHearts());
        deck.addAll(generateClubs());
        deck.addAll(generateDiamonds());

        return deck;
    }

    // Generates a list of deck of Hearts with the index value of 1 - 10
    static List<Card> generateHearts() {
        List<Card> hearts = new LinkedList<>();
        for(int i=1; i<=10; i++) {
            hearts.add(new Card("H"+i, i));
        }
        // @return hearts
        return hearts;
    }

     // Generates a list of deck of Clubs with the index value of 5 - 15
    static List<Card> generateClubs() {
        List<Card> clubs = new LinkedList<>();
        for(int i=5; i<=15; i++) {
            clubs.add(new Card("C"+i, i));
        }
        // @return clubs
        return clubs;
    }

    // Generates a list of deck of Diamonds with the index value of 10 - 20
    static List<Card> generateDiamonds() {
        List<Card> diamonds = new LinkedList<>();
        for(int i=10; i<=20; i++) {
            diamonds.add(new Card("D"+i, i));
        }
        // @return diamonds
        return diamonds;
    }

}