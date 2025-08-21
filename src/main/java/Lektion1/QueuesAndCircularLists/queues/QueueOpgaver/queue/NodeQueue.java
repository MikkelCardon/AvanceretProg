package Lektion1.QueuesAndCircularLists.queues.QueueOpgaver.queue;

import java.util.NoSuchElementException;

/**
 * An implementation of a queue as a linked list.
 */
public class NodeQueue implements QueueI {

    public class Node{
        public Object data;
        public Node next;

        public Node(Object element){
            data = element;
        }
    }

    private int size = 0;
    private Node head;
    private Node tail;

    /**
     * Constructs an empty queue.
     */
    public NodeQueue() {
        // TODO: Assignment 1: Implement this constructor...
    }

    @Override
    public void enqueue(Object element) {
        if (this.isEmpty()){
            Node newNode = new Node(element);
            head = newNode;
            tail = newNode;
        }else{
            Node newNode = new Node(element);

            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public Object dequeue() {
        if (this.isEmpty()){
            throw new NoSuchElementException();
        }
        Node removed = head;
        head = head.next;
        size--;
        return removed.data;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty() {
      return size == 0;
    }
}
