package Lektion04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashSetChainingTest {

    private HashSetChaining set;

    @BeforeEach
    void setUp() {
        set = new HashSetChaining(10);
        set.add("A");
        set.add("B");
        set.add("C");
    }

    @Test
    void testRemoveExistingElement() {
        assertTrue(set.remove("B"), "Removing existing element should return true");
        assertFalse(set.contains("B"), "Removed element should not be in the set");
        assertEquals(2, set.size(), "Size should decrease after removal");
    }

    @Test
    void testRemoveNonExistentElement() {
        assertFalse(set.remove("Z"), "Removing non-existent element should return false");
        assertEquals(3, set.size(), "Size should stay the same");
    }

    @Test
    void testRemoveHeadOfChain() {
        // Force collision (e.g., by controlling hash function in your implementation)
        set.add("AA"); // Assume "A" and "AA" hash to the same bucket
        assertTrue(set.contains("A"));
        assertTrue(set.contains("AA"));

        assertTrue(set.remove("A"), "Should remove head of chain");
        assertFalse(set.contains("A"), "Head should be gone");
        assertTrue(set.contains("AA"), "Other element in chain should still exist");
    }

    @Test
    void testRemoveMiddleOfChain() {
        // Assume "A", "AA", "AAA" hash into same bucket
        set.add("AA");
        set.add("AAA");

        assertTrue(set.remove("AA"), "Should remove middle of chain");
        assertFalse(set.contains("AA"));
        assertTrue(set.contains("A"));
        assertTrue(set.contains("AAA"));
    }

    @Test
    void testRemoveFromEmptySet() {
        HashSetChaining emptySet = new HashSetChaining(10);
        assertFalse(emptySet.remove("X"), "Removing from empty set should return false");
        assertEquals(0, emptySet.size());
    }


}
