/**
 * This is the Card Class
 * 
 * Contains constructor, and private instances, and methods:
 * - stores name of Card, Value of Card [For e.g H1, C7, D9 etc.]
 * 
 * @author: Shonim
 * @contributor: Owyn
 * @date: 27/05/2022 [DD/MM/YYYY]
 * @modified: 01/05/2022 [DD/MM/YYYY]
 */ 

// 
public class Card {
    private String cardName;
    private int cardValue;

     /**
     * Constructor to store Card information 
     * 
     * @param cardName Name of Card
     * @param cardValue Value of Card
     */
    public Card(String cardName, int cardValue) {
        this.cardName = cardName;
        this.cardValue = cardValue;
    }

    /**
     * Method String getCardName
     * 
     * @return cardName
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Method setCardName
     * 
     * @param cardName
     * @return void
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * Method integer getCardValue
     * 
     * @return cardValue
     */
    public int getCardValue() {
        return cardValue;
    }

    /**
     * Method setCardName
     * 
     * @param cardValue
     * @return void
     */
    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }
}