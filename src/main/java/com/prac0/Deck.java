package com.prac0;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        createDeck();
    }

    public void createDeck() {
        deck = new ArrayList<Card>();

        //String[] suits = {"♥", "♦", "♠", "♣"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9","10", "J", "K", "Q", "A"};

        for (int i = 0; i < suits.length; i++){ // creating the full deck of cards
            for (int k = 0; k < ranks.length; k++) {
                Card card = new Card(suits[i], ranks[k]);
                deck.add(card);
            }
        }
        //this.shuffleDeck();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void shuffleDeck() {
        ArrayList<Card> shuffled = new ArrayList<>(this.getDeck());
        Random random = new Random();

        for (int i = shuffled.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = shuffled.get(i);
            shuffled.set(i, shuffled.get(j));
            shuffled.set(j, temp);
        }
        this.deck = shuffled;
    }
}
