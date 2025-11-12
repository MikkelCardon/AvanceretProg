package Lektion06.personcollection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class PersonCollectionTest {

    private PersonCollection personCollection;

    @BeforeEach
    void setUp() {
        personCollection = new PersonCollection();
        personCollection.add(new Person("Flemming"));
        personCollection.add(new Person("Karl"));
    }

    @Test
    void iterator() {
        Iterator<Person> iterator = personCollection.iterator();

        assertNotNull(iterator);

        assertTrue(iterator.hasNext());
        assertEquals(new Person("Flemming"), iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(new Person("Karl"), iterator.next());

        assertFalse(iterator.hasNext());
        System.out.println(iterator.next());
    }

    @Test
    void catchConcurrentModificationException(){
        Iterator<Person> iterator = personCollection.iterator();

        assertTrue(iterator.hasNext());
        personCollection.add(new Person("Hans"));

        assertThrows(ConcurrentModificationException.class, () -> iterator.next());
    }

    @Test
    void catchConcurrentModificationException2(){
        Iterator<Person> iterator = personCollection.iterator();

        personCollection.add(new Person("Hans"));
        personCollection.remove(1);

        assertThrows(ConcurrentModificationException.class, () -> iterator.next());
    }

    @Test
    void printing() {
        Iterator<Person> iterator = personCollection.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}