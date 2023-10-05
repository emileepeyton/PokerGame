package com.prac0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

public class Hand {
    private ArrayList<Card> cards;

    public Hand(ArrayList<Card> hand) {
        this.setCards(hand);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public String EvaluateHand() {
        boolean onePair = false, twoPair = false, threeOfaKind = false, straight = false, flush = false, fullHouse = false,fourOfaKind = false, straightFlush = false;
        onePair = OnePair(this.getCards());
        twoPair = TwoPair(this.getCards());
        threeOfaKind = ThreeOfAKind(this.getCards());
        straight = Straight(this.getCards());
        flush = Flush(this.getCards());
        fullHouse = FullHouse(this.getCards());
        fourOfaKind = FourOfAKind(this.getCards());
        straightFlush = StraightFlush(this.getCards());
        // determining the rank from highest ranked to least.
        if (straightFlush) {
            return "Your hand is a straight flush.";
        } else if (fourOfaKind) {
            return "You have four of a kind";
        } else if (fullHouse) {
            return "You have a full house";
        } else if (flush) {
            return "You have a flush";
        } else if (straight) {
            return "You have a straight";
        } else if (threeOfaKind) {
            return "You have three of a kind";
        } else if (twoPair) {
            return "You have two pairs";
        } else if (onePair) {
            return "You have one pair";
        } else return "You only have a high card, your highest card is: " + HighCards(this.getCards()).getRank() + " of " + HighCards(this.getCards()).getSuit();
    }

    public boolean OnePair(ArrayList<Card> check) {
        Map<String, Integer> rankCount = new HashMap<>();
        for (Card card : check) {
            String rank = card.getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : rankCount.entrySet()) {
            if (entry.getValue() == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean TwoPair(ArrayList<Card> check) {
        Map<String, Integer> rankCount = new HashMap<>();
        for (Card card : check) {
            String rank = card.getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        int pairCount = 0;
        for (Map.Entry<String, Integer> entry : rankCount.entrySet()) {
            if (entry.getValue() == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    public boolean ThreeOfAKind(ArrayList<Card> check) {
        Map<String, Integer> rankCount = new HashMap<>();

        for (Card card : check) {
            String rank = card.getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : rankCount.entrySet()) {
            if (entry.getValue() == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean Straight(ArrayList<Card> check) {
        Collections.sort(check, Comparator.comparing(card -> getRankValue(card.getRank())));
        for (int i = 0; i < check.size() - 1; i++) {
            int rank1Value = getRankValue(check.get(i).getRank());
            int rank2Value = getRankValue(check.get(i + 1).getRank());
            if (rank1Value + 1 != rank2Value) {
                return false;
            }
        }
        return true;
    }

    public boolean Flush(ArrayList<Card> check) {
        if (check.size() != 5) {
            return false;
        }
        Set<String> uniqueSuits = new HashSet<>();
        for (Card card : check) {
            uniqueSuits.add(card.getSuit());
        }
        return uniqueSuits.size() == 1;
    }

    public boolean FullHouse(ArrayList<Card> check) {
        if (ThreeOfAKind(check) && OnePair(check) ) {
            return true;
        } else return false;
    }

    public boolean FourOfAKind(ArrayList<Card> check) {
        if (check.size() != 5) {
            return false;
        }
        Map<String, Integer> rankCount = new HashMap<>();
        for (Card card : check) {
            String rank = card.getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : rankCount.entrySet()) {
            if (entry.getValue() == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean StraightFlush(ArrayList<Card> check) {
        return (Straight(check) && Flush(check));
    }

    public Card HighCards(ArrayList<Card> check) {
        if (check.isEmpty()) {
            return null;
        }
        Card highestCard = check.get(0);
        for (Card card : check) {
            if (getRankValue(card.getRank()) > getRankValue(highestCard.getRank())) {
                highestCard = card;
            }
        }
        return highestCard;
    }

    public int getRankValue(String rank) {
        switch (rank) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return 0; // Invalid rank
        }
    }
}
