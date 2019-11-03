package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList data;

    public Queue() {

        data = new ImmutableLinkedList();
    }

    public Object peek() {

        return data.getFirst();
    }



    public Object dequeue() {

        Object deq = data.getFirst();
        data = data.removeFirst();
        return deq;
    }



    public void enqueue(Object e) {

        data = data.addLast(e);
    }
}
