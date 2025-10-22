package Lektion06.personcollection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class PersonCollectionLinkTest {
    private PersonCollectionLink personCollectionLink;

    @BeforeEach
    void setUp() {
        personCollectionLink = new PersonCollectionLink();
        personCollectionLink.add(new Person("Flemming"));
        personCollectionLink.add(new Person("Hans"));
    }

    @Test
    void iterator() {
        Iterator<Person> iterator = personCollectionLink.iterator();

        assertNotNull(iterator);

        assertTrue(iterator.hasNext());
        assertEquals(new Person("Flemming"), iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(new Person("Hans"), iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    void catchConcurrentModificationException(){
        Iterator<Person> iterator = personCollectionLink.iterator();

        assertTrue(iterator.hasNext());
        personCollectionLink.add(new Person("Hans"));

        assertThrows(ConcurrentModificationException.class, () -> iterator.next());
    }

    @Test
    void catchConcurrentModificationException2(){
        Iterator<Person> iterator = personCollectionLink.iterator();

        personCollectionLink.add(new Person("Hans"));
        personCollectionLink.remove(1);

        assertThrows(ConcurrentModificationException.class, () -> iterator.next());
    }
}