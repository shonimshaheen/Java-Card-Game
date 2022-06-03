# Java-Card-Game
A Card Game coded in Java that uses data structures of high degree of skill.


1) You start with a deck of 30 edit May 28: 32 cards. These are as follows:
- In suit Hearts (H): there are cards numbered 1 to 10
- In suit Clubs (C): there are cards numbered 5 to 15
- In suit Diamonds (D): there are cards numbered 10 to 20

2) There are two players. They are both human players.


3) Each player, A and B, has a hand of 5 cards to start. The hand of cards is drawn from the deck.


4) The player A starts. Player A chooses a card in their hand. 


5) If player B has two cards whose numeric values sum to the numeric value on player A’s card, player A gets one point. This is automatically decided. All three cards are discarded. Pick any match. For instance if player B’s hand is [5H, 5C, 6H, 10C, 10H] and player A picks the card 11C, then either the pairs [5H, 6H] or [5C, 6H] can be discarded with player A’s card.


6) If player B does not have two cards whose value adds to the value of player A’s card, then player B gets a point. Player’s A card is discarded.


7) Both players draw back to 5 cards from the deck.


8) Repeat steps 4 to 9, alternating which player picks a card from their hand.


9) The game ends as soon as player A or player B can not draw back to 5 cards in their hand in step 7. 


10) The winner is the player with the most points. A tie is possible.
