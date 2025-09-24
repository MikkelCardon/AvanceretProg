package Lektion04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashSetLinearProbingTest {

    @Test
    void testAddNewElement() {
        HashSetLinearProbing set = new HashSetLinearProbing(5);
        assertTrue(set.add("A"));
        assertTrue(set.contains("A"));
    }

    @Test
    void testAddDuplicateElement() {
        HashSetLinearProbing set = new HashSetLinearProbing(5);
        assertTrue(set.add("A"));
        assertFalse(set.add("A"));
        assertTrue(set.contains("A"));
    }

    @Test
    void testContainsOnEmptySet() {
        HashSetLinearProbing set = new HashSetLinearProbing(5);
        assertFalse(set.contains("X"));
    }

    @Test
    void testContainsNonExistingElement() {
        HashSetLinearProbing set = new HashSetLinearProbing(5);
        set.add("A");
        set.add("B");
        assertFalse(set.contains("C"));
    }

    @Test
    void testLinearProbingCollisionHandling() {
        HashSetLinearProbing set = new HashSetLinearProbing(2);
        assertTrue(set.add("A"));
        assertTrue(set.add("B"));
        assertTrue(set.contains("A"));
        assertTrue(set.contains("B"));
    }

    @Test
    void testAddUntilFull() {
        HashSetLinearProbing set = new HashSetLinearProbing(2);
        assertTrue(set.add("A"));
        assertTrue(set.add("B"));
        assertFalse(set.add("C"));
    }

    @Test
    void testHashCollisionWithDifferentObjects() {
        class CollisionObject {
            private final int id;
            public CollisionObject(int id) { this.id = id; }
            @Override
            public int hashCode() { return 1; } // all have same hash
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof CollisionObject)) return false;
                return this.id == ((CollisionObject) o).id;
            }
        }

        HashSetLinearProbing set = new HashSetLinearProbing(5);
        CollisionObject a = new CollisionObject(1);
        CollisionObject b = new CollisionObject(2);
        CollisionObject c = new CollisionObject(3);

        assertTrue(set.add(a));
        assertTrue(set.add(b));
        assertTrue(set.add(c));

        assertTrue(set.contains(a));
        assertTrue(set.contains(b));
        assertTrue(set.contains(c));
        assertFalse(set.contains(new CollisionObject(4)));
    }

    @Test
    void testRemoveExistingElement() {
        HashSetLinearProbing set = new HashSetLinearProbing(5);
        set.add("A");
        set.add("B");
        assertTrue(set.remove("A"));
        assertFalse(set.contains("A"));
        assertTrue(set.contains("B"));
    }

    @Test
    void testRemoveNonExistingElement() {
        HashSetLinearProbing set = new HashSetLinearProbing(5);
        set.add("A");
        assertFalse(set.remove("B"));
        assertTrue(set.contains("A"));
    }

    @Test
    void testRemoveAllElements() {
        HashSetLinearProbing set = new HashSetLinearProbing(5);
        set.add("A");
        set.add("B");
        set.add("C");

        assertTrue(set.remove("A"));
        assertTrue(set.remove("B"));
        assertTrue(set.remove("C"));

        assertFalse(set.contains("A"));
        assertFalse(set.contains("B"));
        assertFalse(set.contains("C"));
    }

    @Test
    void testRemoveWithCollisions() {
        class CollisionObject {
            private final int id;
            public CollisionObject(int id) { this.id = id; }
            @Override
            public int hashCode() { return 1; } // all have same hash
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof CollisionObject)) return false;
                return this.id == ((CollisionObject) o).id;
            }
        }

        HashSetLinearProbing set = new HashSetLinearProbing(5);
        CollisionObject a = new CollisionObject(1);
        CollisionObject b = new CollisionObject(2);
        CollisionObject c = new CollisionObject(3);

        set.add(a);
        set.add(b);
        set.add(c);

        assertTrue(set.remove(b));
        assertFalse(set.contains(b));
        assertTrue(set.contains(a));
        assertTrue(set.contains(c));

        assertFalse(set.remove(new CollisionObject(4)));
    }
}
