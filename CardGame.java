/**
 * This is the CardGame Class [Main Class]
 * 
 * Executes the game ~
 * - startGame();
 * - initializeGame();
 * - gamerun();
 * - gamePlay();
 * - gameOver();
 * - pickCard();
 * - drawBackCards();
 * - dashBoard();
 * 
 * NOTE: Each Method documentation are written on top its respective code
 * 
 * @author: Shonim
 * @contributor: Owyn
 * @date: 27/05/2022 [DD/MM/YYYY]
 * @modified: 01/05/2022 [DD/MM/YYYY]
 */ 

// Libraries
import java.util.*;

public class CardGame {
    
    // Value of round is set to 1 (will increase as game progresses)
    private static int round = 1;
    
    // Player A and Player B, the game surrounds the two players
    private static Player A;
    private static Player B;
    
    // Generates List: Deck of Cards for Gamplay
    private static List<Card> deck;
   
    // deckTop starts with 10, as each player has 5 cards in Hand
    // When deckTop reaches 32, Game is Over   
    private static int deckTop = 10;

    /**
     * MAIN Class Statement 
     * - Executes the game using method: startGame();
     */   
    public static void main(String[] args) {
        startGame();
    }
    
    /**
     * METHOD: startGame();
     */
    private static void startGame() {
        
        // initializeGame Method
        initializeGame();
        
        while (true) {
            // base condition
            // if Player A AND Player B has less than 5 Cards in hand, Game is Over.
            if (A.getCardsInHand().size() < 5 || B.getCardsInHand().size() < 5) {
                gameOver();
                return;
            }
            // gameRun Method
            gameRun();
        }
    }

    /**
     * METHOD: gameOver();
     * 
     * Determines the winner based on which player has more score.
     * Displays the final score at the end of the game
     * 
     */
    private static void gameOver() {
        
        System.out.println();
        System.out.println("====================");
        System.out.println("GAME OVER!!");
        System.out.println("Score of Each Player: ");
        System.out.println(A.getName()+": "+A.getScore());
        System.out.println(B.getName()+": "+B.getScore());
        
        // If Player A Score and Player B score is same, game is tie.
        if(A.getScore() == B.getScore()) {
            System.out.println("Game is tie");
        }
        
        // If Player A Score has more score than Player B, Player A wins.
        else if(A.getScore() > B.getScore()) {
            System.out.println("winner is "+A.getName());
        }
        
        // Else Player B wins.
        else {
            System.out.println("winner is "+B.getName());
        }
    }
 
    /**
     * METHOD: initializeGame();
     * 
     * Used for:
     * - shuffling the deck
     * - assigning new cards to each player
     */
    private static void initializeGame() {
        
        // Generates Deck and Shuffles the Deck before Assigning Cards
        // NOTE: Deck shuffles only ONCE throughout the game
        deck = Deck.generateDeck();
        Collections.shuffle(deck);
        
        // 2 Player Objects ~ 
        // Player Name: A and B 
        // LinkedList to store the no. of cards in hand
        A = new Player("A", new LinkedList<>());
        B = new Player("B", new LinkedList<>());
        
        // For loop to assigned 5 cards to Player A and B
        for (int i = 0; i < 5; i++) {
            A.getCardsInHand().add(deck.get(i));
            B.getCardsInHand().add(deck.get(i + 5));
        }
    }

    // Turn is set to false, 
    // As it allows to implent the if else statement of player turns in the round
    static boolean turn = false;
   
    /**
     * METHOD: gameRun();
     * 
     * Used for: 
     * - give turns to Player A and Player
     * - draw new cards from the deck
     */
    private static void gameRun() {
        
        // turn is set to !turn, so turn is true, meaning it's Player A's turn
        turn = !turn;
        if (turn) {
            gamePlay(A, B);

        // Else turn is false, which means it's Player B's turn  
        } else {
            gamePlay(B, A);
        }
        
        // drawBackCards method (assigns new cards from the Deck)
        drawBackCards();
    }

    /**
     * METHOD: gamePlay();
     * 
     * Main Condition: 
     * If player B does not have two cards whose value adds to the value of player A’s card,
     * - then player B gets a point. Player’s A card is discarded.
     * 
     * Depending on who gets the point, winner of the round is decided.
     * 
     * @param p1, p2
     */
    private static void gamePlay(Player p1, Player p2) {
        
        // Player 1 / Player A/B picks a card
        Card chooseCard = pickCard(p1);
        for (Card card1 : p2.getCardsInHand()) {
            for (Card card2 : p2.getCardsInHand()) {
                
                // Ignores if Player A and Player B has the same Card
                if (!card1.getCardName().equalsIgnoreCase(card2.getCardName())) {
                    int sum = card1.getCardValue() + card2.getCardValue();
                    
                    // If sum of the two cards (in Player 2's hand) is equal to the card Player 1 picked,
                    // - Player 1 will gain 1 point
                    // - The card player 1 picked will be discareded
                    // - The pair of cards will be discarded from Player 2's hand
                    if (sum == chooseCard.getCardValue()) {
                        p1.setScore(p1.getScore() + 1);
                        p1.removeCard(chooseCard);
                        p2.removeCard(card1);
                        p2.removeCard(card2);
                        
                        // Displays if Pair is found ~
                        // - the two cards of the pair will be displayed
                        // - winner of the round will be player 1
                        System.out.println("pair found!("+card1.getCardName()+" "+card2.getCardName()+") winner of this round is: "+p1.getName());
                        return;
                    }
                }
            }
        }
        
        // Displays if a pair is not found
        // Player 2 will gain a point
        // Player 1's chosen card will be removed
        // Winner of the round will be player 2
        System.out.println("pair not found! winner of this round is: "+p2.getName());
        p2.setScore(p2.getScore() + 1);
        p1.removeCard(chooseCard);
    }

    /**
     * METHOD: pickCard();
     * 
     * Lets the user pick which card to pick from the assigned cards
     * NOTE: Chosen card will be checked to see if it matches with the pair of cards of the opponent
     * @param player
     */
    private static Card pickCard(Player player) {
        
        // dashBoard method to outline the menu in a clean manner
        dashBoard();
        System.out.println(player.getName() + "'s turn");
        Scanner input = new Scanner(System.in);
        
        // Displays the current 5 cards in Player's hand
        for (int i = 0; i < player.getCardsInHand().size(); i++) {
            System.out.print(player.getCardsInHand().get(i).getCardName() + " ");
        }
        
        // User picks a card index value wise
        System.out.print("Choose a card (0-based index): ");
        return player.getCardsInHand().get(input.nextInt());
    }

    /**
     * METHOD: drawBackCards();
     * 
     * Used to assign new cards from the deck to the players if the condition is met
     */
    private static void drawBackCards() {
        
        // Condition:
        // - When Player A has less than 5 cards,
        // - and deckTop is less than deckSize (32),
        // - Player A will be assigned new cards
        // deckTop will increase by the number of cards that has been drawn from the deck 
        while (A.getCardsInHand().size() < 5 && deckTop < Deck.deckSize) {
            A.getCardsInHand().add(deck.get(deckTop++));
        }
        
        // SIMILARLY,
        // Condition:
        // - When Player B has less than 5 cards,
        // - and deckTop is less than deckSize (32),
        // - Player A will be assigned new cards
        // deckTop will increase by the number of cards that has been drawn from the deck 
        while (B.getCardsInHand().size() < 5 && deckTop < Deck.deckSize) {
            B.getCardsInHand().add(deck.get(deckTop++));
        }
        
        // NOTE: when deckTop reaches 32 = size of the total cards in the deck,
        // - no more cards will be assigned, and game will be over.
    }

    /**
     * METHOD: dashBoard();
     * 
     * Used for:
     * - display scores, 
     * - winner of the round
     * 
     * - if a pair (sum of card values) is found or not, 
     * - that matches with the value of opponent's Card Value
     */
    private static void dashBoard() {
        
        // Menu Outline - displays the no. of round and value of deckTop
        System.out.println("\n########################Dashboard###############################");
        System.out.println("round: " + round++);
        System.out.println("deck top: " + deckTop);
        
        // Displays the current cards in Player A's hand, and score
        System.out.println("=================Player "+A.getName()+"'s Info==================");
        System.out.println("Score: " + A.getScore());
        for (int i = 0; i < A.getCardsInHand().size(); i++) {
            System.out.print(A.getCardsInHand().get(i).getCardName() + " ");
        }
        
        // Displays the current cards in Player B's hand, and score
        System.out.println("\n=================Player "+B.getName()+"'s Info==================");
        System.out.println("Score: " + B.getScore());
        for (int i = 0; i < B.getCardsInHand().size(); i++) {
            System.out.print(B.getCardsInHand().get(i).getCardName() + " ");
        }
        
        System.out.println("\n################################################################\n");
    }
}