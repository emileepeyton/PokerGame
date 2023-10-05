package com.prac0;

public class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        setRank(rank);
        setSuit(suit);
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
