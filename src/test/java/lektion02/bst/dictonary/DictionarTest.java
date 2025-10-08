package lektion02.bst.dictonary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DictionarTest {
    Dictionary<Integer, String> dictionary;
   

    @BeforeEach
    public void setUp() throws Exception {
        dictionary = new DictionaryBST<>();
        dictionary.put(8, "H");
        dictionary.put(4, "D");
        dictionary.put(12, "L");
        dictionary.put(2, "B");
        dictionary.put(6, "F");
        dictionary.put(10, "J");
        dictionary.put(14, "N");
        dictionary.put(1, "A");
        dictionary.put(3, "C");
        dictionary.put(5, "E");
        dictionary.put(7, "G");
        dictionary.put(9, "I");
        dictionary.put(11, "K");
        dictionary.put(13, "M");
        dictionary.put(15, "O");
    }

    @Test
    void sizeTest() {
        assertEquals(15, dictionary.size());
    }

    @Test
    void sizeOnEmptyDictonary() {
        Dictionary emptyDictonary = new DictionaryBST();

        assertEquals(0, emptyDictonary.size());
    }

    @Test
    void IsEmpty() {
        assertFalse(dictionary.isEmpty());
    }

    @Test
    void isEmptyOnEmptyDictonary() {
        Dictionary emptyDictonary = new DictionaryBST();

        assertTrue(emptyDictonary.isEmpty());
    }

    @Test
    void getTest() {
        assertEquals("H", dictionary.get(8));
        assertEquals("D", dictionary.get(4));
        assertEquals("K", dictionary.get(11));

        assertNull(dictionary.get(20));
    }


    @Test
    void putTest() {
        Dictionary<Integer, String> dictionaryBST = new DictionaryBST();
        dictionaryBST.put(1, "A");
        dictionaryBST.put(2, "B");

        assertEquals("A", dictionaryBST.get(1));
        assertEquals("B", dictionaryBST.get(2));
        assertEquals(2, dictionaryBST.size());
    }
}
