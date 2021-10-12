package ex42;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParsingDataFileTest {

    @Test
    void extractNames() {
        String[] result = {"Some", "Dude", "541357"};
        String line = "Some,Dude,541357";
        assertArrayEquals(result, ParsingDataFile.extractNames(line));
    }

    @Test
    void findCommas() {
        int[] result = {5, 11};
        String line = "Jones,Chris,34500";
        assertArrayEquals(result, ParsingDataFile.findCommas(line));
    }
}