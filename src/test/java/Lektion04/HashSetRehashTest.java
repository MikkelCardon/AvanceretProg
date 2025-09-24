package Lektion04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashSetRehashTest {

    private HashSetChaining set;

    @BeforeEach
    void setUp() {
        set = new HashSetChaining(4); // small table to trigger rehash quickly
    }

    @Test
    void testRehashIsTriggered() {
        int initialBuckets = set.bucketSize();

        // Fill just enough elements to exceed load factor 0.75
        // For buckets = 4, threshold = 3 (4 * 0.75 = 3.0)
        set.add(1);
        set.add(2);
        set.add(3);

        // This one should trigger rehash
        set.add(4);

        int newBuckets = set.bucketSize();
        assertEquals(initialBuckets * 2, newBuckets, "Bucket count should double after rehash");

        // Ensure all elements are still present after rehash
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertTrue(set.contains(3));
        assertTrue(set.contains(4));
    }

    @Test
    void testNoRehashIfLoadFactorBelowThreshold() {
        int initialBuckets = set.bucketSize();

        set.add(10);
        set.add(20);

        assertEquals(initialBuckets, set.bucketSize(),
                "Bucket count should remain same if load factor <= 0.75");
    }
}
