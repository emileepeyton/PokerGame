package com.prac0;
import java.util.ArrayList;

public class Game {
    private Deck shuffledDeck;

    public Game(Deck deck) {
        deck.shuffleDeck();
        this.shuffledDeck = deck;
        DealHands();
    }

    public void DealHands() {
        ArrayList<Card> handTemp1 = new ArrayList<Card>();
        if (shuffledDeck != null) {
            for (int t = 0; t < 5; t++) {
                handTemp1.add(shuffledDeck.getDeck().remove(0));
            }
        }
        Hand playerOne = new Hand(handTemp1);

       System.out.println("Your Hand: ");
        for (int k = 0; k < 5; k++){
            System.out.println(playerOne.getCards().get(k).getRank() + " of " + playerOne.getCards().get(k).getSuit());
        }
        System.out.println(playerOne.EvaluateHand());
    }
}
