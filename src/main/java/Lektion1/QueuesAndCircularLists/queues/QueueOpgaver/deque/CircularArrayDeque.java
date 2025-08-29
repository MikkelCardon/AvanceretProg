package Lektion1.QueuesAndCircularLists.queues.QueueOpgaver.deque;

public class CircularArrayDeque implements DequeI{

    private Object[] elements;
    private int maxSize;
    private int currentSize = 0;
    private int head;
    private int tail;

    public CircularArrayDeque(){
        maxSize = 10;
        elements = new Object[maxSize];
        head = 0;
        tail = 0;
    }

    @Override
    public void addFirst(Object element) {
        growIfNecessary();
        int indexOfNewFirst;
        if (size() == 0){
            indexOfNewFirst = 0;
        }else{
            indexOfNewFirst = ((head-1)+maxSize) % maxSize;
        }

        currentSize++;
        head = indexOfNewFirst;
        elements[indexOfNewFirst] = element;
    }

    @Override
    public void addLast(Object element) {
        growIfNecessary();

        int indexOfNewFirst = (tail+1) % maxSize;
        currentSize++;
        tail = indexOfNewFirst;
        elements[indexOfNewFirst] = element;
    }

    @Override
    public Object removeFirst() {
        Object removed = elements[head];
        elements[head] = null;
        head++;
        currentSize--;
        return removed;
    }

    @Override
    public Object removeLast() {
        Object removed = elements[tail];
        elements[tail] = null;
        tail--;
        currentSize--;
        return removed;
    }

    @Override
    public Object getFirst() {
        return elements[head];
    }

    @Override
    public Object getLast() {
        return elements[tail];
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    private void growIfNecessary() {
        if (currentSize == maxSize)
        {
            Object[] newElements = new Object[2 * elements.length];
            for (int i = 0; i < elements.length; i++)
            {
                newElements[i] = elements[(head + i) % elements.length];
            }
            maxSize *= 2;
            elements = newElements;
            head = 0;
            tail = currentSize;
        }
    }
}
