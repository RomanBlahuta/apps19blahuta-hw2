package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testPeek() {
        Queue queue = new Queue();
        queue.enqueue(1);
        assertEquals(queue.peek(), 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekEmpty() {
        Queue queue = new Queue();
        queue.peek();
    }



    @Test
    public void testEnqueueOne() {
        Queue queue = new Queue();
        queue.enqueue(33);
        assertEquals(queue.peek(), 33);
    }

    @Test
    public void testEnqueueTwo() {
        Queue queue = new Queue();
        queue.enqueue(33);
        queue.enqueue(1);
        queue.dequeue();
        assertEquals(queue.peek(), 1);
    }



    @Test
    public void testDequeue() {
        Queue queue = new Queue();
        queue.enqueue(33);
        queue.enqueue(2);
        queue.dequeue();
        assertEquals(queue.peek(), 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDequeueEmpty() {
        Queue queue = new Queue();
        queue.dequeue();
    }
}
