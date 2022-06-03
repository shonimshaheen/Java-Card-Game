/**
 * This is the Player Class
 * 
 * Contains constructor, and private instances, and methods:
 * - stores player name
 * - stores player the number of cards player have in hind
 * - stores score of the player
 * 
 * Data Structures used:
 * - List Interface
 * 
 * @author: Shonim
 * @contributor: Owyn
 * @date: 27/05/2022 [DD/MM/YYYY]
 * @modified: 01/05/2022 [DD/MM/YYYY]
 */ 

// Libraries
import java.util.List;

public class Player {
    
    // Private Instances
    private String name;
    private int score;
    
    // List for the number of cards in hand in each player
    private List<Card> cardsInHand;

    /**
     * Constructor to Player information 
     * - given the name of the player, cards in hand of each player
     * 
     * @param name Name of Player
     * @param cardsInHand No. of Cards in Player's hand
     */
    public Player(String name, List<Card> cardsInHand) {
        this.name = name;
        this.cardsInHand = cardsInHand;
    }

    /**
     * Method getName
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method setName
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getScore
     * 
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Method setScore
     * 
     * @param score
     * @return void
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    /**
     * Method setCardsInHand
     * 
     * @return cardsInHand
     */
    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    /**
     * Method setCardsinHand
     * 
     * @param cardsInHand
     * @return void
     */
    public void setCardsInHand(List<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    /**
     * Method removeCard
     * 
     * @param cardRemove
     * @return void
     */
    public void removeCard(Card cardRemove) {
        this.getCardsInHand()
                .removeIf(card -> card.equals(cardRemove));
    }
}