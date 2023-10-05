import com.prac0.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    @Test
    void getRank() {
        Card test = new Card("Hearts", "4");
        assertEquals("Hearts", test.getSuit());
    }

    @Test
    void getSuit() {
        Card test = new Card("Hearts", "4");
        assertEquals("Hearts", test.getSuit());
    }
}