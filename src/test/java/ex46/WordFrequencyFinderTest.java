package ex46;

import ex45.WordFinder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordFrequencyFinderTest {

    @Test
    void replaceSpecific() {
        assertEquals("eight seven and five", WordFrequencyFinder.replaceSpecific("eight and seven and five", "and", 6));
    }

    @Test
    void findString() {
        assertEquals(9, WordFrequencyFinder.findString("Where is that word that", "that"));
        assertEquals(28, WordFrequencyFinder.findString("this gate was made only for you. I am now going to shut it.", "you"));
    }

}