package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList data;

    public Stack() {

        data = new ImmutableLinkedList();
    }



    public Object peek() {

        return data.getFirst();
    }



    public Object pop() {

        Object popped = data.getFirst();
        data = data.removeFirst();
        return popped;
    }



    public void push(Object e) {

        data = data.addFirst(e);
    }
}
