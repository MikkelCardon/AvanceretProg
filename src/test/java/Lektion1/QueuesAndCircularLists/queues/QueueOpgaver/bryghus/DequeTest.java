package Lektion1.QueuesAndCircularLists.queues.QueueOpgaver.bryghus;

import Lektion1.QueuesAndCircularLists.queues.QueueOpgaver.deque.CircularArrayDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DequeTest {
    CircularArrayDeque deque;

    @BeforeEach
    void setUp() {
        deque = new CircularArrayDeque();
    }

    @Test
    void testAfAddFirst(){
        deque.addFirst(1);
        deque.addFirst(2);

        assertEquals(deque.getFirst(), 2);
        assertEquals(deque.getLast(), 1);

        deque.addLast(3);

        assertEquals(deque.getLast(), 3);
        assertEquals(deque.size(), 3);
    }
}
