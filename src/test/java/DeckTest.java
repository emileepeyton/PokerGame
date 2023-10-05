import com.prac0.Card;
import com.prac0.Deck;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
class DeckTest {

    @Test
    void createDeck() {
        Deck test = new Deck();
        ArrayList<Card> accurate = new ArrayList<Card>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9","10", "J", "K", "Q", "A"};

        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(suit, rank);
                accurate.add(card);
            }
        }

        for (int i = 0; i < accurate.size(); i++){
            assertEquals(accurate.get(i).getRank(), test.getDeck().get(i).getRank());
            assertEquals(accurate.get(i).getSuit(), test.getDeck().get(i).getSuit());
        }
    }
}