package ex45;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordFinderTest {

    @Test
    void replaceAll() {
        assertEquals("one use two use three", WordFinder.replaceAll("one and two and three", "and"));
    }

    @Test
    void replaceSpecific() {
        assertEquals("one use two and three", WordFinder.replaceSpecific("one and two and three", "and", 4));
    }

    @Test
    void findString() {
        assertEquals(2, WordFinder.findString("This is a sentence", "is"));
        assertEquals(12, WordFinder.findString("Before the law stands a doorkeeper.", "a"));
    }
}