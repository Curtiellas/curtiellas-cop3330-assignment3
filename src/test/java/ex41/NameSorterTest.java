package ex41;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameSorterTest {

    @Test
    //tests whether the method removes the comma and returns the separate names in a String array
    void extractNames() {
        assertArrayEquals(new String[]{"Malanga", "Pussy"}, NameSorter.extractNames("Malanga, Pussy"));
        assertArrayEquals(new String[]{"Soprano", "Tony"}, NameSorter.extractNames("Soprano, Tony"));
    }

}