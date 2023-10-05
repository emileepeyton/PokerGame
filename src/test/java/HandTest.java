import com.prac0.Card;
import com.prac0.Hand;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandTest {
    @Test
    void getHandTest() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card("Hearts", "10" ));
        hand.add(new Card("Clubs", "J" ));
        hand.add(new Card("Diamonds", "Q" ));
        hand.add(new Card("Spades", "K" ));
        hand.add(new Card("Hearts", "A" ));
        Hand testHand = new Hand(hand);
        assertEquals("10 of Hearts", testHand.getCards().get(0).getRank() + " of " + testHand.getCards().get(0).getSuit());
        assertEquals("J of Clubs", testHand.getCards().get(1).getRank() + " of " + testHand.getCards().get(1).getSuit());
        assertEquals("Q of Diamonds", testHand.getCards().get(2).getRank() + " of " + testHand.getCards().get(2).getSuit());
        assertEquals("K of Spades", testHand.getCards().get(3).getRank() + " of " + testHand.getCards().get(3).getSuit());
        assertEquals("A of Hearts", testHand.getCards().get(4).getRank() + " of " + testHand.getCards().get(4).getSuit());
    }

    @Test //testing whether it can identify a hand with one pair.
    void OnePairEvaluateHand() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card( "Hearts", "A"));
        hand.add(new Card( "Clubs", "K"));
        hand.add(new Card( "Diamonds", "A"));
        hand.add(new Card( "Spades", "Q"));
        hand.add(new Card( "Hearts", "J"));
        Hand testHand = new Hand(hand);
        assertEquals("You have one pair", testHand.EvaluateHand());
    }

    @Test //testing whether it can identify a hand with two pairs.
    void TwoPairEvaluateHand() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card("Hearts","A"));
        hand.add(new Card("Clubs", "K"));
        hand.add(new Card("Diamonds", "A"));
        hand.add(new Card ("Spades","K"));
        hand.add(new Card( "Hearts", "J"));
        Hand test = new Hand(hand);
        assertEquals("You have two pairs", test.EvaluateHand());
    }

    @Test //testing whether it can identify a hand with three of a kind.
    void ThreeOfaKindEvaluateHand() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card( "Hearts", "A"));
        hand.add(new Card( "Clubs", "K"));
        hand.add(new Card( "Diamonds", "A"));
        hand.add(new Card( "Spades", "A"));
        hand.add(new Card( "Hearts", "J"));
        Hand testHand = new Hand(hand);
        assertEquals("You have three of a kind", testHand.EvaluateHand());
    }

    @Test //testing whether it can identify a hand with a straight.
    void StraightEvaluateHand() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card("Hearts", "10" ));
        hand.add(new Card("Clubs", "J" ));
        hand.add(new Card("Diamonds", "Q" ));
        hand.add(new Card("Spades", "K" ));
        hand.add(new Card("Hearts", "A" ));
        Hand testHand = new Hand(hand);
        assertEquals("You have a straight", testHand.EvaluateHand());
    }

    @Test //testing whether it can identify a hand with a flush.
    void FlushEvaluateHand() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card("Hearts", "2"));
        hand.add(new Card("Hearts", "3"));
        hand.add(new Card("Hearts", "10"));
        hand.add(new Card("Hearts", "5" ));
        hand.add(new Card("Hearts", "6" ));
        Hand testHand = new Hand(hand);
        assertEquals("You have a flush", testHand.EvaluateHand());
    }

    @Test //testing whether it can identify a hand with a full house.
    void FullHouseEvaluateHand() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card("Hearts","2" ));
        hand.add(new Card("Clubs","2"));
        hand.add(new Card("Diamonds","2"));
        hand.add(new Card("Spades","3"));
        hand.add(new Card("Hearts","3"));
        Hand testHand = new Hand(hand);
        assertEquals("You have a full house", testHand.EvaluateHand());
    }

    @Test //testing whether it can identify a hand with four of a kind.
    void FourOfaKindEvaluateHand() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card("Hearts", "A" ));
        hand.add(new Card("Clubs", "A"));
        hand.add(new Card("Diamonds", "A"));
        hand.add(new Card("Spades", "A"));
        hand.add(new Card("Hearts", "J"));
        Hand testHand = new Hand(hand);
        assertEquals("You have four of a kind", testHand.EvaluateHand());
    }

    @Test //testing whether it can identify a hand with a straight flush.
    void StraightFlushEvaluateHand() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card("Hearts", "2"));
        hand.add(new Card("Hearts", "3"));
        hand.add(new Card("Hearts", "4"));
        hand.add(new Card("Hearts", "5"));
        hand.add(new Card("Hearts", "6"));
        Hand testHand = new Hand(hand);
        assertEquals("Your hand is a straight flush.", testHand.EvaluateHand());
    }

    @Test //testing whether it can identify a hand with only a high card.
    void HighCardEvaluateHand() {
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(new Card("Hearts","2"));
        hand.add(new Card("Clubs","3"));
        hand.add(new Card("Diamonds","7"));
        hand.add(new Card("Spades","A"));
        hand.add(new Card("Hearts","J"));
        Hand testHand = new Hand(hand);
        assertEquals("You only have a high card, your highest card is: A of Spades", testHand.EvaluateHand());
    }
}